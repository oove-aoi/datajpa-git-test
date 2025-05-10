package com.example.Ch12.persistence.repository;

import com.example.Ch12.persistence.entity.Dept;
import com.example.Ch12.persistence.entity.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;


@SpringBootTest
public class EmpRepositoryTest {
    @Autowired
    private DeptRepository deptRepository;

    @Autowired
    private EmpRepository empRepository;

    @Test
    void saveEmp() {
        Emp emp = new Emp();
        emp.setName("王武");
        emp.setSalary(3500.00);


        Dept dept = deptRepository.getById(2);
        emp.setDept(dept);
        empRepository.save(emp);
    }

    @Test
    void getEmpById() {
        Optional<Emp> optionalEmp = empRepository.findById(1);
        if(optionalEmp.isPresent()) {
            Emp emp = optionalEmp.get();
            System.out.println("部門名稱:" + emp.getName());
            System.out.println("部門位置:" + emp.getDept().getName());
        }
    }

    @Test
    void deleteDept() {
        empRepository.deleteById(3);
    }


}
