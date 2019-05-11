package com.travel.services;

public interface SecurityService {
    String findLoggedInEmail();

    void autoLogin(String email, String password);
}