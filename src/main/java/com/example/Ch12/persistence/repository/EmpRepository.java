package com.example.Ch12.persistence.repository;

import com.example.Ch12.persistence.entity.Emp;
import com.example.Ch12.persistence.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository<Emp, Integer> {

}
