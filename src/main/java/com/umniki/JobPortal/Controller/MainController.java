package com.umniki.JobPortal.Controller;

import com.umniki.JobPortal.DTO.JobVacancyDto;
import com.umniki.JobPortal.DTO.SummaryDto;
import com.umniki.JobPortal.Entity.JobVacancy;
import com.umniki.JobPortal.Entity.Summary;
import com.umniki.JobPortal.Entity.User;
import com.umniki.JobPortal.Service.JobVacancy.JobVacancyService;
import com.umniki.JobPortal.Service.User.UserService;
import com.umniki.JobPortal.Service.Vacancy.SummeryService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/main")
public class MainController {
    private final UserService userService;
    private final SummeryService summeryService;
    private final JobVacancyService jobVacancyService;


    @PostMapping("/create-vacancy")
    public JobVacancy createVacancy(@RequestBody JobVacancyDto jobVacancyDto){
        JobVacancy jobVacancy = jobVacancyDataMapping(jobVacancyDto);
        return jobVacancyService.createVacancy(jobVacancy);
    }

    @PutMapping("/add-request/{id}/{sumId}")
    public JobVacancy addRequest(@PathVariable String id, @PathVariable String sumId){
        JobVacancy jobVacancy = jobVacancyService.findById(id) ;
        Summary summary = summeryService.findById(sumId).orElseThrow();
        jobVacancy.setRequests(summary);
        return jobVacancyService.createVacancy(jobVacancy);
    }

    @PostMapping("/create-summery")
    public Summary createSummery(@RequestBody SummaryDto summaryDto){
        Summary summary = summaryDataMapping(summaryDto);
        return summeryService.createSummary(summary);
    }

    @PatchMapping("/add-to-approved/{userId}/{vacancyId}")
    public User addToApproved(@PathVariable String userId, @PathVariable String vacancyId){
        User user = userService.findById(userId);
        JobVacancy jobVacancy = jobVacancyService.findById(vacancyId);
        user.setJobVacancies(jobVacancy);
        return userService.save(user);
    }


    private Summary summaryDataMapping(SummaryDto summaryDto){
        Summary summary = new Summary();
        summary.setUser(userService.getCurrentUser());
        summary.setExperience(summaryDto.getExperience());
        summary.setSalary(summaryDto.getSalary());
        summary.setPosition(summaryDto.getPosition());
        summary.setAbout(summaryDto.getAbout());
        summary.setSpecialization(summaryDto.getSpecialization());
        return summary;
    }

    private JobVacancy jobVacancyDataMapping(JobVacancyDto jobVacancyDto){
        JobVacancy jobVacancy = new JobVacancy();
        jobVacancy.setDescription(jobVacancyDto.getDescription());
        jobVacancy.setRequiredExperience(jobVacancyDto.getRequiredExperience());
        jobVacancy.setPosition(jobVacancyDto.getPosition());
        jobVacancy.setAbout(jobVacancyDto.getAbout());
        jobVacancy.setSalary(jobVacancyDto.getSalary());
        jobVacancy.setUser(userService.getCurrentUser());
        return jobVacancy;
    }





}
