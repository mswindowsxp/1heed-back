package io.uetunited.oneheed.dao.redis;

import io.uetunited.oneheed.payload.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Transactional
public class RefreshTokenDao {
    private static final String PREFIX = "REFRESH_TOKEN_";

    @Autowired
    RedisTemplate<String, User> redis;


    public void addRefreshToken(String refreshToken, User user) {
        redis.opsForValue().set(PREFIX + refreshToken, user);
    }

    public User getUserFromRefreshToken(String refreshToken) {
        return redis.opsForValue().get(PREFIX + refreshToken);
    }

    public long deleteRefreshToken(String... refreshTokens) {
        List<String> toDel = Arrays.asList(refreshTokens).stream().map(s -> PREFIX + s).collect(Collectors.toList());
        return redis.delete(toDel);
    }

    public boolean checkIfRefreshTokenExists(String refreshToken) {
        return redis.hasKey(PREFIX + refreshToken);
    }
}
