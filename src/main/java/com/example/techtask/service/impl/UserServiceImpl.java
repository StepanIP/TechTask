package com.example.techtask.service.impl;

import com.example.techtask.exception.EntityNotFoundException;
import com.example.techtask.exception.NullEntityReferenceException;
import com.example.techtask.model.User;
import com.example.techtask.repository.UserRepository;
import com.example.techtask.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User role) {
        throw new NullEntityReferenceException("User cannot be 'null'");
    }

    @Override
    public User readById(String id) {
        return userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User with id " + id + " not found"));
    }

    @Override
    public User update(User role) {
        throw new NullEntityReferenceException("User cannot be 'null'");
    }

    @Override
    public void delete(String id) {
        userRepository.delete(readById(id));
    }

    @Override
    public List<User> getAll() {
        List<User> users = userRepository.findAll();
        return users.isEmpty() ? new ArrayList<>() : users;
    }

    @Override
    public User readByEmail(String email) {
        if(userRepository.findByEmail(email)==null){
            throw new EntityNotFoundException("User with email " + email + " not found");
        }
        return userRepository.findByEmail(email);
    }

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String email) {
                return userRepository.findByEmail(email);
            }
        };
    }
}
