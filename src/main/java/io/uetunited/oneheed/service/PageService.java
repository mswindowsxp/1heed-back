package io.uetunited.oneheed.service;

import io.uetunited.oneheed.client.FbClient;
import io.uetunited.oneheed.exception.ConnectException;
import io.uetunited.oneheed.exception.InvalidResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PageService {

    @Autowired
    FbClient fbClient;

    public void registerPage(String pageId, String shortLiveAccessToken) throws InvalidResponseException, ConnectException {
        String longLiveAccessToken = fbClient.getLongLiveToken(shortLiveAccessToken);
        fbClient.subscribeToPage(longLiveAccessToken);
    }
}
