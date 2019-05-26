package com.travel.services;

import java.util.List;
import java.util.Set;

import com.travel.models.User;

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