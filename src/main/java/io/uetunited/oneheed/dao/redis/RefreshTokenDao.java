package io.uetunited.oneheed.dao.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.uetunited.oneheed.payload.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Repository
@Transactional
public class RefreshTokenDao {
    private static final String PREFIX = "REFRESH_TOKEN_";

    @Autowired
    @Qualifier("refreshTokenRedisTemplate")
    RedisTemplate<String, User> redisTemplate;

    public void addRefreshToken(String refreshToken, User user, Long ttl) {
        redisTemplate.opsForValue().set(PREFIX + refreshToken, user, ttl, TimeUnit.MILLISECONDS);
    }

    public User getUserFromRefreshToken(String refreshToken) {
        return redisTemplate.opsForValue().get(PREFIX + refreshToken);
    }

    public void deleteRefreshToken(String... refreshTokens) {
        List<String> toDel = Arrays.asList(refreshTokens).stream().map(s -> PREFIX + s).collect(Collectors.toList());
        redisTemplate.delete(toDel);
    }

    public boolean checkIfRefreshTokenExists(String refreshToken) {
        return redisTemplate.hasKey(PREFIX + refreshToken);
    }
}
