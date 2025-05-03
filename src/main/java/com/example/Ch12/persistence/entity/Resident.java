package com.example.Ch12.persistence.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Resident {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String telephone;

    //一對一關聯映射
    //mappedBy指定有關係的欄位，該欄位是連接實體的某個屬性
    //CascadeType.PERSIST 設定串聯儲存,即儲存一個實體時將串聯儲存連接的實體
    //CascadeType.REMOVE 設定串聯刪除,即刪除一個實體時將串聯刪除連接的實體
    @OneToOne(mappedBy = "resident",
                cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Idcard idcard;


}
