package io.uetunited.oneheed.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration
public class RedisConfig {
    @Value("${app.FB.messageTopic}")
    String FBMessageTopic;

    @Value("${app.redis.host}")
    String redisHost;

    @Value("${app.redis.port}")
    Integer redisPort;

    @Value("${app.redis.db}")
    Integer redisDb;

    @Value("${app.redis.auth}")
    String redisAuth;

    @Bean
    Jedis jedis() {
        Jedis jedis = new Jedis(redisHost, redisPort);
        if (StringUtils.isNotBlank(redisAuth)) {
            jedis.auth(redisAuth);
        }
        jedis.select(redisDb);
        return jedis;
    }
}
