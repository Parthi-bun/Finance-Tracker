package com.example.FinanceTracker.service;

import com.example.FinanceTracker.model.User;


public interface UserService {
    void saveUser(User user);
    User getUserByUsername(String username);
}
