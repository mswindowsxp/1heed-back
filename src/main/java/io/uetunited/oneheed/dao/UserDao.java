package io.uetunited.oneheed.dao;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import io.uetunited.oneheed.dao.mapper.UserMapper;
import io.uetunited.oneheed.payload.dto.User;
import org.apache.commons.lang3.StringUtils;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class UserDao {

    @Autowired
    Jdbi jdbi = null;

    public Optional<User> getById(@Bind("id") String id) {
        String sql = "select * from users where id=:id";
        try (Handle handle = jdbi.open()) {
            return handle.createQuery(sql).bind("id", id).mapToBean(User.class).findFirst();
        }
    }

    public Optional<User> getBySocialId(@Bind("socialId") String socialId, @Bind("type") String type) {
        String sql = "select * from users where social_id=:socialId AND \"type\"=:type";
        try (Handle handle = jdbi.open()) {
            return handle.createQuery(sql).bind("socialId", socialId).bind("type", type).mapToBean(User.class).findFirst();
        }
    }

    public Optional<User> getByUsername(@Bind("username") String username) {
        String sql = "select * from users where username=:username limit 1";
        try (Handle handle = jdbi.open()) {
            return handle.createQuery(sql).bind("username", username).mapToBean(User.class).findFirst();
        }
    }

    public Optional<User> createUser(@Bind("id") String id, @Bind("email") String email, @Bind("name") String name, @Bind("type") String type,
                    @Bind("avatar") String avatar, @Bind("socialId") String socialId, @Bind("accessToken") String accessToken, @Bind("username") String username) {
        String sql = "insert into users\n" +
                "(id, created_at, updated_at, email, \"name\", \"type\", avatar, social_id, is_active, access_token, username)\n" +
                "VALUES(:id, now(), now(), :email, :name, :type, :avatar, :socialId, true, :accessToken, :username) on conflict (username) do update set access_token = EXCLUDED.access_token";
        try (Handle handle = jdbi.open()) {
            return handle.createUpdate(sql)
                    .bind("id", id).bind("email", email).bind("name", name).bind("avatar", avatar)
                    .bind("socialId", socialId).bind("accessToken", accessToken).bind("username", username)
                    .executeAndReturnGeneratedKeys().mapToBean(User.class).findFirst();
        }
    }

    public Optional<User> createOrUpdateUserAccessToken(User user) {
        if (StringUtils.isBlank(user.getId())) {
            user.setId(NanoIdUtils.randomNanoId());
        }
        return createUser(user.getId(), user.getEmail(), user.getName(), user.getType(), user.getAvatar(),
                user.getSocialId(), user.getAccessToken(), user.getUsername());
    }

}
