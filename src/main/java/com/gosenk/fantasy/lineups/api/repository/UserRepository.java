package com.gosenk.fantasy.lineups.api.repository;

import com.gosenk.fantasy.lineups.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findOneByUsername(String username);
}
