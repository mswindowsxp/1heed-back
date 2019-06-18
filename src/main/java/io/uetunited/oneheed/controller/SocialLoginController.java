package io.uetunited.oneheed.controller;

import io.uetunited.oneheed.client.FbClient;
import io.uetunited.oneheed.exception.ConnectException;
import io.uetunited.oneheed.exception.InvalidResponseException;
import io.uetunited.oneheed.model.PageAccount;
import io.uetunited.oneheed.model.UserInfo;
import io.uetunited.oneheed.model.UserType;
import io.uetunited.oneheed.payload.AccessTokenPayload;
import io.uetunited.oneheed.payload.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SocialLoginController {
    @Autowired
    FbClient fbClient;

    @Value("${jwt.header}")
    String tokenHeader;

    @RequestMapping(method = RequestMethod.POST, value = "/login/facebook")
    public ResponseEntity<LoginResponse> facebookLogin(@RequestBody AccessTokenPayload payload) throws InvalidResponseException, ConnectException {

        UserInfo userInfo = fbClient.getUserInfo(payload.getAccessToken());
        userInfo.setUserType(UserType.FACEBOOK);
        LoginResponse response = new LoginResponse();
        response.setToken(payload.getAccessToken());
        response.setUser(userInfo);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/facebook/pages")
    public ResponseEntity getPagesAdminByUser(HttpRequest request) throws InvalidResponseException, ConnectException {
        String token = request.getHeaders().getFirst(tokenHeader);
        List<PageAccount> pages = fbClient.getPages(token);

        return ResponseEntity.ok(pages);
    }
}
