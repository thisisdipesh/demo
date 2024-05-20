package com.example.demo.service;
import com.example.demo.entity.Futsal;
import com.example.demo.pojo.FutsalPojo;

import java.util.List;
import java.util.Optional;

public interface FutsalService {

    List<Futsal> findAll();

    void saveData(FutsalPojo futsalPojo);

    void deleteById(Integer id);

    Optional<Futsal> findById(Integer id);



}