package com.example.Ch12.persistence.repository;

import com.example.Ch12.persistence.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidentRepository extends JpaRepository<Resident, Integer> {
}
