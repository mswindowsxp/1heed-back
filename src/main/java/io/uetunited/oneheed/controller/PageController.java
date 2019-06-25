package io.uetunited.oneheed.controller;

import io.uetunited.oneheed.client.FbClient;
import io.uetunited.oneheed.exception.ConnectException;
import io.uetunited.oneheed.exception.InvalidResponseException;
import io.uetunited.oneheed.model.facebook.PageAccount;
import io.uetunited.oneheed.service.AuthService;
import io.uetunited.oneheed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PageController {
    @Autowired
    FbClient fbClient;

    @Value("${app.jwtHeader}")
    String tokenHeader;

    @Autowired
    UserService userService;

    @Autowired
    AuthService authService;

    @RequestMapping(method = RequestMethod.GET, value = "/facebook/pages")
    public ResponseEntity getPagesAdminByUser(HttpRequest request) throws InvalidResponseException, ConnectException {
        String token = request.getHeaders().getFirst(tokenHeader);
        List<PageAccount> pages = fbClient.getPages(token);

        return ResponseEntity.ok(pages);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/facebook/pages")
    public ResponseEntity registerPage(HttpRequest request) throws InvalidResponseException, ConnectException {
        String token = request.getHeaders().getFirst(tokenHeader);
        List<PageAccount> pages = fbClient.getPages(token);

        return ResponseEntity.ok(pages);
    }
}
