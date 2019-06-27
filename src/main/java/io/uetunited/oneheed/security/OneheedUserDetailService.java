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

import java.util.Optional;


@Service
public class OneheedUserDetailService implements UserDetailsService {

    @Autowired
    UserDao userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.getByUsername(username);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return UserPrincipal.create(user.get());
    }

    @Transactional
    public UserDetails loadUserById(String id) {
        Optional<User> user = userRepository.getById(id);
        if (!user.isPresent()) {
            throw new ResourceNotFoundException("User", "id", id);
        }
        return UserPrincipal.create(user.get());
    }

    public UserDetails loadUser(User user) {
        return UserPrincipal.create(user);
    }
}