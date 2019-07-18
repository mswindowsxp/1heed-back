/**
 * 
 */
package io.uetunited.oneheed.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.uetunited.oneheed.client.FbClient;
import io.uetunited.oneheed.dao.MessageDao;
import io.uetunited.oneheed.dao.PageDao;
import io.uetunited.oneheed.model.facebook.MessageDetail;
import io.uetunited.oneheed.payload.dto.Message;
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
    
    @Autowired
    private MessageDao messageDao;    
    @Autowired
    private ObjectMapper mapper;
    
    public static void main(String[] args) {
        String id = NanoIdUtils.randomNanoId();
        System.out.println(id);
    }
    
    public void handleWebHookEvent(WebhookEvent event) {
        for (WebhookEventEntry entry: event.getEntry()) {
            for (Messaging mes: entry.getMessaging()) {
                Message messageDto = null;
                try {
                    //Look for access_token from pages table
                    Optional<Page> page = pageDao.getById(mes.getRecipient().getId());
                    if (page.isPresent()) {
                        String accessToken = page.get().getAccessToken();
                        MessageDetail detail = fbClient.getMessageDetail(mes.getMessage().getMid(), accessToken);
                        messageDto = mapFromFBResponseToMessageDTO(detail);
                    } else {
                        log.warn("Can't find page for mes {}", mes);
                    }
                    
                    //Map and save to DB
                    if (Objects.nonNull(messageDto)) {                        
                        Message savedMessage = messageDao.createMessage(messageDto).get();
                        log.debug("Message was saved to databse {}", savedMessage);
                    }
                } catch (Exception ex) {
                    log.error("Error when handle mes {}, exception {}", mes, ex);
                }
                
            }
        }
    }

    private Message mapFromFBResponseToMessageDTO(MessageDetail detail) throws JsonProcessingException {
        Message dto = new Message();
        dto.setId(NanoIdUtils.randomNanoId());
        dto.setSocialId(detail.getId());
        dto.setMessageDetail(mapper.writeValueAsString(detail));
        dto.setFrom(mapper.writeValueAsString(detail.getFrom()));
        dto.setTo(mapper.writeValueAsString(detail.getTo()));
        dto.setContent(detail.getMessage());
        dto.setFromSocialId(detail.getFrom().getId());
        dto.setToSocialId(detail.getTo().getData().get(0).getId());
        return dto;
    }

}
