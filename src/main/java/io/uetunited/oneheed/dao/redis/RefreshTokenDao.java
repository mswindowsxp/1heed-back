package io.uetunited.oneheed.dao.redis;

import io.uetunited.oneheed.payload.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class RefreshTokenDao {
    private static final String KEY = "REFRESH_TOKEN";

    @Autowired
    RedisTemplate<String, User> redis;

    HashOperations<String, String, User> hashOps = redis.opsForHash();

    public void addRefreshToken(String refreshToken, User user) {
        hashOps.put(KEY, refreshToken, user);
    }

    public User getUserFromRefreshToken(String refreshToken) {
        return hashOps.get(KEY, refreshToken);
    }

    public long deleteRefreshToken(String... refreshTokens) {
        return hashOps.delete(KEY, refreshTokens);
    }

    public boolean checkIfRefreshTokenExists(String refreshToken) {
        return hashOps.get(KEY, refreshToken) != null;
    }
}
