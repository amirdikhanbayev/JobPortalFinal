package com.umniki.JobPortal.Service.Vacancy;

import com.umniki.JobPortal.Entity.Summary;

import java.util.List;
import java.util.Optional;

public interface SummeryService {
    List<Summary> listAll();
    Optional<Summary> findById(String id);
    void deleteById(String id);
    Summary findBySpecialization(String spec);
    Summary createSummary(Summary summary);
}
