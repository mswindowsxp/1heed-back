package io.uetunited.oneheed.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.uetunited.oneheed.payload.dto.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

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

    @Autowired
    ObjectMapper mapper;

    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(redisHost, redisPort);
        config.setDatabase(redisDb);
        if (StringUtils.isNotBlank(redisAuth)) {
            config.setPassword(RedisPassword.of(redisAuth));
        }
        return new JedisConnectionFactory(config);
    }

    @Bean("generalRedisTemplate")
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer(mapper));
        return redisTemplate;
    }

    @Bean("refreshTokenRedisTemplate")
    public RedisTemplate<String, User> refreshTokenRedisTemplate() {
        RedisTemplate<String, User> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer(mapper));
        return redisTemplate;
    }

}
