package com.demo.login.service;

import com.demo.login.model.User;

public interface UserService {
    void save(User user);
    void updatePassword(User user);
    void updateToken(User user);

    User findByUsername(String username);

}
