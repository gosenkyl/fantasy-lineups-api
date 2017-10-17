package com.gosenk.fantasy.lineups.api.service;

import com.gosenk.fantasy.lineups.api.entity.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public class BaseService<T extends BaseEntity, R extends JpaRepository<T, String>> {

    private final R repository;

    @SuppressWarnings("WeakerAccess")
    public BaseService(R repository) {
        this.repository = repository;
    }

    public R getRepository() {
        return repository;
    }

    public List<T> findAll() {
        return (List) getRepository().findAll();
    }

    public List<T> findAll(Sort sort){
        return (List) getRepository().findAll(sort);
    }

    public Page<T> findAll(Pageable pageable){
        return getRepository().findAll(pageable);
    }

    public T findById(String id) {
        if (id == null) {
            return null;
        } else {
            return getRepository().findOne(id);
        }
    }

    public T save(T dso) {
        if (dso.getId() == null) {
            dso.setId(UUID.randomUUID().toString());
        }
        return getRepository().save(dso);
    }

    public List<T> save(Iterable<T> dsoList){
        return (List) getRepository().save(dsoList);
    }

    public void delete(String id){
        getRepository().delete(id);
    }

    public void delete(T dso) {
        getRepository().delete(dso);
    }

    public void delete(List<T> dsoList){
        getRepository().delete(dsoList);
    }

    public void deleteAll(){
        getRepository().deleteAll();
    }

    public long count(){
        return getRepository().count();
    }
}
