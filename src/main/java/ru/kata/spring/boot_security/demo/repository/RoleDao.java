package ru.kata.spring.boot_security.demo.repository;

import ru.kata.spring.boot_security.demo.entity.Role;

import java.util.List;

public interface RoleDao {

    List<Role> roleList();

    void saveRole(Role role);

    Role getRoleById(long id);
}
