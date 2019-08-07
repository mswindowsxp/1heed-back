package io.uetunited.oneheed.service;

import io.uetunited.oneheed.client.FbClient;
import io.uetunited.oneheed.exception.ConnectException;
import io.uetunited.oneheed.exception.InvalidResponseException;
import io.uetunited.oneheed.model.facebook.Conversation;
import io.uetunited.oneheed.model.facebook.FacebookDataObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MsgDownloaderService {

    @Autowired
    FbClient fbClient;

    public void downloadAllMsgToDatabase(String fbPageId, String accessToken) {
        // download first 50 conversations
        try {
            FacebookDataObject<Conversation> result = fbClient.getRecentConversation(fbPageId, accessToken);
            List<Conversation> conversations = result.getData();
            for (Conversation c : conversations) {
                // insert into DB

            }
        } catch (InvalidResponseException e) {
            log.info("Could not get page conversations {}", e.getMessage(), e);
        } catch (ConnectException e) {
            log.info("Could not connect to FB graph API {}", e.getMessage(), e);
        }
        // enqueue job

    }
}
