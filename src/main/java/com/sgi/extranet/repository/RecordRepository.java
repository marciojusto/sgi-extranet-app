package com.sgi.extranet.repository;

import com.sgi.extranet.model.Record;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecordRepository extends CrudRepository<Record, Long> {

    Optional<Record> findById(Long id);
}
