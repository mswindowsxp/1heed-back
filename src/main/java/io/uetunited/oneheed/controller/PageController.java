package io.uetunited.oneheed.controller;

import io.uetunited.oneheed.client.FbClient;
import io.uetunited.oneheed.exception.ConnectException;
import io.uetunited.oneheed.exception.InvalidResponseException;
import io.uetunited.oneheed.payload.dto.Page;
import io.uetunited.oneheed.payload.request.RegisterPageRequest;
import io.uetunited.oneheed.security.CurrentUser;
import io.uetunited.oneheed.security.UserPrincipal;
import io.uetunited.oneheed.service.AuthService;
import io.uetunited.oneheed.service.MsgDownloaderService;
import io.uetunited.oneheed.service.PageService;
import io.uetunited.oneheed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PageController {
    @Autowired
    FbClient fbClient;

    @Autowired
    UserService userService;

    @Autowired
    AuthService authService;

    @Autowired
    PageService pageService;

    @Autowired
    MsgDownloaderService msgDownloaderService;

    @RequestMapping(method = RequestMethod.POST, value = "/facebook/pages")
    public ResponseEntity registerPage(@RequestBody RegisterPageRequest registerPageRequest, @CurrentUser UserPrincipal userPrincipal) throws InvalidResponseException, ConnectException {
        String userId = userPrincipal.getId();
        Optional<Page> page = pageService.registerPage(userId, registerPageRequest.getId(), registerPageRequest.getName(), registerPageRequest.getAvatar(), registerPageRequest.getAccessToken());

        if (page.isPresent()) {
            // download all messages to DB
            msgDownloaderService.downloadAllMsgToDatabase();
            return ResponseEntity.ok(page.get());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
