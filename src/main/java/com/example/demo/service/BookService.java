package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.pojo.BookPojo;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    void saveData(BookPojo bookPojoPojo);

    void deleteById(Integer id);

    Optional<Book> findById(Integer id);
}
