package io.uetunited.oneheed.dao.tag;

import io.uetunited.oneheed.model.facebook.Tag;
import io.uetunited.oneheed.payload.dto.Page;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.statement.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TagDao {

    @Autowired
    Jdbi jdbi = null;

    public List<Tag> getListTagByPageID (String pageID) {
        String sql = "select * from tags where page_id=:pageID";
        try(Handle handle = jdbi.open()) {
            return handle.createQuery(sql).bind("pageID", pageID).mapToBean(Tag.class).list();
        }
    }

    public List<Tag> createTag(Tag tagInput) {
        String sql = "insert into tags(id, name, page_id, color) values " +
                "(:id, :name, :page_id, :color)";
        try (Handle handle = jdbi.open()) {
            return handle.createUpdate(sql)
                    .bind("id", tagInput.getId()).bind("name", tagInput.getName())
                    .bind("page_id", tagInput.getPage_id()).bind("color", tagInput.getColor())
                    .executeAndReturnGeneratedKeys().mapToBean(Tag.class).list();
        }
    }

    public List<Tag> getTagByTagID(String tagID, String pageID) {
        String sql = "select * from tags where page_id=:pageID and id=:tagID";
        try(Handle handle = jdbi.open()) {
            return handle.createQuery(sql).bind("pageID", pageID).bind("tagID", tagID).mapToBean(Tag.class).list();
        }
    }

    public void deleteTagByTagID(String tagID, String pageID) {
        String sql = "delete from tags where page_id=:pageID and id like :tagID";
        try(Handle handle = jdbi.open()) {
            Tag bind = handle.createQuery(sql).bind("pageID", pageID).bind("tagID", tagID).mapToBean(Tag.class).findOnly();
        }
    }
}
