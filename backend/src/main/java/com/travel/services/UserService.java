package com.travel.services;

import com.travel.models.User;

import java.util.List;

public interface UserService {
    void save(User user);

    User findByEmail(String email);
    List<User> findAll();
}