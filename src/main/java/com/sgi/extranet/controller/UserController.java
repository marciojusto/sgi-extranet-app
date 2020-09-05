package com.sgi.extranet.controller;

import com.sgi.extranet.exceptions.EntityNotFoundException;
import com.sgi.extranet.model.Type;
import com.sgi.extranet.model.User;
import com.sgi.extranet.repository.TypeRepository;
import com.sgi.extranet.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

import static com.sgi.extranet.util.GlobalVariables.Entities.USER;
import static com.sgi.extranet.util.GlobalVariables.ExceptionMessages.ENF;

@Slf4j
@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final MessageSource messageSource;
    private final UserService service;
    private final TypeRepository typeRepository;

    @GetMapping
    Iterable<User> findAll() {
        return service.findAll();
    }

    @GetMapping("/types")
    Iterable<Type> findAllTypes() {
        return typeRepository.findAll();
    }

    @GetMapping("/{id}")
    User findById(@PathVariable Long id) {
        return service.findById(id)
                      .orElseThrow(() -> new EntityNotFoundException(
                              messageSource.getMessage(ENF, new Object[] {USER, id}, Locale.getDefault())));
    }

    @PostMapping
    User insert(@RequestBody User user) {
        return service.insertOrUpdate(user);
    }

    @PutMapping("/{id}")
    User update(@PathVariable Long id, @RequestBody User updateUser) {
        User user = service.findById(id)
                            .orElseThrow(() -> new EntityNotFoundException(
                                    messageSource.getMessage(ENF, new Object[]{USER, id}, Locale.getDefault())));
        updateUser.setId(user.getId());
        return service.insertOrUpdate(updateUser);
    }
}
