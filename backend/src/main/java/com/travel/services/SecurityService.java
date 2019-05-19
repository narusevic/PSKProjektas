package com.travel.services;

import com.travel.models.User;

public interface SecurityService {
    String findLoggedInEmail();

    void autoLogin(String email, String password);
}