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

    @Test
    void saveDept() {
        Dept dept = new Dept();

        dept.setName("市場部");
        dept.setLoc("東京");

        Emp emp1 = new Emp();
        emp1.setName("張三");
        emp1.setSalary(3000.00);
        emp1.setDept(dept);

        Emp emp2 = new Emp();
        emp2.setName("老王");
        emp2.setSalary(6000.00);
        emp2.setDept(dept);

        dept.addEmp(emp1);
        dept.addEmp(emp2);

        deptRepository.save(dept);
    }

    @Test
    void getDeptById() {
        Optional<Dept> optionalDept = deptRepository.findById(1);
        if(optionalDept.isPresent()) {
            Dept dept = optionalDept.get();
            System.out.println("部門名稱:" + dept.getName());
            System.out.println("部門位置:" + dept.getLoc());
        }
    }

    @Test
    void deleteDept() {
        Optional<Dept> optionalDept = deptRepository.findById(1);
        if(optionalDept.isPresent()) {
            Dept dept = optionalDept.get();
           deptRepository.delete(dept);
        }
    }


}
