package com.oro.model1.repository;

import com.oro.model1.entity.CarPart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CarPartRepository extends JpaRepository<CarPart, Long> {

    List<CarPart> findCarPartsByUnitPriceBetween(BigDecimal start, BigDecimal end);
}
