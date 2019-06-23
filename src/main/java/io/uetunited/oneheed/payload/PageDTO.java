package io.uetunited.oneheed.payload;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class PageDTO {
    @Column(name = "id")
    private String id;
    @Column(name = "social_id")
    private String socialId;
    @Column(name = "name")
    private String name;
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "access_token")
    private String accessToken;
    @Column(name = "type")
    private String type;
    @Column(name = "is_active")
    private Boolean isActive;
}
