package io.uetunited.oneheed.payload.webhook;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Referral {
    private String ref;
    private String source;
    private String type;
}
