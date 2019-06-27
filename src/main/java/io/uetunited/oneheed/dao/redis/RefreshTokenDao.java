package io.uetunited.oneheed.dao.redis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.uetunited.oneheed.payload.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.io.IOException;

@Repository
@Transactional
public class RefreshTokenDao {
    private static final String PREFIX = "REFRESH_TOKEN_";

    @Autowired
    Jedis jedis;

    @Autowired
    ObjectMapper mapper;


    public void addRefreshToken(String refreshToken, User user, Long ttl) throws JsonProcessingException {
        jedis.set(PREFIX + refreshToken, mapper.writeValueAsString(user), SetParams.setParams().px(ttl));
    }

    public User getUserFromRefreshToken(String refreshToken) throws IOException {
        String userJson = jedis.get(PREFIX + refreshToken);
        return mapper.readValue(userJson, User.class);
    }

    public void deleteRefreshToken(String... refreshTokens) {
        for (String refreshToken : refreshTokens) {
            jedis.del(PREFIX + refreshToken);
        }
    }

    public boolean checkIfRefreshTokenExists(String refreshToken) {
        return jedis.exists(PREFIX + refreshToken);
    }
}
