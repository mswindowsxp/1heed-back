package io.uetunited.oneheed.security;

import io.uetunited.oneheed.exception.ResourceNotFoundException;
import io.uetunited.oneheed.payload.dto.User;
import io.uetunited.oneheed.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class OneheedUserDetailService implements UserDetailsService {

    @Autowired
    UserDao userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(String id) {
        User user = userRepository.getById(id);
        if (user == null) {
            throw new ResourceNotFoundException("User", "id", id);
        }
        return UserPrincipal.create(user);
    }

    public UserDetails loadUser(User user) {
        return UserPrincipal.create(user);
    }
}