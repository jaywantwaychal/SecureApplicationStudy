package com.jdsolution.secureappstudy.service;

import com.jdsolution.secureappstudy.entity.AuthUsers;
import com.jdsolution.secureappstudy.repo.AuthUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthUserService {

    @Autowired
    private AuthUsersRepository authUsersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTTokenService jwtTokenService;

    public AuthUsers addUser(AuthUsers authUsers) {
        authUsers.setPassword(passwordEncoder.encode(authUsers.getPassword()));
        return authUsersRepository.save(authUsers);
    }

    public String login(AuthUsers authUsers) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authUsers.getName(), authUsers.getPassword()));
        if (authentication.isAuthenticated()) {
           return jwtTokenService.generateToken(authUsers.getName());
        }
        return "failed";
    }

    public List<AuthUsers> getUsers() {

        return authUsersRepository.findAll();
    }
}
