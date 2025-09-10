package com.example.FinanceTracker.repository;

import com.example.FinanceTracker.model.Transactions;
import com.example.FinanceTracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Long> {
    List<Transactions> findByUser(User user);

}
