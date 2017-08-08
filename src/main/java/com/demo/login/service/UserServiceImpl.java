package com.demo.login.service;

import com.demo.login.model.Member;
import com.demo.login.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Member user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole(1);
        memberRepository.save(user);
    }

    @Override
    public Member findByUsername(String username) {
        return memberRepository.findByUsername(username);
    }
}
