package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String getUsers(Model model) {
        model.addAttribute("admin", userService.userList());
        return "admin";
    }

    @GetMapping(value = "/addNewUser")
    public String addNewUser(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("roles", roleService.roleList());
        return "user-info";
    }

    @PostMapping(value = "/saveUser")
    public String saveUser(@ModelAttribute("newUser") User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping(value = "/updateUser")
    public String getUserById(@RequestParam("id") long id, Model model) {
        model.addAttribute("newUser", userService.getUserById(id));
        model.addAttribute("roles", roleService.roleList());
        return "update";
    }

    @PatchMapping(value = "/updateUser")
    public String updateUser(@RequestParam("id") long id, User user) {
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam("id") long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}