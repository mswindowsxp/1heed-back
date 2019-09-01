package io.uetunited.oneheed.controller;

import io.uetunited.oneheed.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    TagService tagService;
    /**
     * Using for update list tag for each
     * @return empty while update success
     */
    @PostMapping("/update-tag-list")
    public ResponseEntity updateTagList() {
        return null;
    }

    /**
     * Using for get list tag has been
     */
    @GetMapping("/")
    public ResponseEntity getListTag() {


    }

    /**
     * Using for tag a conversation
     */
    @PostMapping("/")
    public ResponseEntity tagConversation () {
        return null;
    }

}
