package io.uetunited.oneheed.dao.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

@Repository
public class TokenDao {
    private static final String KEY = "TOKEN_";

    @Value("${app.jwtExpirationInMs}")
    Long jwtExpires;

    @Autowired
    Jedis jedis;

    public void addToken(String token) {
        jedis.set(KEY + token, "", SetParams.setParams().px(jwtExpires));
    }

    public boolean checkIfTokenExist(String token) {
        return jedis.exists(KEY + token);
    }

    public void deleteToken(String... tokens) {
        for (String token : tokens) {
            jedis.del(KEY + token);
        }
    }
}
