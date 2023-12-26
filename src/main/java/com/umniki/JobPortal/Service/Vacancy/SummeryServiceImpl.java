package com.umniki.JobPortal.Service.Vacancy;

import com.umniki.JobPortal.Entity.Summary;
import com.umniki.JobPortal.Repository.SummeryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SummeryServiceImpl implements SummeryService {
    private final SummeryRepository summeryRepository;
    @Override
    public List<Summary> listAll() {
        return summeryRepository.findAll();
    }

    @Override
    public Optional<Summary> findById(String id) {
        return Optional.ofNullable(summeryRepository.findById(id).orElseThrow(() -> new RuntimeException("Summary not founden")));
    }

    @Override
    public void deleteById(String id) {
        summeryRepository.deleteById(id);
    }

    @Override
    public Summary findBySpecialization(String spec) {
        return summeryRepository.findSummaryBySpecialization(spec).orElseThrow();
    }

    @Override
    public Summary createSummary(Summary summary) {
        return summeryRepository.save(summary);
    }

}
