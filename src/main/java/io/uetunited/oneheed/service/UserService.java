package io.uetunited.oneheed.service;

import io.uetunited.oneheed.model.UserInfo;
import io.uetunited.oneheed.constant.UserType;
import io.uetunited.oneheed.payload.UserDTO;
import io.uetunited.oneheed.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public boolean checkIfUserIsExist(String socialId, UserType userType) {
        return userRepository.checkIfUserExists(socialId, userType);
    }

    public UserDTO createOrUpdateUser(UserInfo userInfo) {
        UserDTO user = userRepository.getBySocialId(userInfo.getId(), userInfo.getUserType());
        if (user != null) {
            user.setAccessToken(userInfo.getAccessToken());
        } else {
            user = new UserDTO();
            user.setEmail(userInfo.getEmail());
            user.setName(userInfo.getName());
            user.setType(userInfo.getUserType());
            user.setAvatar(userInfo.getPicture().getData().getUrl());
            user.setSocialId(userInfo.getId());
            user.setAccessToken(userInfo.getAccessToken());
            user.setUsername(userInfo.getUserType().name() + "_" + userInfo.getId());
        }
        return userRepository.createOrUpdateUserAccessToken(user);
    }
}
