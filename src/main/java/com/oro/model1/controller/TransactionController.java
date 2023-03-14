package com.oro.model1.controller;

import com.oro.model1.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/transaction")
@RestController
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping("/count-all")
    public long countTransactions() {
        return transactionService.countAllTransactions();
    }

    @GetMapping("count/car-part-id/{carPartId}")
    public long countTransactionsByCarPart(@PathVariable int carPartId) {
        return transactionService.countTransactionsByCartPart(carPartId);
    }

    @GetMapping("count/user-profile-id/{userProfileId}")
    public long countTransactionsByUserProfile(@PathVariable int userProfileId) {
        return transactionService.countTransactionsByUserProfile(userProfileId);
    }
}
