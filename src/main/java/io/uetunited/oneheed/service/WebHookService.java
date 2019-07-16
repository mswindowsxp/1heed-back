/**
 * 
 */
package io.uetunited.oneheed.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.uetunited.oneheed.client.FbClient;
import io.uetunited.oneheed.dao.PageDao;
import io.uetunited.oneheed.model.facebook.MessageDetail;
import io.uetunited.oneheed.payload.dto.Page;
import io.uetunited.oneheed.payload.webhook.Messaging;
import io.uetunited.oneheed.payload.webhook.WebhookEvent;
import io.uetunited.oneheed.payload.webhook.WebhookEventEntry;
import lombok.extern.slf4j.Slf4j;

/**
 * @author la-pc
 *
 */
@Service
@Slf4j
public class WebHookService {
    @Autowired
    private FbClient fbClient;
    
    @Autowired
    private PageDao pageDao;
    
    public void handleWebHookEvent(WebhookEvent event) {
        for (WebhookEventEntry entry: event.getEntry()) {
            for (Messaging mes: entry.getMessaging()) {
                try {
                  //Look for access_token from pages table
                    Optional<Page> page = pageDao.getById(mes.getRecipient().getId());
                    if (page.isPresent()) {
                        String accessToken = page.get().getAccessToken();
                        MessageDetail detail = fbClient.getMessageDetail(mes.getMessage().getMid(), accessToken);
                    }
                    
                    //Map and save to DB
                } catch (Exception ex) {
                    log.error("Error when handle mes {}, exception {}", mes, ex);
                }
                
            }
        }
    }

}
