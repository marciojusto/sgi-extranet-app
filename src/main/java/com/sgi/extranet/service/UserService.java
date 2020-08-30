package com.sgi.extranet.service;

import com.sgi.extranet.model.User;
import com.sgi.extranet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public Iterable<User> findAll() {
        return repository.findAll();
    }
}
