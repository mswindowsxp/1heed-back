package io.uetunited.oneheed.model.facebook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.uetunited.oneheed.constant.UserType;
import io.uetunited.oneheed.model.facebook.Picture;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserData {
    private String name;
    private Picture picture;
    private String id;
    private String email;
    @JsonProperty(value = "access_token", access = JsonProperty.Access.WRITE_ONLY)
    private String accessToken;
    private String userType;
}
