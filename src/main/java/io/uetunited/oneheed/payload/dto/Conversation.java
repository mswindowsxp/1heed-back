package io.uetunited.oneheed.payload.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Conversation {
    private String id;
    private String pageId;
    private String customerId;
    private String userId;
    private String status;
    private Date startAt;
    private Date endAt;
    private String channel;
}
