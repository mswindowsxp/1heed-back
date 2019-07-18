package io.uetunited.oneheed.payload.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@Setter
@Getter
public class Message {
    private String id;
    private String socialId;
    private String channel;
    private String conversationId;
    private String from;
    private String to;
    private String content;
    private Integer readStatus;
    private Integer sendStatus;
    private Date sendAt;
    private Date readAt;
    private String fromSocialId;
    private String toSocialId;
    private String messageDetail;
    
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
