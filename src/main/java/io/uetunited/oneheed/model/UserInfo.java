package io.uetunited.oneheed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.uetunited.oneheed.constant.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfo {
    private String name;
    private Picture picture;
    private String id;
    private String email;
    @JsonProperty("access_token")
    private String accessToken;
    private UserType userType;
}
