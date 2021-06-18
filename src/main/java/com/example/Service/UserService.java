package com.example.Service;

import com.example.Entity.User;
import com.fasterxml.jackson.databind.node.ObjectNode;

public interface UserService {
    void register(User user);
    User loginUser(User user);
    ObjectNode checkForExistingUser(User user);
}
