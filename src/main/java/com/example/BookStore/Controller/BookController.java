package com.example.BookStore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookStore.Model.AddBook;
import com.example.BookStore.ServiceImpl.BookServiceImpl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    BookServiceImpl bookServiceImpl;

    // add book in db
    @PostMapping("/addBooks")
    public ResponseEntity<String> addBook(@RequestBody AddBook book) {
        try {
            String response = bookServiceImpl.AddBook(book);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Duplicate entry or data integrity voilation" + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Duplicate entry or data integrity voilation" + e.getMessage());
        }
    }

    // Retrieve List of all the Book.
    @GetMapping("/books")
    public ResponseEntity<List<AddBook>> getBook() {
        List<AddBook> list = bookServiceImpl.GetBook();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // Retrieve a single Book by id.
    @GetMapping("/book/{id}")
    public ResponseEntity<List<AddBook>> getBookById(@PathVariable Integer id) {
        List<AddBook> book = bookServiceImpl.GetBookById(id);
        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        }
        return new ResponseEntity<>(book, HttpStatus.NOT_FOUND);
    }

    // Update the book details by id.
    @PutMapping("updateBook/{id}")
    public ResponseEntity<String> updateBookDetails(@PathVariable Integer id, @RequestBody AddBook book) {
        String response = bookServiceImpl.UpdateBookDetails(id, book);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteBook(@PathVariable Integer id){
        Boolean response = bookServiceImpl.DeleteBook(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
