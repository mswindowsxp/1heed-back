package io.uetunited.oneheed.dao.tag;

import io.uetunited.oneheed.model.facebook.Tag;
import io.uetunited.oneheed.model.facebook.TagConversation;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TagConversationDao {
    @Autowired
    Jdbi jdbi = null;

    public List<TagConversation> tagConversation(TagConversation tagInput) {
        String sql = "insert into tag_conversations(tag_id, customer_id, conversation_id, created_by) VALUES (:tagID,:customerID,:conversationID,:userID)";
        try (Handle handle = jdbi.open()) {
            return handle.createUpdate(sql)
                    .bind("tagID", tagInput.getTag_id())
                    .bind("customerID", tagInput.getCustomer_id())
                    .bind("conversationID", tagInput.getConversation_id())
                    .bind("userID", tagInput.getCreate_by())
                    .executeAndReturnGeneratedKeys().mapToBean(TagConversation.class).list();
        }
    }

    public List<TagConversation> deleteTagForConversation(TagConversation tagInput) {
        String sql = "delete from tag_conversations where tag_id =:tagID and conversation_id = :conversationID and customer_id = :userID";
        try (Handle handle = jdbi.open()) {
            return handle.createUpdate(sql)
                    .bind("tagID", tagInput.getTag_id())
                    .bind("conversationID", tagInput.getConversation_id())
                    .bind("userID", tagInput.getCreate_by())
                    .executeAndReturnGeneratedKeys().mapToBean(TagConversation.class).list();
        }
    }
}
