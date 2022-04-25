package com.example.demo.service;

import com.example.demo.model.User;

public interface AuthService {
    User login(String user_username, String user_password);
}
