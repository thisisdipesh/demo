package com.example.demo.controller;


import com.example.demo.entity.Book;
import com.example.demo.pojo.BookPojo;
import com.example.demo.pojo.GlobalApiResponse;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/list")
    public GlobalApiResponse<List<Book>> finAll() {
        GlobalApiResponse<List<Book>> globalApiResponse = new GlobalApiResponse();
        globalApiResponse.setStatus(200);
        globalApiResponse.setData(bookService.findAll());
        globalApiResponse.setMessage("Data retrived successfully");
        return globalApiResponse;
    }


    @PostMapping
    public GlobalApiResponse<String> book(@RequestBody BookPojo bookPojo) {
        GlobalApiResponse<String> globalApiResponse= new GlobalApiResponse<String>();
        globalApiResponse.setStatus(200);
        globalApiResponse.setMessage("Data saved successfully");
        globalApiResponse.setData("saved");
        bookService.saveData(bookPojo);
        return globalApiResponse;

    }

    @PutMapping("/update")
    public void bookUpdate(@RequestBody BookPojo bookPojo){
        bookService.saveData(bookPojo);
    }

    @DeleteMapping("/delete/{id}")
    public GlobalApiResponse<Integer> delete(@PathVariable Integer id) {
        GlobalApiResponse<Integer> globalApiResponse=new GlobalApiResponse<>();
        globalApiResponse.setStatus(200);
        globalApiResponse.setMessage("Data deleted successfully");
        globalApiResponse.setData(id);
        this.bookService.deleteById(id);
        return globalApiResponse;
    }
    @GetMapping("/getById/{id}")
    public Optional<Book> getById(@PathVariable Integer id) {
        return this.bookService.findById(id);
    }
}
