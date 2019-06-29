package io.uetunited.oneheed.controller;

import io.uetunited.oneheed.client.FbClient;
import io.uetunited.oneheed.exception.ConnectException;
import io.uetunited.oneheed.exception.InvalidResponseException;
import io.uetunited.oneheed.payload.dto.Page;
import io.uetunited.oneheed.payload.request.RegisterPageRequest;
import io.uetunited.oneheed.service.AuthService;
import io.uetunited.oneheed.service.PageService;
import io.uetunited.oneheed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(method = RequestMethod.POST, value = "/facebook/pages")
    public ResponseEntity registerPage(@RequestBody RegisterPageRequest registerPageRequest) throws InvalidResponseException, ConnectException {
        Optional<Page> page = pageService.registerPage(registerPageRequest.getId(), registerPageRequest.getName(), registerPageRequest.getAvatar(), registerPageRequest.getAccessToken());
        if (page.isPresent()) {
            return ResponseEntity.ok(page.get());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
