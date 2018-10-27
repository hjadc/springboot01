package com.huju.test01.controller;

import com.huju.test01.domain.User;
import com.huju.test01.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


/**
 * Created by huju on 2018/10/27.
 */
@RestController
public class JpaController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    @GetMapping("/user")
    public User insertUser(User user) {
        System.out.println("保存: " + user);
        User save = userRepository.save(user);
        return save;
    }
}
