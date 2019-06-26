package io.uetunited.oneheed.payload.response;

import io.uetunited.oneheed.payload.dto.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
    private String token;
    private String refreshToken;
    private User user;
}
