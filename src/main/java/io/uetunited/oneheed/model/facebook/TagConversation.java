package io.uetunited.oneheed.model.facebook;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TagConversation {
    private String tag_id;
    private String customer_id;
    private String conversation_id;
    private String create_by;
    private String create_at;
    private Date expire;
}
