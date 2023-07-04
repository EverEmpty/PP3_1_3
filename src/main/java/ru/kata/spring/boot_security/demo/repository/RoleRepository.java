package ru.kata.spring.boot_security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("select role from Role role where role.roleName = :name")
    Role findByName(String name);

}
