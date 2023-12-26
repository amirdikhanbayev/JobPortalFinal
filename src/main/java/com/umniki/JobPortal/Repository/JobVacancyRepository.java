package com.umniki.JobPortal.Repository;

import com.umniki.JobPortal.Entity.JobVacancy;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobVacancyRepository extends MongoRepository<JobVacancy,String> {
    Optional<JobVacancy> findJobVacancyByDescription(String desc);

    Optional<JobVacancy> findJobVacancyById(String id);
}
