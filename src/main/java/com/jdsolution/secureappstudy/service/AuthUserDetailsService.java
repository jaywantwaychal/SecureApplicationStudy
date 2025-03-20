package com.jdsolution.secureappstudy.service;

import com.jdsolution.secureappstudy.entity.AuthUsers;
import com.jdsolution.secureappstudy.model.AuthUserPrincipal;
import com.jdsolution.secureappstudy.repo.AuthUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthUserDetailsService implements UserDetailsService {

    @Autowired
    private AuthUsersRepository authUsersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUsers authUsers = authUsersRepository.findByName(username);

        if(null == authUsers) {
            throw new UsernameNotFoundException("User not found.");
        }

        return new AuthUserPrincipal(authUsers);
    }
}
