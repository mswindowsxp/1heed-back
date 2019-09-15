package io.uetunited.oneheed.service;

import io.uetunited.oneheed.dao.tag.TagDao;
import io.uetunited.oneheed.model.facebook.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Service
public class TagService {

    @Autowired
    TagDao tagDao;

    public List<Tag> getListTag(String pageID) {
        return tagDao.getListTagByPageID(pageID);
    }

    public List<Tag> createTag(Tag tag) {
        List<Tag> tags = tagDao.getTagByTagID(tag.getId(), tag.getPage_id());
        if (CollectionUtils.isEmpty(tags)) {
            return tagDao.createTag(tag);
        }
        // TODO : Recover later for case create tag has been existed tag ID
//        else {
//            tagDao.deleteTagByTagID(tag.getId(), tag.getPage_id());
//            return tagDao.createTag(tag);
//        }
        return Collections.EMPTY_LIST;
    }
}
