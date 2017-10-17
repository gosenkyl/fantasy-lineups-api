package com.gosenk.fantasy.lineups.api.resource;

import com.gosenk.fantasy.lineups.api.entity.Salesman;
import com.gosenk.fantasy.lineups.api.entity.User;
import com.gosenk.fantasy.lineups.api.service.SalesmanService;
import com.gosenk.fantasy.lineups.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("salesmans")
public class SalesmanResource {

    @Autowired
    private SalesmanService service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Salesman> getAll(){
        return service.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Salesman getById(@PathVariable String id){
        return service.findById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Salesman createOrUpdate(@RequestBody Salesman entity) {
        return service.save(entity);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

}
