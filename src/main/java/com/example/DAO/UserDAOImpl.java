package com.example.DAO;

import com.example.Entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{


    private EntityManager entityManager;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    public UserDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void registerUser(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.save(user);
    }

    @Override
    @Transactional
    public User loginUser(User user) {
        Session session = entityManager.unwrap(Session.class);
        try {
            Query query = session.createQuery("from Users where username = '" + user.getUsername() + "' and password = '" + user.getPassword() + "'", User.class);
            return (User) query.getSingleResult();
        } catch (Exception e){
            return null;
        }
    }

    @Override
    @Transactional
    public ObjectNode checkForExitingUser(User user) {

        Session session = entityManager.unwrap(Session.class);

        ObjectNode node = mapper.createObjectNode();

        Query query = session.createQuery("from Users where username = '" + user.getUsername() + "'", User.class);
        List list = query.getResultList();
        if(list.size() == 0)
            node.put("username", 0);
        else
            node.put("username", 1);



        query = session.createQuery("from Users where email = '" + user.getEmail() + "'", User.class);
        list = query.getResultList();

        if(list.size() == 0)
            node.put("email", 0);
        else
            node.put("email", 2);


        query = session.createQuery("from Users where phone = '" + user.getPhone() + "'", User.class);
        list = query.getResultList();
        if(list.size() == 0)
            node.put("phone", 0);
        else
            node.put("phone", 3);

        return node;

    }


}
