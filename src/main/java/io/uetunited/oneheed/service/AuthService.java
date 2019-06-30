package io.uetunited.oneheed.service;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.uetunited.oneheed.dao.redis.RefreshTokenDao;
import io.uetunited.oneheed.dao.redis.TokenDao;
import io.uetunited.oneheed.payload.dto.User;
import io.uetunited.oneheed.payload.response.LoginResponse;
import io.uetunited.oneheed.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AuthService {

    @Value("${app.jwtRefreshTokenExpiresInMs}")
    Long refreshTokenLifetime;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    TokenDao tokenDao;

    @Autowired
    RefreshTokenDao refreshTokenDao;

    public LoginResponse generateLoginResponse(User user) {
        String jwtToken = jwtTokenProvider.generateToken(user);
        String refreshToken = NanoIdUtils.randomNanoId();

        tokenDao.addToken(jwtToken);
        refreshTokenDao.addRefreshToken(refreshToken, user, refreshTokenLifetime);

        LoginResponse response = new LoginResponse();
        response.setToken(jwtToken);
        response.setRefreshToken(refreshToken);
        response.setUser(user);

        return response;
    }

    public boolean verifyToken(String token) {
        if (jwtTokenProvider.validateToken(token) && tokenDao.checkIfTokenExist(token)) {
            return true;
        }
        return false;
    }

    public LoginResponse refreshToken(String refreshToken) {
        if (refreshTokenDao.checkIfRefreshTokenExists(refreshToken)) {
            User user = refreshTokenDao.getUserFromRefreshToken(refreshToken);
            refreshTokenDao.deleteRefreshToken(refreshToken);

            return generateLoginResponse(user);
        } else {
            return null;
        }
    }

}
