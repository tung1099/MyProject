package com.example.myproject.service;

import com.example.myproject.entity.User;
import com.example.myproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public User create(User user) {
        if (user.getEmail() == null  || user.getEmail().isEmpty()) {
            return null;
        }
        if (user.getName() == null  || user.getName().isEmpty()) {
            return null;
        }
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User user) {
        User fromDB = userRepository.findById(id).orElse(null);
        if (fromDB == null) {
            return null;
        }
        fromDB.setEmail(user.getEmail());
        fromDB.setName(user.getName());
        return userRepository.save(fromDB);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
}
