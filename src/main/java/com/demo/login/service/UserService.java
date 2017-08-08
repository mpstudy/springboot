package com.demo.login.service;

import com.demo.login.model.Member;

public interface UserService {
    void save(Member user);

    Member findByUsername(String username);
}
