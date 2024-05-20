package com.example.demo.controller;


import com.example.demo.entity.Futsal;
import com.example.demo.pojo.FutsalPojo;
import com.example.demo.pojo.GlobalApiResponse;
import com.example.demo.service.FutsalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("futsal")
@RequiredArgsConstructor
public class FutsalController {

    private final FutsalService futsalService;

    @GetMapping("/list")
    public GlobalApiResponse<List<Futsal>> finAll() {
        GlobalApiResponse<List<Futsal>> globalApiResponse = new GlobalApiResponse();
        globalApiResponse.setStatus(200);
        globalApiResponse.setData(futsalService.findAll());
        globalApiResponse.setMessage("Data retrived successfully");
        return globalApiResponse;
    }

    @PostMapping
    public GlobalApiResponse<String> futsal(@RequestBody FutsalPojo futsalPojo) {
        GlobalApiResponse<String> globalApiResponse= new GlobalApiResponse<String>();
        globalApiResponse.setStatus(200);
        globalApiResponse.setMessage("Data saved successfully");
        globalApiResponse.setData("saved");
        futsalService.saveData(futsalPojo);
        return globalApiResponse;

    }

    @PutMapping("/update")
    public void futsalUpdate(@RequestBody FutsalPojo futsalPojo){
        futsalService.saveData(futsalPojo);
    }

    @DeleteMapping("/delete/{id}")
    public GlobalApiResponse<Integer> delete(@PathVariable Integer id) {
        GlobalApiResponse<Integer> globalApiResponse=new GlobalApiResponse<>();
        globalApiResponse.setStatus(200);
        globalApiResponse.setMessage("Data deleted successfully");
        globalApiResponse.setData(id);
        this.futsalService.deleteById(id);
        return globalApiResponse;
    }
    @GetMapping("/getById/{id}")
    public Optional<Futsal> getById(@PathVariable Integer id) {
        return this.futsalService.findById(id);
    }
}
