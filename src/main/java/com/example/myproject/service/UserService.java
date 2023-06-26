package com.example.myproject.service;

import com.example.myproject.entity.User;

public interface UserService {
    User create(User user);
    User update(Long id, User user);
    void delete(Long id);
    User findById(Long id);
    Iterable<User> findAll();
}
