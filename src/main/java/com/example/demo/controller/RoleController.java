package com.example.demo.controller;


import com.example.demo.entity.Role;
import com.example.demo.pojo.RolePojo;
import com.example.demo.pojo.GlobalApiResponse;
import com.example.demo.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/list")
    public GlobalApiResponse<List<Role>> finAll() {
        GlobalApiResponse<List<Role>> globalApiResponse = new GlobalApiResponse();
        globalApiResponse.setStatus(200);
        globalApiResponse.setData(roleService.findAll());
        globalApiResponse.setMessage("Data retrived successfully");
        return globalApiResponse;
    }

    @PostMapping
    public GlobalApiResponse<String> roel(@RequestBody RolePojo rolePojo) {
        GlobalApiResponse<String> globalApiResponse= new GlobalApiResponse<String>();
        globalApiResponse.setStatus(200);
        globalApiResponse.setMessage("Data saved successfully");
        globalApiResponse.setData("saved");
        roleService.saveData(rolePojo);
        return globalApiResponse;

    }

    @PutMapping("/update")
    public void roleUpdate(@RequestBody RolePojo rolePojo){
        roleService.saveData(rolePojo);
    }

    @DeleteMapping("/delete/{id}")
    public GlobalApiResponse<Integer> delete(@PathVariable Integer id) {
        GlobalApiResponse<Integer> globalApiResponse=new GlobalApiResponse<>();
        globalApiResponse.setStatus(200);
        globalApiResponse.setMessage("Data deleted successfully");
        globalApiResponse.setData(id);
        this.roleService.deleteById(id);
        return globalApiResponse;
    }
    @GetMapping("/getById/{id}")
    public Optional<Role> getById(@PathVariable Integer id) {
        return this.roleService.findById(id);
    }
}
