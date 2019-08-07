package io.uetunited.oneheed.payload.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Conversation {
    private String id;
    private String socialId;
    private String link;

    // message count
    private Integer messageCount;
    private Integer unreadCount;

    // relation
    private String pageId;
    private String pageSocialId;
    // reserve for user handling
    private String handlerId;
    private String handlerSocialId;
}
