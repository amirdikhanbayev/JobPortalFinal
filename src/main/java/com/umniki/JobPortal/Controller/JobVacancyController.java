package com.umniki.JobPortal.Controller;

import com.umniki.JobPortal.Entity.JobVacancy;
import com.umniki.JobPortal.Service.JobVacancy.JobVacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/vacancy")
public class JobVacancyController {

    private final JobVacancyService service;

    @GetMapping("/list-all")
    public List<JobVacancy> list(){
        return service.listAll();
    }

    @GetMapping("/find-by-desc/{desc}")
    public JobVacancy findByDescription(@PathVariable String desc){
        return service.findByDescription(desc);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        service.deleteById(id);
    }

    @GetMapping("/find-by-id/{id}")
    public JobVacancy findById(@PathVariable String id){
        return service.findById(id).orElseThrow();
    }
}
