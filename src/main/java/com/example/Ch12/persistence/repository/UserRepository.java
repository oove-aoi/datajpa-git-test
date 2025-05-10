package com.example.Ch12.persistence.repository;

import com.example.Ch12.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
