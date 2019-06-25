package io.uetunited.oneheed.payload.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
public class ConversationDTO {
    @Column(name = "id")
    private String id;
    @Column(name = "page_id")
    private String pageId;
    @Column(name = "customer_id")
    private String customerId;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "status")
    private String status;
    @Column(name = "start_at")
    private Date startAt;
    @Column(name = "end_at")
    private Date endAt;
    @Column(name = "channel")
    private String channel;
}
