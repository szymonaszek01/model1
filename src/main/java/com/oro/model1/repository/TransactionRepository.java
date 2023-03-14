package com.oro.model1.repository;

import com.oro.model1.entity.CarPart;
import com.oro.model1.entity.Transaction;
import com.oro.model1.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    long countTransactionsByCarPart(CarPart carPart);

    long countTransactionsByUserProfile(UserProfile userProfile);
}
