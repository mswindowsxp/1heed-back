package io.uetunited.oneheed.service;

import io.uetunited.oneheed.model.facebook.UserData;
import io.uetunited.oneheed.payload.dto.User;
import io.uetunited.oneheed.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserDao userRepository;

    public User createOrUpdateUser(UserData userData) {
        Optional<User> userOptional = userRepository.getBySocialId(userData.getId(), userData.getUserType());
        User user = null;
        if (userOptional.isPresent()) {
            user = userOptional.get();
            user.setAccessToken(userData.getAccessToken());
        } else {
            user = new User();
            user.setEmail(userData.getEmail());
            user.setName(userData.getName());
            user.setType(userData.getUserType());
            user.setAvatar(userData.getPicture().getData().getUrl());
            user.setSocialId(userData.getId());
            user.setAccessToken(userData.getAccessToken());
            user.setUsername(userData.getUserType() + "_" + userData.getId());
        }
        return userRepository.createOrUpdateUserAccessToken(user).get();
    }
}
