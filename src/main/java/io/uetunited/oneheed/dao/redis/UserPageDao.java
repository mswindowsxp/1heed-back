package io.uetunited.oneheed.dao.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserPageDao {
    private static final String KEY = "USERID_";

    @Autowired
    @Qualifier("stringRedisTemplate")
    RedisTemplate<String, String> redisTemplate;

    public void mapUserToPage(String userId, String pageId) {
        redisTemplate.opsForValue().set(KEY + userId, pageId);
    }

    public String getPageIdFromUserId(String userId) {
        return redisTemplate.opsForValue().get(KEY + userId);
    }

    public void deleteMapUserToPage(String... userIds) {
        List<String> toDel = Arrays.asList(userIds).stream().map(s -> KEY + s).collect(Collectors.toList());
        redisTemplate.delete(toDel);
    }
}
