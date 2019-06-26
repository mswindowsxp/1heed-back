package io.uetunited.oneheed.controller;

import io.uetunited.oneheed.dao.UserDao;
import io.uetunited.oneheed.payload.request.RefreshTokenRequest;
import io.uetunited.oneheed.payload.request.VerifyTokenRequest;
import io.uetunited.oneheed.payload.response.LoginResponse;
import io.uetunited.oneheed.security.JwtTokenProvider;
import io.uetunited.oneheed.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDao userDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    AuthService authService;

    @PostMapping("/verify/token")
    public ResponseEntity verifyToken(@RequestBody VerifyTokenRequest verifyTokenRequest) {
        boolean verifyResult = authService.verifyToken(verifyTokenRequest.getToken());
        if (verifyResult) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/refresh/token")
    public ResponseEntity refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        LoginResponse refreshResult = authService.refreshToken(refreshTokenRequest.getRefreshToken());
        if (refreshResult == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(refreshResult);
        }
    }
}
