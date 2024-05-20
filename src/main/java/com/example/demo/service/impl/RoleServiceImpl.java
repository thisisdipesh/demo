package com.example.demo.service.impl;

import com.example.demo.entity.Role;
import com.example.demo.pojo.RolePojo;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;


    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }


    @Override
    public void saveData(RolePojo rolePojo) {
        Role role = new Role();

        role.setId(rolePojo.getId());
        role.setRole(rolePojo.getRole());

        roleRepository.save(role);


    }
    @Override
    public void deleteById(Integer id) {roleRepository.deleteById(id);
    }

    @Override
    public Optional<Role> findById(Integer id) {
        return roleRepository.findById(id);
    }

}

