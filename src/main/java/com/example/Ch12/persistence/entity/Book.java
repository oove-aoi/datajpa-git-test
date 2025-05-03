package com.example.Ch12.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity  //告訴 Hibernate 這是資料表
@Table(name = "bookinfo")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 100, nullable = false)
    private String author;

    //name 設定資料表中的名稱，使其符合資料庫中的命名規則而非java的命名規則
    @Column(name = "bookconcern", length = 100, nullable = false)
    private String bookConcern;

    @Column(nullable = false)
    private LocalDate publishDate;

    //指定該欄位必須總共六位數、有兩位小數點即: XXXX.XX 的格式
    @Column(columnDefinition = "decimal(6, 2)")
    private Float price; //真的計算金錢這類數字還是該用 BigDecimal

    private Integer inventory;//庫存

    @Column(length = 500)
    private String brief;
}
