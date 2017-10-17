package com.gosenk.fantasy.lineups.api.service;

import com.gosenk.fantasy.lineups.api.entity.User;
import com.gosenk.fantasy.lineups.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Service("userDetailsService")
public class UserService extends BaseService<User, UserRepository> implements UserDetailsService {

    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository){
        super(repository);
        this.repository = repository;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findOneByUsername(username);
    }

    public User createUser(User user){
        user.setId(UUID.randomUUID().toString());

        user.setEnabled(true);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return repository.save(user);
    }
}