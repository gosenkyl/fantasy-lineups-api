package com.gosenk.fantasy.lineups.api.service;

import com.gosenk.fantasy.lineups.api.entity.Salesman;
import com.gosenk.fantasy.lineups.api.repository.SalesmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesmanService extends BaseService<Salesman, SalesmanRepository> {

    @Autowired
    public SalesmanService(SalesmanRepository repository){
        super(repository);
    }

}