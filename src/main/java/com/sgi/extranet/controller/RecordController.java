package com.sgi.extranet.controller;

import com.sgi.extranet.exceptions.EntityNotFoundException;
import com.sgi.extranet.model.Record;
import com.sgi.extranet.service.RecordService;
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

import static com.sgi.extranet.util.GlobalVariables.Entities.RECORD;
import static com.sgi.extranet.util.GlobalVariables.Entities.USER;
import static com.sgi.extranet.util.GlobalVariables.ExceptionMessages.ENF;

@Slf4j
@RestController
@RequestMapping("records")
@RequiredArgsConstructor
public class RecordController {

    private final MessageSource messageSource;
    private final RecordService service;
    private final UserService userService;

    @GetMapping
    Iterable<Record> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    Record findById(@PathVariable Long id) {
        return service.findById(id)
                      .orElseThrow(() -> new EntityNotFoundException(
                              messageSource.getMessage(ENF, new Object[] {USER, id}, Locale.getDefault())));
    }

    @PostMapping
    Record insert(@RequestBody Record record) {
        return service.insertOrUpdate(record);
    }

    @PutMapping("/{id}")
    Record update(@PathVariable Long id, @RequestBody Record updateRecord) {
        Record record = service.findById(id)
                               .orElseThrow(() -> new EntityNotFoundException(
                                    messageSource.getMessage(ENF, new Object[]{RECORD, id}, Locale.getDefault())));
        updateRecord.setId(record.getId());
        return service.insertOrUpdate(updateRecord);
    }

}
