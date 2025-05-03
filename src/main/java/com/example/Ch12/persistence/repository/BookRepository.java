package com.example.Ch12.persistence.repository;

import com.example.Ch12.persistence.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDate;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer>,
        JpaSpecificationExecutor<Book> { //DAO

    List<Book> findByAuthor(String author);

    List<Book> findByBookConcern(String bookConcern);

    List<Book> findByPublishDate(LocalDate date);


}
