package com.jdsolution.secureappstudy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class AppUser {
    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;

}