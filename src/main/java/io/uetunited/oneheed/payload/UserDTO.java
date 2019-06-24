package io.uetunited.oneheed.payload;

import io.uetunited.oneheed.constant.UserType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.Date;
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
    private UserType type;
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "social_id")
    private String socialId;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;
    @Column(name = "access_token")
    private String accessToken;
    private List<RoleDTO> roles = new ArrayList<>();
}