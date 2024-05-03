package com.example.BookStore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookStore.Model.AddBook;
import com.example.BookStore.ServiceImpl.BookServiceImpl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@CrossOrigin
@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    BookServiceImpl bookServiceImpl;

    @PostMapping("/addBooks")
    public ResponseEntity<String> addBook(@RequestBody AddBook book){
        try {
            String response = bookServiceImpl.AddBook(book);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Duplicate entry or data integrity voilation"+e.getMessage());
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Duplicate entry or data integrity voilation"+e.getMessage());
        }
    }

    @GetMapping("/Books")
    public ResponseEntity<List<AddBook>> getBook(){
        List<AddBook> list = bookServiceImpl.GetBook();
        return new ResponseEntity<>(list, HttpStatus.FOUND);
    }
    

}
