package io.uetunited.oneheed.dao.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TokenDao {
    private static final String KEY = "TOKEN";

    @Autowired
    StringRedisTemplate redis;

    public void addToken(String token) {
        redis.opsForSet().add(KEY, token);
    }

    public boolean checkIfTokenExist(String token) {
        return redis.opsForSet().isMember(KEY, token);
    }

    public long deleteRefreshToken(String... tokens) {
        return redis.opsForSet().remove(KEY, tokens);
    }
}
