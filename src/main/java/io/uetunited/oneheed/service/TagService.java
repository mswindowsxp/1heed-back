package io.uetunited.oneheed.service;

import io.uetunited.oneheed.dao.tag.TagDao;
import io.uetunited.oneheed.model.facebook.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    TagDao tagDao;

    public List<Tag> getListTag(String pageID) {
        return tagDao.getListTagByPageID(pageID);
    }
}
