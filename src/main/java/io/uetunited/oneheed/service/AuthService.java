package io.uetunited.oneheed.service;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import io.uetunited.oneheed.dao.redis.RefreshTokenDao;
import io.uetunited.oneheed.dao.redis.TokenDao;
import io.uetunited.oneheed.model.facebook.UserInfo;
import io.uetunited.oneheed.payload.dto.User;
import io.uetunited.oneheed.payload.response.LoginResponse;
import io.uetunited.oneheed.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

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
        refreshTokenDao.addRefreshToken(refreshToken, user);

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
