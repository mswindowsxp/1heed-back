package io.uetunited.oneheed.payload.dto;

import io.uetunited.oneheed.constant.UserType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserDTO {
    @Column(name = "id")
    private String id;
    @Column(name = "email")
    private String email;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "social_id")
    private String socialId;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;
    @Column(name = "access_token")
    private String accessToken;
    @Column(name = "username")
    private String username;
}
