package io.uetunited.oneheed.payload.webhook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Message {
    private String mid;
    private String text;
    @JsonProperty("quick_reply")
    private Reply quickReply;
    private List<Attachment> attachments;

    @JsonProperty("is_echo")
    private Boolean isEcho;
    @JsonProperty("app_id")
    private String appId;
    private String metadata;
}
