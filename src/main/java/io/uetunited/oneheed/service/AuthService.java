package io.uetunited.oneheed.service;

import io.uetunited.oneheed.payload.UserDTO;
import io.uetunited.oneheed.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    public String generateJwtToken(UserDTO user) {
        return jwtTokenProvider.generateToken(user);
    }

}
