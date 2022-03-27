package com.example.demo.service;

import com.example.demo.model.User;

public interface AuthService {
    public User login(String username, String password);
}
