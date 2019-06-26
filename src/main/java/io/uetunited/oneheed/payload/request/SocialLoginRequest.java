package io.uetunited.oneheed.payload.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SocialLoginRequest {
    private String accessToken;
    private String userId;
    private Date expires;

}
