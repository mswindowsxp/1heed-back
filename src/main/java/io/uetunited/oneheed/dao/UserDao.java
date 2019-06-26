package io.uetunited.oneheed.dao;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import io.uetunited.oneheed.dao.mapper.UserMapper;
import io.uetunited.oneheed.payload.dto.UserDTO;
import org.apache.commons.lang3.StringUtils;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao {

    @SqlQuery("select * from users where id=:id limit 1")
    @RegisterRowMapper(UserMapper.class)
    UserDTO getById(@Bind("id") String id);

    @SqlQuery("select * from users where social_id=:socialId AND \"type\"=:type limit 1")
    @RegisterRowMapper(UserMapper.class)
    UserDTO getBySocialId(@Bind("socialId") String socialId, @Bind("type") String type);

    @SqlQuery("select * from users where username=:username limit 1")
    @RegisterRowMapper(UserMapper.class)
    UserDTO getByUsername(@Bind("username") String username);

    public UserDTO createOrUpdateUserAccessToken(UserDTO userDTO) {
        String sql = "INSERT INTO users\n" +
                "(id, created_at, updated_at, email, \"name\", \"type\", avatar, social_id, is_active, access_token, username)\n" +
                "VALUES('', now(), now(), '', '', '', '', '', true, '', '');\n";

        if (StringUtils.isBlank(userDTO.getId())) {
            userDTO.setId(NanoIdUtils.randomNanoId());
        }
        UsersRecord record = context.newRecord(USERS);
        record.setId(userDTO.getId());
        record.setCreatedAt(userDTO.getCreatedAt());
        record.setUpdatedAt(null);
        record.setEmail(userDTO.getEmail());
        record.setName(userDTO.getName());
        record.setType(userDTO.getType().name());
        record.setAvatar(userDTO.getAvatar());
        record.setSocialId(userDTO.getSocialId());
        record.setIsActive(userDTO.getIsActive());
        record.setAccessToken(userDTO.getAccessToken());
        record.setUsername(userDTO.getUsername());
        context.update(USERS).set(record);
        return userDTO;
    }

    boolean checkIfUserExists(String socialId, String type) {
        String sql = "SELECT count(id) FROM users WHERE social_id=:socialId AND \"type\"=:type";

        try (Connection con = sql2o.open()) {
            return con.createQuery(sql).addParameter("socialId", socialId).addParameter("type", type).executeScalar(Integer.class) > 0;
        }

    }
}
