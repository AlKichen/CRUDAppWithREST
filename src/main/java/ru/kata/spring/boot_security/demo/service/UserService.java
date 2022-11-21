package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void createNewUser(User user);

    User getUser(Long id);

    void updateUser(Long id, User updatedUser);

    void deleteUser(Long id);
}
