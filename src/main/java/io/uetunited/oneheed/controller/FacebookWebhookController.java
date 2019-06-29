/**
 *
 */
package io.uetunited.oneheed.controller;

import io.uetunited.oneheed.payload.webhook.WebhookEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author la-pc
 *
 */
@RestController
@RequestMapping("/webhook/facebook")
@Slf4j
public class FacebookWebhookController {
    private static final String EVENT_RECEIVED = "EVENT_RECEIVED";
    private static final String SUBSCRIBE = "subscribe";
    @Value("${app.verify.token}")
    String verify_token;

    @PostMapping
    public ResponseEntity<?> postEvent(@Valid @RequestBody WebhookEvent webhookEvent) {
        log.info("webhookEvent: {}", webhookEvent);
        return ResponseEntity.ok(EVENT_RECEIVED);
    }

    @GetMapping
    public ResponseEntity verifyWebhook(@RequestParam(value = "hub.mode") String mode,
                                        @RequestParam(value = "hub.verify_token") String verifyToken,
                                        @RequestParam(value = "hub.challenge") String challenge) {
        if (StringUtils.isNotBlank(mode) && StringUtils.isNotBlank(verifyToken)) {
            if (SUBSCRIBE.equalsIgnoreCase(mode) && verify_token.equalsIgnoreCase(verifyToken)) {
                log.debug("WEBHOOK_VERIFIED");
                return ResponseEntity.ok(challenge);
            } else {
                return ResponseEntity.status(403).build();
            }
        }
        return ResponseEntity.status(403).build();
    }
}
