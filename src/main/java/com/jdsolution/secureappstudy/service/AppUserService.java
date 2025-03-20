package com.jdsolution.secureappstudy.service;

import com.jdsolution.secureappstudy.entity.AppUser;
import com.jdsolution.secureappstudy.entity.AuthUsers;
import com.jdsolution.secureappstudy.repo.AuthUsersRepository;
import com.jdsolution.secureappstudy.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthUsersRepository authUsersRepository;

    public List<AuthUsers> getUsers() {
        List<AuthUsers> appUsers = authUsersRepository.findAll();
        System.out.println("----------" + appUsers.size());
        return appUsers;
    }
}
