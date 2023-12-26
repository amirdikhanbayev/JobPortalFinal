package com.umniki.JobPortal.DTO;

import com.umniki.JobPortal.Entity.User;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
@Data
public class SummaryDto {
    private String specialization;
    private String position;
    private Integer salary;
    private String about;
    private Integer experience;
}
