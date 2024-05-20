package com.example.demo.service.impl;

import com.example.demo.entity.Book;
import com.example.demo.pojo.BookPojo;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;


    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }


    @Override
    public void saveData(BookPojo bookPojo) {
        Book book = new Book();

        book.setId(bookPojo.getId());
        book.setDate(bookPojo.getDate());

        bookRepository.save(book);

    }
    @Override
    public void deleteById(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return bookRepository.findById( id);
    }

}

