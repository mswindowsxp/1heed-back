package io.uetunited.oneheed.controller;

import io.uetunited.oneheed.client.FbClient;
import io.uetunited.oneheed.exception.ConnectException;
import io.uetunited.oneheed.exception.InvalidResponseException;
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

//    @RequestMapping(method = RequestMethod.GET, value = "/facebook/pages")
//    public ResponseEntity getPagesAdminByUser(HttpRequest request) throws InvalidResponseException, ConnectException {
//        String token = request.getHeaders().getFirst(tokenHeader);
//        List<PageAccount> pages = fbClient.getPages(token);
//
//        return ResponseEntity.ok(pages);
//    }

    @RequestMapping(method = RequestMethod.POST, value = "/facebook/pages")
    public ResponseEntity registerPage(@RequestBody RegisterPageRequest registerPageRequest) throws InvalidResponseException, ConnectException {
        pageService.registerPage(registerPageRequest.getId(), registerPageRequest.getAccessToken());
        return ResponseEntity.ok().build();
    }
}
