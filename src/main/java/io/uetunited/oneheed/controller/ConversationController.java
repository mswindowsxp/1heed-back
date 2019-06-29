package io.uetunited.oneheed.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/conversation")
@Slf4j
public class ConversationController {
    public ResponseEntity getRecentConversation() {
        return null;
    }
}
