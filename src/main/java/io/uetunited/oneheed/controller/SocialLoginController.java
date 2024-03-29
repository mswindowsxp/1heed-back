package io.uetunited.oneheed.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.uetunited.oneheed.client.FbClient;
import io.uetunited.oneheed.constant.UserType;
import io.uetunited.oneheed.exception.ConnectException;
import io.uetunited.oneheed.exception.InvalidResponseException;
import io.uetunited.oneheed.model.facebook.UserData;
import io.uetunited.oneheed.payload.dto.User;
import io.uetunited.oneheed.payload.request.SocialLoginRequest;
import io.uetunited.oneheed.payload.response.LoginResponse;
import io.uetunited.oneheed.service.AuthService;
import io.uetunited.oneheed.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SocialLoginController {
    @Autowired
    FbClient fbClient;

    @Value("${app.jwtHeader}")
    String tokenHeader;

    @Autowired
    UserService userService;

    @Autowired
    AuthService authService;

    @RequestMapping(method = RequestMethod.POST, value = "/login/facebook")
    public ResponseEntity<LoginResponse> facebookLogin(@RequestBody SocialLoginRequest payload) throws InvalidResponseException, ConnectException {

        UserData userData = fbClient.getUserInfo(payload.getAccessToken());
        userData.setAccessToken(payload.getAccessToken());
        userData.setUserType(UserType.FACEBOOK);

        User user = userService.createOrUpdateUser(userData);

        LoginResponse response = authService.generateLoginResponse(user);
//        userData.setAccessToken(null); // hide access token from client
        response.setUser(user);
        return ResponseEntity.ok(response);
    }

}
