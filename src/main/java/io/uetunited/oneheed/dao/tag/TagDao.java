package io.uetunited.oneheed.dao.tag;

import io.uetunited.oneheed.model.facebook.Tag;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TagDao {

    @Autowired
    Jdbi jdbi = null;

    public List<Tag> getListTagByPageID (String pageID) {
        String sql = "select * from tag where pageID=:pageID";
        try(Handle handle = jdbi.open()) {
            return handle.createQuery(sql).bind("pageID", pageID).mapToBean(Tag.class).list();
        }
    }
}
