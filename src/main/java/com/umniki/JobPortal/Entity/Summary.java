package com.umniki.JobPortal.Entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "summary")
@Data
public class Summary {
    @Id
    private String id;
    @Indexed(unique = true)
    private String specialization;
    private User user;
    private String position;
    private Integer salary;
    private String about;
    private Integer experience;
}
