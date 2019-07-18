/**
 * 
 */
package io.uetunited.oneheed.dao;

import java.util.Date;
import java.util.Optional;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import io.uetunited.oneheed.payload.dto.Message;
/**
 * @author la-pc
 *
 */
@Repository
public class MessageDao {
    @Autowired
    Jdbi jdbi = null;
    
    public Optional<Message> createMessage(Message message) {
        String sql = "insert into messages(id, social_id, channel, conversation_id, \"from\", \"to\", content, read_status, send_status, send_at, read_at, from_social_id, to_social_id, message_detail) values " +
                "(:id, :socialId, :channel, :conversationId, :from, :to, :content, :readStatus, :sendStatus, :sendAt, :readAt, :fromSocialId, :toSocialId, :messageDetail)";
        try (Handle handle = jdbi.open()) {
            return handle.createUpdate(sql)
                    .bind("id", message.getId()).bind("socialId", message.getSocialId()).bind("channel", message.getChannel())
                    .bind("conversationId", message.getConversationId()).bind("from", message.getFrom()).bind("to", message.getTo())
                    .bind("content", message.getContent()).bind("readStatus", message.getReadStatus()).bind("sendStatus", message.getSendStatus())
                    .bind("sendAt", message.getSendAt()).bind("readAt", message.getReadAt()).bind("fromSocialId", message.getFromSocialId())
                    .bind("toSocialId", message.getToSocialId()).bind("messageDetail", message.getMessageDetail())
                    .executeAndReturnGeneratedKeys().mapToBean(Message.class).findFirst();
        }
    }

}
