package com.gosenk.fantasy.lineups.api.resource;

import com.gosenk.fantasy.lineups.api.entity.User;
import com.gosenk.fantasy.lineups.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("users")
public class UserResource {

    @Autowired
    private UserService service;

    @Autowired
    private TokenStore tokenStore;

    private DefaultTokenServices defaultTokenServices;

    // For some reason DefaultTokenServices will not properly autowire.  So we cache a singleton here based
    // on tokenstore autowired in.  *shrug*
    private DefaultTokenServices getTokenServices() {
        if (defaultTokenServices == null) {
            DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
            defaultTokenServices.setTokenStore(tokenStore);
            this.defaultTokenServices = defaultTokenServices;
        }
        return defaultTokenServices;
    }

    @RequestMapping(value = "me", method = RequestMethod.GET)
    public ResponseEntity<User> getLoggedInUser(@AuthenticationPrincipal User user){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return new ResponseEntity<>((User) service.loadUserByUsername(authentication.getName()), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(service.createUser(user), HttpStatus.OK);
    }

    @RequestMapping(value = "/revoketoken", method = RequestMethod.POST)
    public ResponseEntity<String> revokeToken(@RequestParam("token") String token){
        getTokenServices().revokeToken(token);

        return new ResponseEntity<>(token, HttpStatus.OK);
    }

}