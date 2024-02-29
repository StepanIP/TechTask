package com.example.techtask.service;

import com.example.techtask.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    User create(User user);
    User readById(String id);
    User update(User user);
    void delete(String id);
    List<User> getAll();
    User readByEmail(String email);
    UserDetailsService userDetailsService();

}
