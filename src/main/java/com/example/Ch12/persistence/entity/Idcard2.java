package com.example.Ch12.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Data
@Entity
public class Idcard2 {
    @Id
    //設定在 Idcard 資料表的主鍵上外鍵約束
    //Idcard 的主見生成策略參考屬性 resident 的主鍵生成策略生成
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String number;
    private java.sql.Date birthday;
    private String homeaddress;


    @OneToOne
    //@JoinColumn 註釋指定用於連接實體連結或元素集合的欄位
    @JoinColumn(name = "resident_id")
    private Resident2 resident;
}
