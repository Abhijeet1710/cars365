package com.cars365.AuthService.services;

import com.cars365.AuthService.dtos.UserSignupReq;
import com.cars365.AuthService.entities.User;
import com.cars365.AuthService.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return new UserDetailsImpl(user.get());
    }

    public User createUser(UserSignupReq userSignupReq) {
        User user = new User();
        user.setUsername(userSignupReq.getUsername());
        user.setPassword(passwordEncoder.encode(userSignupReq.getPassword())); // Ensure password is encoded
        user.setRoles(userSignupReq.getRoles().get(0));
        User createdUser = userRepository.save(user);
        createdUser.setPassword(null);
        return createdUser;
    }
}
