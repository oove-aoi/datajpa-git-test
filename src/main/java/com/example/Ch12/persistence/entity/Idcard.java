package com.example.Ch12.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Data
@Entity
public class Idcard {
    @Id
    //設定在 Idcard 資料表的主鍵上外鍵約束
    //Idcard 的主見生成策略參考屬性 resident 的主鍵生成策略生成
    @GeneratedValue(generator = "frGenerator")
    @GenericGenerator(name = "frGenerator", strategy = "foreign",
                        parameters = @Parameter(name = "property", value = "resident"))
    private Integer id;
    private String number;
    private java.sql.Date birthday;
    private String homeaddress;

    //optional = false 關聯不得為 null（強制存在）
    @OneToOne(optional = false)
    //PrimaryKeyJoinColumn 表示兩個實體共用同一個主鍵欄位（id），即外鍵＝主鍵
    @PrimaryKeyJoinColumn
    private Resident resident;
}
