package ru.kata.spring.boot_security.demo.repository;

import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;

public interface UserDao {

    List<User> userList();

    void saveUser(User user);

    void deleteUser(long id);

    void updateUser(User user);

    User getUserById(long id);

    User getUserByName(String name);
}
