package io.uetunited.oneheed.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtAuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private String refreshToken = "";

    public JwtAuthenticationResponse() {
    }

    public JwtAuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }

}
