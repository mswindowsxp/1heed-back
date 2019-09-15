package io.uetunited.oneheed.controller;

import io.uetunited.oneheed.model.facebook.Tag;
import io.uetunited.oneheed.model.facebook.TagConversation;
import io.uetunited.oneheed.security.CurrentUser;
import io.uetunited.oneheed.security.UserPrincipal;
import io.uetunited.oneheed.service.TagConversationService;
import io.uetunited.oneheed.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag-conversation")
public class TagConversationController {
    @Autowired
    TagConversationService tagConversationService;

    /**
     * Using for get list tag has been created
     */
    @GetMapping
    public ResponseEntity getListConversationHasBeenTagTag(@CurrentUser TagConversation userPrincipal) {
        List<TagConversation> tagList = tagConversationService.getListConversationHasBeenTaged(userPrincipal);
        if (CollectionUtils.isEmpty(tagList)) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(tagList);
        }
    }

    /**
     * Using for create a tag
     */
    @PostMapping
    public ResponseEntity createNewTagForConversation (@RequestBody TagConversation tagConversation, @CurrentUser UserPrincipal userPrincipal) {
        List<TagConversation> tagList = tagConversationService.tagConversation(tagConversation);
        if (CollectionUtils.isEmpty(tagList)) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(tagList);
        }
    }

    /**
     * Using for create a tag
     */
    @DeleteMapping
    public ResponseEntity deleteTagForConversation (@RequestBody TagConversation tag, @CurrentUser UserPrincipal userPrincipal) {
        List<TagConversation> tagList = tagConversationService.deleteTag(tag);
        if (CollectionUtils.isEmpty(tagList)) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(tagList);
        }
    }
}
