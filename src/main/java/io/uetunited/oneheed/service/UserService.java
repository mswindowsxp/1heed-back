package io.uetunited.oneheed.service;

import io.uetunited.oneheed.model.UserInfo;
import io.uetunited.oneheed.constant.UserType;
import io.uetunited.oneheed.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public boolean checkIfUserIsExist(String username, UserType userType) {
        return true;
    }

    public void createUser(UserInfo userInfo) {

    }
}
