package com.example.Ch12.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Dept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String Loc;

    //一對多映射
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "dept")
    private List<Emp> emps;

    //便捷方法，方便向部門增加員工
    public void addEmp(Emp emp) {
        if(emps == null) {
            emps = new ArrayList<>();
        }
        emps.add(emp);
    }
}
