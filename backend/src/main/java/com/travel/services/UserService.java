package com.travel.services;

import com.travel.models.User;

import java.util.List;
import java.util.Set;


public interface UserService {
    void save(User user);

    User findByEmail(String email);

    Set<User> findByRole(String email);

    User findById(Long userId);

    List<User> findAll();

    void deleteById(Long userId);

    Boolean hasRole(User user, String roleName);

    void addRole(User user, String roleName);

    void removeRole(User user, String roleName);
}