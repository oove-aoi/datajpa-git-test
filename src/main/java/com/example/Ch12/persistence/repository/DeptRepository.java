package com.example.Ch12.persistence.repository;

import com.example.Ch12.persistence.entity.Book;
import com.example.Ch12.persistence.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDate;
import java.util.List;

public interface DeptRepository extends JpaRepository<Dept, Integer>{ //DAO
}
