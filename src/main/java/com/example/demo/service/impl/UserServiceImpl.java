package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.pojo.UserPojo;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    public void saveData(UserPojo userPojo) {
        User user = new User();

        user.setId(userPojo.getId());
        user.setUserName(userPojo.getUser_name());
        user.setAddress(userPojo.getAddress());
        user.setContactNumber(userPojo.getContact());

        userRepository.save(user);
    }
}
