package com.tpxsports.tpxsports.controllers;

import com.tpxsports.tpxsports.domains.User;
import com.tpxsports.tpxsports.repository.UserRepository;
import com.tpxsports.tpxsports.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping
    public @ResponseBody
    List<User> getAllUsers() {
        return service.findAllUsers();
    }

    @GetMapping(path = "/stats/{id}")
    public @ResponseBody
    User getAllUsers(@PathVariable Integer id) {
        return service.findStatsUser(id);
    }

}
