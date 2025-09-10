package com.example.FinanceTracker.controller;

import com.example.FinanceTracker.model.Transactions;
import com.example.FinanceTracker.model.User;
import com.example.FinanceTracker.service.TransactionService;
import com.example.FinanceTracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class TransactionController {

    private final TransactionService transactionService;
    private final UserService userService;

    @Autowired
    public TransactionController(TransactionService transactionService, UserService userService) {
        this.transactionService = transactionService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String homePage(){
        return "homepage";
    }

    @GetMapping("/transactions")
    public String transactionsPage(@RequestParam(required = false,defaultValue = "Newest") String sort, Model model, Principal principal){
        User user=userService.getUserByUsername(principal.getName());
        model.addAttribute("transactions", transactionService.getAllTransactionsSorted(sort, user));
        model.addAttribute("balance", transactionService.calculateBalance(user));
        model.addAttribute("income",transactionService.calculateTotalIncome(user));
        model.addAttribute("expense",transactionService.calculateTotalExpense(user));
        return "transactions";
    }

    @PostMapping("/addTransaction")
    public String addTransactionPage(@ModelAttribute("Transactions") Transactions newTransaction, Principal principal){
        User user=userService.getUserByUsername(principal.getName());
        transactionService.saveTransaction(newTransaction,user);
        return "redirect:/transactions";
    }

    @PostMapping("/deleteTransaction/{id}")
    public String deleteTransactionPage(@PathVariable long id){
        transactionService.deleteTransaction(id);
        return "redirect:/transactions";
    }
}
