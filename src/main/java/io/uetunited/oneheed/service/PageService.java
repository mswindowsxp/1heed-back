package io.uetunited.oneheed.service;

import io.uetunited.oneheed.client.FbClient;
import io.uetunited.oneheed.constant.UserType;
import io.uetunited.oneheed.dao.PageDao;
import io.uetunited.oneheed.exception.ConnectException;
import io.uetunited.oneheed.exception.InvalidResponseException;
import io.uetunited.oneheed.payload.dto.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PageService {

    @Autowired
    FbClient fbClient;

    @Autowired
    PageDao pageDao;

    public Optional<Page> registerPage(String pageId, String pageName, String avatar, String shortLiveAccessToken) throws InvalidResponseException, ConnectException {
        String longLiveAccessToken = fbClient.getLongLiveToken(shortLiveAccessToken).getAccessToken();
        fbClient.subscribeToPage(longLiveAccessToken);
        return savePageToDb(pageId, pageName, avatar, longLiveAccessToken);
    }

    private Optional<Page> savePageToDb(String pageId, String pageName, String avatar, String accessToken) {
        Page page = new Page();
        page.setSocialId(pageId);
        page.setName(pageName);
        page.setAvatar(avatar);
        page.setAccessToken(accessToken);
        page.setType(UserType.FACEBOOK);
        return pageDao.createOrUpdatePageAccessToken(page);
    }
}
