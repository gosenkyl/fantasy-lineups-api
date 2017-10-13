package com.gosenk.fantasy.lineups.api.resource;

import com.gosenk.fantasy.lineups.api.entity.User;
import com.gosenk.fantasy.lineups.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserResource {

    @Autowired
    private UserService service;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<User>(service.createUser(user), HttpStatus.OK);
    }

}
