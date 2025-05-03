package com.example.Ch12.persistence.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Resident2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String telephone;

    //基於外鍵的一對一關聯映射
    @OneToOne(mappedBy = "resident",
                cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Idcard2 idcard;


}
