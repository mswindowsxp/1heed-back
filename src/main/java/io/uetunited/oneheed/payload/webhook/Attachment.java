package io.uetunited.oneheed.payload.webhook;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Attachment {
    private String type;
    private Payload payload;
    private String title;
    private String URL;

    @Getter
    @Setter
    public class Payload {
        private String url;
    }
}
