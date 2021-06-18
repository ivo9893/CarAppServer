package com.example.RESTController;

import com.example.DAO.UserDAO;
import com.example.DAO.UserDAOImpl;
import com.example.Entity.User;
import com.example.Service.UserService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/rest")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping(value = "/register")
    public void registerUser(@RequestBody com.fasterxml.jackson.databind.JsonNode payload) {
        User user = new User(payload.get("username").asText(), payload.get("password").asText(), payload.get("email").asText(), payload.get("phone").asText());
        userService.register(user);
    }

    @GetMapping("/login/{username}/{password}")
    public boolean loginUser(@PathVariable String username, @PathVariable String password) {

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user = userService.loginUser(user);

        return user != null;
    }

    @GetMapping("/checkUser/{username}/{email}/{phone}")
    public ObjectNode checkUser(@PathVariable String username, @PathVariable String email, @PathVariable String phone){

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPhone(phone);

        return userService.checkForExistingUser(user);
    }
}
