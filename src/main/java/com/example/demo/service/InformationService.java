package com.example.demo.service;


import com.example.demo.entity.Information;

import java.util.List;
import java.util.Optional;

public interface InformationService {
    List<Information> findAll();

    void saveData(InformationPojo informationPojo);

    void deleteById(Integer id);

    Optional<Information> findById(Integer id);
}
