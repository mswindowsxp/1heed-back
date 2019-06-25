package io.uetunited.oneheed.payload;

import io.uetunited.oneheed.model.UserInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
    private String token;
    private String refreshToken;
    private UserInfo user;
}
