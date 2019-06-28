package io.uetunited.oneheed.service;

import io.uetunited.oneheed.client.FbClient;
import io.uetunited.oneheed.dao.PageDao;
import io.uetunited.oneheed.exception.ConnectException;
import io.uetunited.oneheed.exception.InvalidResponseException;
import io.uetunited.oneheed.payload.dto.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PageService {

    @Autowired
    FbClient fbClient;

    @Autowired
    PageDao pageDao;

    public void registerPage(String pageId, String pageName, String shortLiveAccessToken) throws InvalidResponseException, ConnectException {
        String longLiveAccessToken = fbClient.getLongLiveToken(shortLiveAccessToken);
        fbClient.subscribeToPage(longLiveAccessToken);
        savePageToDb(pageId, pageName, longLiveAccessToken);
    }

    private void savePageToDb(String pageId, String pageName, String accessToken) {
        Page page = new Page();
        page.setSocialId(pageId);
        page.setName(pageName);
        page.setAccessToken(accessToken);
        pageDao.createOrUpdatePageAccessToken(page);
    }
}
