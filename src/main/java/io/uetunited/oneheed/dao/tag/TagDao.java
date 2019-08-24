package io.uetunited.oneheed.dao.tag;

import io.uetunited.oneheed.model.facebook.Tag;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TagDao {

    @Autowired
    Jdbi jdbi = null;

    public Optional<List<Tag>> getListTag (String pageID) {}
}
