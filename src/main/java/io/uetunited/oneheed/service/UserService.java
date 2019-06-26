package io.uetunited.oneheed.service;

import io.uetunited.oneheed.model.facebook.UserInfo;
import io.uetunited.oneheed.payload.dto.User;
import io.uetunited.oneheed.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userRepository;

    public User createOrUpdateUser(UserInfo userInfo) {
        User user = userRepository.getBySocialId(userInfo.getId(), userInfo.getUserType());
        if (user != null) {
            user.setAccessToken(userInfo.getAccessToken());
        } else {
            user = new User();
            user.setEmail(userInfo.getEmail());
            user.setName(userInfo.getName());
            user.setType(userInfo.getUserType());
            user.setAvatar(userInfo.getPicture().getData().getUrl());
            user.setSocialId(userInfo.getId());
            user.setAccessToken(userInfo.getAccessToken());
            user.setUsername(userInfo.getUserType() + "_" + userInfo.getId());
        }
        return userRepository.createOrUpdateUserAccessToken(user);
    }
}
