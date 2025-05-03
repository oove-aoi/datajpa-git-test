package com.example.Ch12.persistence.repository;

import com.example.Ch12.persistence.entity.Book;
import jakarta.persistence.criteria.Predicate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void saveBook() {
        Book book = new Book();

        book.setTitle("Java 從入門到入土");
        book.setAuthor("孫堅");
        book.setBookConcern("東吳出版社");
        book.setPublishDate(LocalDate.of(2020, 10, 1));
        book.setPrice(188.00f);
        book.setInventory(200);

        bookRepository.save(book);
    }

    @Test
    void getBookById() {
        Optional<Book> optionalBook = bookRepository.findById(1);
        optionalBook.ifPresent(System.out::println);
    }

    @Test
    void getAllBooks() {
        List<Book> books = bookRepository.findAll();
        System.out.println(books);
    }

    @Test
    void updateBook() {
        Optional<Book> optionalBook = bookRepository.findById(1);
        if(optionalBook.isPresent()) {
            Book book = optionalBook.get();

            book.setInventory(166);
            //save()可用於更新紀錄，若'紀錄存在則更新、不存在則新增'
            bookRepository.save(book);
        }
    }

    @Test
    void deleteBook() {
        Optional<Book> optionalBook = bookRepository.findById(1);
        if(optionalBook.isPresent()) {
            Book book = optionalBook.get();
            bookRepository.delete(book);
        }
    }

    @Test
    void getBooksByAuthor() {
        List<Book> books = bookRepository.findByAuthor("孫堅");
        System.out.println(books);
    }

    @Test
    void getBooksByBookConcern() {
        List<Book> books = bookRepository.findByBookConcern("東吳出版社");
        System.out.println(books);
    }

    @Test
    void getBooksByPublishDate() {
        List<Book> books = bookRepository.findByPublishDate(LocalDate.of(2020, 10, 1));
        System.out.println(books);
    }

    @Test
    void getAllBooksByDateAndKeyword() {
        Specification specification = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            //criteriaBuilder的like()方法傳回一個述詞，相當於設定了一個like查詢準則
            predicates.add(criteriaBuilder.like(root.get("title"),"%" + "Java" +"%"));
            //對於可比較的物件，使用greaterThanOrEqualTo()方法來進行大於或等於的比較，該方法也傳回一個述詞
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("publishDate").as(LocalDate.class),
                    LocalDate.of(2020, 9, 1)));

            return criteriaBuilder.and(
                    predicates.toArray(new Predicate[predicates.size()]));
        };

        //分頁查詢
        //利用PageRequest的靜態方法建構pageabel物件，查詢第一頁(頁面索引從0開始)，每頁五筆資料
        Pageable pageable = PageRequest.of(0,5);

        //繼承了 JpaSpecificationExecutor 介面才會有 findAll() 方法
        Page<Book> page = bookRepository.findAll(specification, pageable);
        System.out.printf("總紀錄數為: %d %n", page.getTotalElements());
        System.out.printf("當前頁數: %d 頁 %n", page.getNumber()+1);
        System.out.printf("總頁數: %d 頁 %n", page.getTotalPages());
        System.out.printf("當前頁面的紀錄數: %d %n", page.getNumberOfElements());
        System.out.println("當前頁面的內容為:");
        System.out.println(page.getContent());
    }
}
