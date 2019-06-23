package io.uetunited.oneheed.payload;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Setter
@Getter
public class MessageDTO {
    @Column(name = "id")
    private String id;
    @Column(name = "social_id")
    private String socialId;
    @Column(name = "channel")
    private String channel;
    @Column(name = "conversation_id")
    private String conversationId;
    @Column(name = "from")
    private String from;
    @Column(name = "to")
    private String to;
    @Column(name = "content")
    private String content;
    @Column(name = "read_status")
    private Integer readStatus;
    @Column(name = "send_status")
    private Integer sendStatus;
    @Column(name = "send_at")
    private Date sendAt;
    @Column(name = "read_at")
    private Date readAt;
    @Column(name = "from_social_id")
    private String fromSocialId;
    @Column(name = "to_social_id")
    private String toSocialId;
}
