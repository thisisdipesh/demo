package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.pojo.UserPojo;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();

    void saveData(UserPojo userPojo);

    void deleteById(Integer id);

    Optional<User> findById(Integer id);
}
