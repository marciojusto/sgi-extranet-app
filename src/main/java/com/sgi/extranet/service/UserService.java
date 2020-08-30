package com.sgi.extranet.service;

import com.sgi.extranet.model.User;
import com.sgi.extranet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public Optional<Iterable<User>> findAll() {
        return Optional.of(repository.findAll());
    }
}
