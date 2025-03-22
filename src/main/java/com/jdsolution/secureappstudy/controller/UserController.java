package com.jdsolution.secureappstudy.controller;

import com.jdsolution.secureappstudy.entity.AuthUsers;
import com.jdsolution.secureappstudy.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private AuthUserService authUserService;

    @PostMapping("/register")
    public AuthUsers addUser(@RequestBody AuthUsers authUsers) {
        return authUserService.addUser(authUsers);
    }

    @PostMapping("/logtoapp")
    public String login(@RequestBody AuthUsers authUsers) {
        String s= authUserService.login(authUsers);
        return s;
    }

    @GetMapping
    public ResponseEntity<List<AuthUsers>> getMessage() {
        return ResponseEntity.of(Optional.ofNullable(authUserService.getUsers()));
    }
}
