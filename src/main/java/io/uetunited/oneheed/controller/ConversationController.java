package io.uetunited.oneheed.controller;

import io.uetunited.oneheed.client.FbClient;
import io.uetunited.oneheed.exception.ConnectException;
import io.uetunited.oneheed.exception.InvalidResponseException;
import io.uetunited.oneheed.model.facebook.Conversation;
import io.uetunited.oneheed.model.facebook.FacebookDataObject;
import io.uetunited.oneheed.payload.dto.Page;
import io.uetunited.oneheed.security.CurrentUser;
import io.uetunited.oneheed.security.UserPrincipal;
import io.uetunited.oneheed.service.PageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ResponseEntity getRecentConversation(@CurrentUser UserPrincipal userPrincipal) throws InvalidResponseException, ConnectException {
        log.info("Current user {}", userPrincipal);
        Optional<Page> currentPage = pageService.getCurrentPageByUser(userPrincipal.getId());
        if (!currentPage.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        String fbPageId = currentPage.get().getSocialId();
        String pageAccessToken = currentPage.get().getAccessToken();

        FacebookDataObject<Conversation> conversations = fbClient.getRecentConversation(fbPageId, pageAccessToken);

        return ResponseEntity.ok(conversations);
    }
}
