package com.example.account.dao;

import com.example.account.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class RoleDAO {
    @Autowired
    EntityManager entityManager;
    public List<Role> getAll(){
        String queryStr = "SELECT r FROM Role r";
        TypedQuery<Role> query = entityManager.createQuery(queryStr, Role.class);
        return (List<Role>) query.getResultList();
    }

    public Role findById(int id){
        String queryStr = "SELECT r FROM Role r where r.id = :id";
        TypedQuery<Role> query = entityManager.createQuery(queryStr, Role.class).setParameter("id", id);
        return  query.getSingleResult();
    }

    public void save(Role role){
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.persist(role);
        txn.commit();
    }

    public void edit(Role role){
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.merge(role);
        txn.commit();
    }

    public void delete(Role role){
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.remove(role);
        txn.commit();
    }
}
