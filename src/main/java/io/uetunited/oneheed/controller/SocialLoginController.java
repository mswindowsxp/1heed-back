package io.uetunited.oneheed.controller;

import io.uetunited.oneheed.client.FbClient;
import io.uetunited.oneheed.constant.UserType;
import io.uetunited.oneheed.exception.ConnectException;
import io.uetunited.oneheed.exception.InvalidResponseException;
import io.uetunited.oneheed.model.facebook.UserInfo;
import io.uetunited.oneheed.payload.AccessTokenPayload;
import io.uetunited.oneheed.payload.LoginResponse;
import io.uetunited.oneheed.payload.dto.UserDTO;
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
    public ResponseEntity<LoginResponse> facebookLogin(@RequestBody AccessTokenPayload payload) throws InvalidResponseException, ConnectException {

        UserInfo userInfo = fbClient.getUserInfo(payload.getAccessToken());
        userInfo.setAccessToken(payload.getAccessToken());
        userInfo.setUserType(UserType.FACEBOOK);

        UserDTO user = userService.createOrUpdateUser(userInfo);
        String jwtToken = authService.generateJwtToken(user);
        String refreshToken = authService.generateNewRefreshToken();

        LoginResponse response = new LoginResponse();
        response.setToken(jwtToken);
        response.setRefreshToken(refreshToken);
        user.setAccessToken(null); // hide access token from client
        response.setUser(userInfo);
        return ResponseEntity.ok(response);
    }

//    @RequestMapping(method = RequestMethod.GET, value = "/facebook/pages")
//    public ResponseEntity getPagesAdminByUser(HttpRequest request) throws InvalidResponseException, ConnectException {
//        String token = request.getHeaders().getFirst(tokenHeader);
//        List<PageAccount> pages = fbClient.getPages(token);
//
//        return ResponseEntity.ok(pages);
//    }
}
