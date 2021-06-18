package com.example.DAO;

import com.example.Entity.User;
import com.fasterxml.jackson.databind.node.ObjectNode;

public interface UserDAO {
    void registerUser(User user);

    User loginUser(User user);

    ObjectNode checkForExitingUser(User user);
}
