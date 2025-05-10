package com.example.Ch12.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    //多對多映射
    @ManyToMany(cascade = CascadeType.PERSIST)//一併儲存被參考的物件
    //多對多會生成名叫 user_role 的中介表/關聯表
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns =
            @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;

    //刻意不使用 Lombok 的 ToString 註釋，以避免迴圈引用導致問題
    //也刻意不在當中加上實體連結屬性
    @Override
    public String toString() {
        return "User{" +
                "id = " + id +
                ", name = '" + name + "'}";
    }
}
