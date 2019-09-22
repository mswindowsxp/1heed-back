package io.uetunited.oneheed.payload.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@Setter
@Getter
public class Message {
    private String id;
    private String socialId;
    private String conversationId;
    private String conversationSocialId;
    private String fromUserId;
    private String fromSocialId;
    private String[] toUserIds;
    private String[] toSocialIds;
    private String message;
    private String sticker;
    private String attachments;
    private String shares;
    private Date sendAt;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
