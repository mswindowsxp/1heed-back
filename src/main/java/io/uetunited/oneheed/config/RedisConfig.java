package io.uetunited.oneheed.config;

import io.uetunited.oneheed.payload.dto.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

@Configuration
public class RedisConfig {
    @Value("${app.FB.messageTopic}")
    String FBMessageTopic;

    @Value("${app.redis.host}")
    String redisHost;

    @Value("${app.redis.port}")
    String redisPort;

    @Value("${app.redis.db}")
    String redisDb;

    @Value("${app.redis.auth}")
    String redisAuth;

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConFactory
                = new JedisConnectionFactory();
        jedisConFactory.setHostName(redisHost);
        jedisConFactory.setPort(Integer.parseInt(redisPort));
        jedisConFactory.setDatabase(Integer.parseInt(redisDb));
        jedisConFactory.setPassword(redisAuth);
        return jedisConFactory;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
        return template;
    }

    @Bean
    RedisTemplate<String, User> refreshTokenRedisTemplate() {
        RedisTemplate<String, User> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setEnableTransactionSupport(true);
        return template;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate() {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate(jedisConnectionFactory());
        stringRedisTemplate.setEnableTransactionSupport(true);
        return stringRedisTemplate;
    }

    @Bean(name = "FBMessageTopic")
    public ChannelTopic channelTopic() {
        return new ChannelTopic(FBMessageTopic);
    }


}
