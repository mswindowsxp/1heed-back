package io.uetunited.oneheed.model.facebook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Conversation {
    private String id;
    private String link;
    @JsonProperty("updated_time")
    private String updatedTime;
    private FacebookDataObject<UserData> senders;

    @JsonProperty("unread_count")
    private Integer unreadCount;
    @JsonProperty("message_count")
    private Integer messageCount;
    @JsonProperty("participants")
    private FacebookDataObject<UserData> participants;
    @JsonProperty("messages")
    private FacebookDataObject<MessageDetail> messages;
}
