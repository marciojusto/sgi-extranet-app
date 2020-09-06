package com.sgi.extranet.service;

import com.sgi.extranet.model.Record;
import com.sgi.extranet.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecordService {

    private final RecordRepository repository;

    public Iterable<Record> findAll() {
        return repository.findAll();
    }

    public Optional<Record> findById(Long id) {
        return repository.findById(id);
    }

    public Record insertOrUpdate(Record record) {
        return repository.save(record);
    }

}
