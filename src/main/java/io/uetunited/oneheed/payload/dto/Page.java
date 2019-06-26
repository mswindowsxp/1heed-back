package io.uetunited.oneheed.payload.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Page {
    private String id;
    private String socialId;
    private String name;
    private String avatar;
    private String accessToken;
    private String type;
    private Boolean isActive;
}
