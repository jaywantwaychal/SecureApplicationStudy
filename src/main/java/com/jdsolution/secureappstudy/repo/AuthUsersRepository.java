package com.jdsolution.secureappstudy.repo;

import com.jdsolution.secureappstudy.entity.AuthUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthUsersRepository extends JpaRepository<AuthUsers, Long> {

    AuthUsers findByName(String username);
}
