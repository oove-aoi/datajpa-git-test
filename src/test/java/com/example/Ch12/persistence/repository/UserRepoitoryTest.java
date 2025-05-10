package com.example.Ch12.persistence.repository;

import com.example.Ch12.persistence.entity.Role;
import com.example.Ch12.persistence.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class UserRepoitoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void saveUser() {
        //user @ManyToMany 須加上 cascade = CascadeType.PERSIST不然不會一併儲存導致錯誤
        User user = new User();
        user.setName("張三");

        Role role1 = new Role();
        role1.setName("主管");
        Role role2 = new Role();
        role2.setName("管理員");

        List<Role> roles = new ArrayList<>();
        roles.add(role1);
        roles.add(role2);

        user.setRoles(roles);
        userRepository.save(user);
    }

    @Test
    void getUserById() {
        Optional<User> optionalUser = userRepository.findById(1);
        if(optionalUser.isPresent()) {
            User user = optionalUser.get();
            System.out.println("使用者名稱: " + user.getName());
            System.out.println("使用者的角色: " + user.getRoles());
        }
    }

    @Test
    void deleteUser() {

        userRepository.deleteById(1);
    }
}
