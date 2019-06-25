package io.uetunited.oneheed.security;

import io.uetunited.oneheed.exception.ResourceNotFoundException;
import io.uetunited.oneheed.payload.dto.UserDTO;
import io.uetunited.oneheed.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class OneheedUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO user = userRepository.getByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("UserDTO not found with username: " + username);
        }

        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(String id) {
        UserDTO user = userRepository.getById(id);
        if (user == null) {
            throw new ResourceNotFoundException("UserDTO", "id", id);
        }
        return UserPrincipal.create(user);
    }
}