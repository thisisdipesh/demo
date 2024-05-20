package com.example.demo.service;

import com.example.demo.entity.Role;
import com.example.demo.pojo.RolePojo;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<Role> findAll();

    void saveData(RolePojo rolePojo);

    void deleteById(Integer id);

    Optional<Role> findById(Integer id);
}
