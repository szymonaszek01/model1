package com.oro.model1.repository;

import com.oro.model1.entity.CarPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarPartRepository extends JpaRepository<CarPart, Long> {
}
