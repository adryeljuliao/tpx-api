package com.tpxsports.tpxsports.controllers;

import com.tpxsports.tpxsports.domains.User;
import com.tpxsports.tpxsports.repository.UserRepository;
import com.tpxsports.tpxsports.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<User> getStatsUser(@PathVariable Integer id) {

        return Optional
                .ofNullable(service.findStatsUser(id))
                .map(user -> ResponseEntity.ok().body(user))
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

}
