package io.uetunited.oneheed.dao;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import io.uetunited.oneheed.payload.dto.User;
import org.apache.commons.lang3.StringUtils;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class UserDao {

    @Autowired
    Jdbi jdbi = null;

    public Optional<User> getById(String id) {
        String sql = "select * from users where id=:id";
        try (Handle handle = jdbi.open()) {
            return handle.createQuery(sql).bind("id", id).mapToBean(User.class).findFirst();
        }
    }

    public Optional<User> getBySocialId(String socialId, String type) {
        String sql = "select * from users where social_id=:socialId AND \"type\"=:type";
        try (Handle handle = jdbi.open()) {
            return handle.createQuery(sql).bind("socialId", socialId).bind("type", type).mapToBean(User.class).findFirst();
        }
    }

    public Optional<User> getByUsername(String username) {
        String sql = "select * from users where username=:username limit 1";
        try (Handle handle = jdbi.open()) {
            return handle.createQuery(sql).bind("username", username).mapToBean(User.class).findFirst();
        }
    }

    public Optional<User> createUser(String id, String email, String name, String type, String avatar, String socialId, boolean isActive, String accessToken, String username) {
        String sql = "insert into users\n" +
                "(id, created_at, updated_at, email, \"name\", \"type\", avatar, social_id, is_active, access_token, username)\n" +
                "VALUES(:id, now(), now(), :email, :name, :type, :avatar, :socialId, :isActive, :accessToken, :username) on conflict (username) do update set access_token = EXCLUDED.access_token";
        try (Handle handle = jdbi.open()) {
            return handle.createUpdate(sql)
                    .bind("id", id).bind("email", email).bind("name", name).bind("avatar", avatar).bind("type", type)
                    .bind("socialId", socialId).bind("accessToken", accessToken).bind("username", username).bind("isActive", isActive)
                    .executeAndReturnGeneratedKeys().mapToBean(User.class).findFirst();
        }
    }

    public Optional<User> createOrUpdateUserAccessToken(User user) {
        if (StringUtils.isBlank(user.getId())) {
            user.setId(NanoIdUtils.randomNanoId());
        }
        return createUser(user.getId(), user.getEmail(), user.getName(), user.getType(), user.getAvatar(),
                user.getSocialId(), user.getIsActive(), user.getAccessToken(), user.getUsername());
    }

}
