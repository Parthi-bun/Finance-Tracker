package com.example.FinanceTracker.service;

import com.example.FinanceTracker.model.Transactions;
import com.example.FinanceTracker.model.User;

import java.util.List;

public interface TransactionService {
    void saveTransaction(Transactions transaction, User user);
    void deleteTransaction(long id);
    List<Transactions> getAllTransactions(User user);
    Transactions getTransactionById(Long id);
    double calculateBalance(User user);
    double calculateTotalIncome(User user);
    double calculateTotalExpense(User user);
    List<Transactions> getAllTransactionsSorted(String sort,User user);
}
