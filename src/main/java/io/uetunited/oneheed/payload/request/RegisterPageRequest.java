package io.uetunited.oneheed.payload.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterPageRequest {
    private String id;
    private String name;
    private String avatar;
    private String accessToken;
}
