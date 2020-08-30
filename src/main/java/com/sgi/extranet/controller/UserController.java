package com.sgi.extranet.controller;

import com.sgi.extranet.model.User;
import com.sgi.extranet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping
    public ResponseEntity<Iterable<User>> findAll() {
        return ResponseEntity.of(service.findAll());
    }
}
