package com.example.practice_15.service;

import com.example.practice_15.dto.UserRegistrationDto;
import com.example.practice_15.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}