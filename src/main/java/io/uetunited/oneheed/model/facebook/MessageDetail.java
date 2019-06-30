package io.uetunited.oneheed.model.facebook;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MessageDetail {
    private String id;
    private String message;
    private String sticker;
    private UserData from;
    private FacebookDataObject<UserData> to;
    private FacebookDataObject<Tag> tags;
    private FacebookDataObject<Share> shares;
    private FacebookDataObject<Attachment> attachments;
    @JsonProperty("created_time")
    private Date createdTime;
}
