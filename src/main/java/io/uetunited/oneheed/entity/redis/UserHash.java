package io.uetunited.oneheed.entity.redis;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("User")
@Getter
@Setter
public class UserHash implements Serializable {
    private String id;
    private String name;
    private String token;
    private String socialToken;
}
