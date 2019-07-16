/**
 * 
 */
package io.uetunited.oneheed.dao;

import java.util.Date;
import java.util.Optional;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;

import io.uetunited.oneheed.payload.dto.Message;
/**
 * @author la-pc
 *
 */
public class MessageDao {
    @Autowired
    Jdbi jdbi = null;
    
    public Optional<Message> createMessage(String id,String socialId, String channel, String conversationId, 
            String from, String to, String content, Integer readStatus, Integer sendStatus, Date sendAt, Date readAt, 
            String fromSocialId, String toSocialId) {
        String sql = "insert into message(id, social_id, channel, conversation_id, from, to, content, read_status, send_status, send_at, read_at, from_social_id, to_social_id) values " +
                "(:id, :socialId, :name, :avatar, :accessToken, :type, :isActive) on conflict (social_id, \"type\") do update set access_token = EXCLUDED.access_token";
        try (Handle handle = jdbi.open()) {
            return handle.createUpdate(sql)
                    .bind("id", id).bind("socialId", socialId).bind("channel", channel)
                    .bind("conversationId", conversationId).bind("from", from).bind("to", to).bind("content", content)
                    .bind("readStatus", readStatus).bind("sendStatus", sendStatus).bind("sendAt", sendAt).bind("readAt", readAt)
                    .bind("fromSocialId", fromSocialId).bind("toSocialId", toSocialId)
                    .executeAndReturnGeneratedKeys().mapToBean(Message.class).findFirst();
        }
    }

}
