package io.uetunited.oneheed.controller;

import io.uetunited.oneheed.model.facebook.Tag;
import io.uetunited.oneheed.payload.request.RegisterPageRequest;
import io.uetunited.oneheed.security.CurrentUser;
import io.uetunited.oneheed.security.UserPrincipal;
import io.uetunited.oneheed.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    TagService tagService;

    /**
     * Using for update list tag for each
     *
     * @return empty while update success
     */
    @PostMapping("/update-tag-list")
    public ResponseEntity updateTagList() {
        return null;
    }

    /**
     * Using for get list tag has been created
     */
    @GetMapping
    public ResponseEntity getListTag(@CurrentUser UserPrincipal userPrincipal) {
            List<Tag> tagList = tagService.getListTag(userPrincipal.getId());
        if (CollectionUtils.isEmpty(tagList)) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(tagList);
        }
    }

    /**
     * Using for create a tag
     */
//    @RequestMapping(method = RequestMethod.POST, value = "/tag")
    @PostMapping
    public ResponseEntity createTag (@RequestBody Tag tag, @CurrentUser UserPrincipal userPrincipal) {
        tag.setPage_id(userPrincipal.getId());
        List<Tag> tagList = tagService.createTag(tag);
        if (CollectionUtils.isEmpty(tagList)) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(tagList);
        }
    }

}
