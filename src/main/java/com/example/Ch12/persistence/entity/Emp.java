package com.example.Ch12.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Emp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double salary;

    //多對一映射
    @ManyToOne
    @JoinColumn(name = "deptid")
    private Dept dept;

}
