package io.uetunited.oneheed.payload.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Page {
    private String id;
    private String socialId;
    private String name;
    private String avatar;
    @JsonIgnore
    private String accessToken;
    private String type;
    @JsonIgnore
    private Boolean isActive = true;
}
