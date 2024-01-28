package com.deepak.productservice.services;

public interface IAuthService {
    boolean isAuthenticated(String token);
}
