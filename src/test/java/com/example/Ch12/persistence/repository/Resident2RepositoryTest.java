package com.example.Ch12.persistence.repository;

import com.example.Ch12.persistence.entity.Idcard;
import com.example.Ch12.persistence.entity.Idcard2;
import com.example.Ch12.persistence.entity.Resident;
import com.example.Ch12.persistence.entity.Resident2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.Optional;

@SpringBootTest
public class Resident2RepositoryTest {
    @Autowired
    private Resident2Repository resident2Repository;

    @Test
    void saveResident() {
        /*
        Idcard idcard = new Idcard();
        idcard.setBirthday(Date.valueOf("1997-07-27"));
        idcard.setHomeaddress("高雄太空城");
        idcard.setNumber("19755544***");

        Resident resident = new Resident();
        resident.setName("李四");
        resident.setIdcard(idcard);
        resident.setTelephone("094446551");

        idcard.setResident(resident);
        resident.setIdcard(idcard);
        residentRepository.save(resident);
        */

        Resident2 resident = new Resident2();
        resident.setName("李四");
        resident.setTelephone("094446551");

        Idcard2 idcard = new Idcard2();
        idcard.setBirthday(Date.valueOf("1997-07-27"));
        idcard.setHomeaddress("高雄太空城");
        idcard.setNumber("19755544741");
        idcard.setResident(resident);

        // 再把 Idcard 設給 resident
        resident.setIdcard(idcard);

        // 再次存一次 resident，連帶存入 idcard
        resident2Repository.save(resident);


    }

    @Test
    void getResidentById() {
        Optional<Resident2> optionalResident = resident2Repository.findById(1);
        if(optionalResident.isPresent()) {
            Resident2 resident = optionalResident.get();
            System.out.println("姓名:" + resident.getName());
            System.out.println("身分證字號:" + resident.getIdcard().getNumber());
        }
    }

    @Test
    void deleteResident() {
        Optional<Resident2> optionalResident = resident2Repository.findById(1);
        if(optionalResident.isPresent()) {
            Resident2 resident = optionalResident.get();
            //也可以直接呼叫 CrudRepository 介面中的 deleteById() 方法，透過傳入 id 值來刪除實體
            resident2Repository.delete(resident);

        }
    }
}
