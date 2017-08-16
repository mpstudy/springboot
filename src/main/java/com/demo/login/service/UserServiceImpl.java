package com.demo.login.service;

import com.demo.login.model.User;
import com.demo.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole(1);
        userRepository.save(user);
    }

    @Override
    public void updatePassword(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.updatePassword(user.getPassword(), user.getUsername());
    }

    @Override
    public void updateToken(User user){
        userRepository.updateToken(user.getToken(), user.getUsername());
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
