package com.example.FinanceTracker.service;

import com.example.FinanceTracker.model.Transactions;
import com.example.FinanceTracker.model.User;
import com.example.FinanceTracker.repository.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionsRepository transactionsRepository;

    @Autowired
    public TransactionServiceImpl(TransactionsRepository transactionsRepository) {
        this.transactionsRepository = transactionsRepository;
    }
    @Override
    public void saveTransaction(Transactions transaction, User user) {
        transaction.setUser(user);
       transactionsRepository.save(transaction);
    }
    @Override
    public void deleteTransaction(long id) {
        transactionsRepository.deleteById(id);
    }
    @Override
    public List<Transactions> getAllTransactions(User user) {
        return transactionsRepository.findByUser(user);
    }
    @Override
    public Transactions getTransactionById(Long id) {
        Optional<Transactions> transactions = transactionsRepository.findById(id);
        Transactions transaction=null;
        if (transactions.isPresent()) {
            transaction = transactions.get();
        }else{
            throw new RuntimeException("Transaction not found");
        }
        return transaction;
    }
    @Override
    public double calculateBalance(User user){
        List<Transactions> transactions = getAllTransactions(user);
        double balance = 0;
        for(Transactions transaction : transactions){
            if("income".equalsIgnoreCase(transaction.getType())){
                balance+=transaction.getAmount();
            }
            if("Expense".equalsIgnoreCase(transaction.getType())){
                balance-=transaction.getAmount();
            }
        }
        return balance;
    }
    @Override
    public List<Transactions> getAllTransactionsSorted(String sort,User user){
        List<Transactions> transactions = getAllTransactions(user);
        switch (sort){
            case "Newest":
                transactions.sort(Comparator.comparing(Transactions::getDate).reversed());
                break;
            case "Oldest":
                transactions.sort(Comparator.comparing(Transactions::getDate));
                break;
            case "Highest":
                transactions.sort(Comparator.comparing(Transactions::getAmount).reversed());
                break;
            case "Lowest":
                transactions.sort(Comparator.comparing(Transactions::getAmount));
                break;
            case "Type":
                transactions.sort(Comparator.comparing(Transactions::getType));
                break;

        }
        return transactions;
    }
    @Override
    public double calculateTotalIncome(User user) {
        List<Transactions> transactions = getAllTransactions(user);
        double totalIncome =0;
        for(Transactions transaction : transactions ){
            if("income".equalsIgnoreCase(transaction.getType())){
                totalIncome+=transaction.getAmount();
            }
        }
        return totalIncome;
    }
    @Override
    public double calculateTotalExpense(User user){
        List<Transactions> transactions = getAllTransactions(user);
        double totalExpense=0;
        for(Transactions transaction : transactions ){
            if("expense".equalsIgnoreCase(transaction.getType())){
                totalExpense+=transaction.getAmount();
            }
        }
        return totalExpense;
    }

}
