package com.example.BookStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookStore.Entity.Books;

@Repository
public interface BookRepository extends JpaRepository<Books, Integer> {
    
}
