package com.example.Service;

import com.example.DAO.UserDAO;
import com.example.Entity.User;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImp implements  UserService{

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public void register(User user) {
        userDAO.registerUser(user);
    }

    @Override
    @Transactional
    public User loginUser(User user) {
        return userDAO.loginUser(user);
    }

    @Override
    @Transactional
    public ObjectNode checkForExistingUser(User user) {
        return userDAO.checkForExitingUser(user);
    }


}
