package io.uetunited.oneheed.dao.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Repository
public class TokenDao {
    private static final String KEY = "TOKEN_";

    @Value("${app.jwtExpirationInMs}")
    Long jwtExpires;

    @Autowired
    @Qualifier("generalRedisTemplate")
    RedisTemplate<String, Object> redisTemplate;

    public void addToken(String token) {
        redisTemplate.opsForValue().set(KEY + token, "", jwtExpires, TimeUnit.MILLISECONDS);
    }

    public boolean checkIfTokenExist(String token) {
        return redisTemplate.hasKey(KEY + token);
    }

    public void deleteToken(String... tokens) {
        List<String> toDel = Arrays.asList(tokens).stream().map(s -> KEY + s).collect(Collectors.toList());
        redisTemplate.delete(toDel);
    }
}
