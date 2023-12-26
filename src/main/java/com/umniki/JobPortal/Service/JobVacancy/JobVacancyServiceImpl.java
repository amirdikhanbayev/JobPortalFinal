package com.umniki.JobPortal.Service.JobVacancy;

import com.umniki.JobPortal.Entity.JobVacancy;
import com.umniki.JobPortal.Repository.JobVacancyRepository;
import com.umniki.JobPortal.Service.JobVacancy.JobVacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobVacancyServiceImpl implements JobVacancyService {
    private JobVacancyRepository jobVacancyRepository;
    @Override
    public List<JobVacancy> listAll() {
        return jobVacancyRepository.findAll();
    }

    @Override
    public Optional<JobVacancy> findById(String id) {
        return Optional.of(jobVacancyRepository.findById(id).orElseThrow());
    }

    @Override
    public void deleteById(String id) {
        jobVacancyRepository.deleteById(id);
    }

    @Override
    public JobVacancy findByDescription(String desc) {
        return jobVacancyRepository.findJobVacancyByDescription(desc).orElseThrow();
    }

    @Override
    public JobVacancy createVacancy(JobVacancy jobVacancy) {
        return jobVacancyRepository.save(jobVacancy);
    }


}
