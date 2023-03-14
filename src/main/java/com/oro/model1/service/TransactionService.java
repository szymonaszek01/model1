package com.oro.model1.service;

import com.oro.model1.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TransactionService {

    private TransactionRepository transactionRepository;

    private CarPartService carPartService;

    private UserProfileService userProfileService;

    public long countAllTransactions() {
        return transactionRepository.count();
    }

    public long countTransactionsByCartPart(long carPartId) {
        return transactionRepository.countTransactionsByCarPart(carPartService.getCarPartById(carPartId));
    }

    public long countTransactionsByUserProfile(long userProfileId) {
        return transactionRepository.countTransactionsByUserProfile(userProfileService.getUserProfileById(userProfileId));
    }
}
