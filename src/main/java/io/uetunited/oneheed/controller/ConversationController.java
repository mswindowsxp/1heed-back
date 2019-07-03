package io.uetunited.oneheed.controller;

import io.uetunited.oneheed.client.FbClient;
import io.uetunited.oneheed.exception.ConnectException;
import io.uetunited.oneheed.exception.InvalidResponseException;
import io.uetunited.oneheed.model.facebook.Conversation;
import io.uetunited.oneheed.model.facebook.FacebookDataObject;
import io.uetunited.oneheed.payload.dto.Page;
import io.uetunited.oneheed.service.PageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/conversation")
@Slf4j
public class ConversationController {

    @Autowired
    PageService pageService;

    @Autowired
    FbClient fbClient;

    @GetMapping
    public ResponseEntity getRecentConversation(@RequestParam("pageId") String pageId) throws InvalidResponseException, ConnectException {
        Optional<Page> pageOptional = pageService.getPageById(pageId);
        if (!pageOptional.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        String fbPageId = pageOptional.get().getSocialId();
        String pageAccessToken = pageOptional.get().getAccessToken();

        FacebookDataObject<Conversation> conversations = fbClient.getRecentConversation(pageId, pageAccessToken);

        return ResponseEntity.ok(conversations);
    }
}
