package io.uetunited.oneheed.dao;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import io.uetunited.oneheed.dao.mapper.UserMapper;
import io.uetunited.oneheed.payload.dto.User;
import org.apache.commons.lang3.StringUtils;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao {

    @Autowired
    Jdbi jdbi = null;

    @SqlQuery("select * from users where id=:id limit 1")
    @RegisterRowMapper(UserMapper.class)
    User getById(@Bind("id") String id);

    @SqlQuery("select * from users where social_id=:socialId AND \"type\"=:type limit 1")
    @RegisterRowMapper(UserMapper.class)
    User getBySocialId(@Bind("socialId") String socialId, @Bind("type") String type);

    @SqlQuery("select * from users where username=:username limit 1")
    @RegisterRowMapper(UserMapper.class)
    User getByUsername(@Bind("username") String username);

    @SqlQuery("insert into users\n" +
            "(id, created_at, updated_at, email, \"name\", \"type\", avatar, social_id, is_active, access_token, username)\n" +
            "VALUES(:id, now(), now(), :email, :name, :type, :avatar, :socialId, true, :accessToken, :username) on conflict (username) do update set access_token = EXCLUDED.access_token;")
    @RegisterRowMapper(UserMapper.class)
    @GetGeneratedKeys
    User createUser(@Bind("id") String id, @Bind("email") String email, @Bind("name") String name, @Bind("type") String type,
                    @Bind("avatar") String avatar, @Bind("socialId") String socialId, @Bind("accessToken") String accessToken, @Bind("username") String username);

    default User createOrUpdateUserAccessToken(User user) {
        if (StringUtils.isBlank(user.getId())) {
            user.setId(NanoIdUtils.randomNanoId());
        }
        return createUser(user.getId(), user.getEmail(), user.getName(), user.getType(), user.getAvatar(),
                user.getSocialId(), user.getAccessToken(), user.getUsername());
    }

}
