package com.project.library.service;

import com.project.library.controller.exceptions.UserNotFoundException;
import com.project.library.domain.User;
import com.project.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User saveUser(final User user) {
        return repository.save(user);
    }

    public User getUser(final Integer id) throws UserNotFoundException {
        return repository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public void deleteUser(Integer id) {
        repository.deleteById(id);
    }
}
