package com.oro.model1.service;

import com.oro.model1.entity.CarPart;
import com.oro.model1.exception.CarPartNotFoundException;
import com.oro.model1.repository.CarPartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Service
public class CarPartService {

    private CarPartRepository carPartRepository;

    public CarPart getCarPartById(long id) {
        return carPartRepository.findById(id).orElseThrow(() -> new CarPartNotFoundException("Car not found"));
    }

    public List<CarPart> getCarPartsBetweenPrices(int start, int end) {
        return carPartRepository.findCarPartsByUnitPriceBetween(BigDecimal.valueOf(start), BigDecimal.valueOf(end));
    }
}
