package com.jdsolution.secureappstudy.repo;

import com.jdsolution.secureappstudy.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
}