package com.example.BookStore.ServiceImpl;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookStore.Repository.BookRepository;
import com.example.BookStore.Service.BookService;
import com.example.BookStore.Entity.Books;
import com.example.BookStore.Model.AddBook;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public String AddBook(AddBook book) {
        try {
            Books books = new Books(book.getTitle(), book.getAuthor(), book.getPublicationYear(), book.getIsbn());
            bookRepository.save(books);
            return "Book details has been saved successfully.";
        } catch (Exception e) {
            return "Error while adding the Book details."+ e.getMessage();
        }
    }

    @Override
    public List<AddBook> GetBook() {
       List<AddBook> response = new ArrayList<>();
       List<Books> bookLists = bookRepository.findAll();
       for (Books bookList : bookLists) {
        AddBook addBook = new AddBook(bookList.getTitle(),bookList.getAuthor(),bookList.getPublicationYear(),bookList.getIsbn());
        response.add(addBook);
       }
       return response;

    }

    @Override
    public List<AddBook> GetBookById(Integer id) {
        List<AddBook> response = new ArrayList<>();
        Optional<Books> optionalbooks = bookRepository.findById(id);

        if(optionalbooks.isPresent()){
            Books books = optionalbooks.get();
            AddBook addBook = new AddBook();
            addBook.setTitle(books.getTitle());
            addBook.setAuthor(books.getAuthor());
            addBook.setPublicationYear(books.getPublicationYear());
            addBook.setIsbn(books.getIsbn());

            response.add(addBook);
        }else{
            return null;
        }
        return response;
        
    } 

}
