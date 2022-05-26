package com.example.practice_15.repository;

import com.example.practice_15.model.Manufacture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufactureRepository extends JpaRepository<Manufacture, Integer> {
}
