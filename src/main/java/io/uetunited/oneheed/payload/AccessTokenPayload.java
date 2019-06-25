package io.uetunited.oneheed.payload;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AccessTokenPayload {
    private String accessToken;
    private String userId;
    private Date expires;

}
