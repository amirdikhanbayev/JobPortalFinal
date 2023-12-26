package com.umniki.JobPortal.DTO;

import com.umniki.JobPortal.Entity.User;
import lombok.Data;

@Data
public class JobVacancyDto {
    private String description;
    private String position;
    private Integer salary;
    private String about;
    private Integer requiredExperience;
}
