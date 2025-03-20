package com.jdsolution.secureappstudy.service;

import com.jdsolution.secureappstudy.entity.AuthUsers;
import com.jdsolution.secureappstudy.repo.AuthUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthUserService {
    
    @Autowired
    private AuthUsersRepository authUsersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthUsers addUser(AuthUsers authUsers) {
        authUsers.setPassword(passwordEncoder.encode(authUsers.getPassword()));
        return authUsersRepository.save(authUsers);
    }
}
