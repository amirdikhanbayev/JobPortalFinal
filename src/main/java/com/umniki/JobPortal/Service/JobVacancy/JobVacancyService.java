package com.umniki.JobPortal.Service.JobVacancy;

import com.umniki.JobPortal.Entity.JobVacancy;

import java.util.List;
import java.util.Optional;

public interface JobVacancyService {
    List<JobVacancy> listAll();
    JobVacancy findById(String id);
    void deleteById(String id);
    JobVacancy findByDescription(String desc);

    JobVacancy createVacancy(JobVacancy jobVacancy);
}
