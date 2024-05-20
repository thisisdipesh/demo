package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.pojo.UserPojo;
import com.example.demo.pojo.GlobalApiResponse;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("User")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/list")
    public GlobalApiResponse<List<User>> finAll(){
        GlobalApiResponse<List<User>> globalApiResponse = new GlobalApiResponse<List<User>>();
        globalApiResponse.setStatus(200);
        globalApiResponse.setData(userService.findAll());
        globalApiResponse.setMessage("Data Successfully Retrieved");
        return globalApiResponse;

    }

    @PostMapping("/save")
    public GlobalApiResponse<String>user(@RequestBody UserPojo userPojo) {
        GlobalApiResponse<String> globalApiResponse = new GlobalApiResponse<String>();
        globalApiResponse.setStatus(200);
        globalApiResponse.setMessage("Data Successfully Retrieved");
        globalApiResponse.setData("saved");
        userService.saveData(userPojo);
        return globalApiResponse;
    }

    @PutMapping("/update")
    public void roleUpdate(@RequestBody UserPojo userPojo) {
        userService.saveData(userPojo);
    }

    @DeleteMapping("/delete/{id}")
    public GlobalApiResponse<Integer>delete(@PathVariable Integer id) {
        GlobalApiResponse<Integer>globalApiResponse = new GlobalApiResponse<>();
        globalApiResponse.setStatus(200);
        globalApiResponse.setMessage("Data Successfully Deleted");
        globalApiResponse.setData(id);
        this.userService.deleteById(id);
        return globalApiResponse;
    }

    @GetMapping("/getById/{id}")
    public Optional<User>findById(@PathVariable Integer id) {
        return this.userService.findById(id);
    }
}
