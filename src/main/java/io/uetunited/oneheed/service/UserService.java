package io.uetunited.oneheed.service;

import io.uetunited.oneheed.model.facebook.UserInfo;
import io.uetunited.oneheed.constant.UserType;
import io.uetunited.oneheed.payload.dto.UserDTO;
import io.uetunited.oneheed.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userRepository;

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
