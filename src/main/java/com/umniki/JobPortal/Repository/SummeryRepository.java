package com.umniki.JobPortal.Repository;

import com.umniki.JobPortal.Entity.Summary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SummeryRepository extends MongoRepository<Summary, String> {
    Optional<Summary> findSummaryBySpecialization(String spec);
}
