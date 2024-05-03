package com.example.BookStore.Service;

import java.util.List;

import com.example.BookStore.Model.AddBook;

public interface BookService {
    public String AddBook(AddBook book);
    public List<AddBook> GetBook();
    public List<AddBook> GetBookById(Integer id);
}
