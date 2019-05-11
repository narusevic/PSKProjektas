package com.travel.services;

import com.travel.models.User;

public interface UserService {
    void save(User user);

    User findByEmail(String email);
}