package com.oro.model1.controller;

import com.oro.model1.entity.CarPart;
import com.oro.model1.service.CarPartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/car-part")
@RestController
@RequiredArgsConstructor
public class CarPartController {

    private final CarPartService carPartService;

    @GetMapping("/unit-price/between/{start}/{end}")
    public List<CarPart> getCarPartsBetweenPrices(@PathVariable int start, @PathVariable int end) {
        return carPartService.getCarPartsBetweenPrices(start, end);
    }
}
