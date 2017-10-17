package com.gosenk.fantasy.lineups.api.resource;

import com.gosenk.fantasy.lineups.api.entity.Subscription;
import com.gosenk.fantasy.lineups.api.entity.User;
import com.gosenk.fantasy.lineups.api.service.SubscriptionService;
import com.gosenk.fantasy.lineups.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("subscriptions")
public class SubscriptionResource {

    @Autowired
    private SubscriptionService service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Subscription> getAll(){
        return service.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Subscription getById(@PathVariable String id){
        return service.findById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Subscription createOrUpdate(@RequestBody Subscription entity) {
        return service.save(entity);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

}
