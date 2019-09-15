package io.uetunited.oneheed.service;

import io.uetunited.oneheed.dao.tag.TagConversationDao;
import io.uetunited.oneheed.dao.tag.TagDao;
import io.uetunited.oneheed.model.facebook.Tag;
import io.uetunited.oneheed.model.facebook.TagConversation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Service
public class TagConversationService {

    @Autowired
    TagConversationDao tagConversationDao;

    public List<TagConversation> getListConversationHasBeenTaged(TagConversation tagConversation) {
        return tagConversationDao.tagConversation(tagConversation);
    }

    public List<TagConversation> tagConversation(TagConversation tagConversation) {
        return tagConversationDao.tagConversation(tagConversation);
    }

    public List<TagConversation> deleteTag(TagConversation tagConversation) {
        return tagConversationDao.deleteTagForConversation(tagConversation);
    }
}
