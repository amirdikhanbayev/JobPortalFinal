package com.umniki.JobPortal.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "jobVacancy")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class JobVacancy {
    @Id
    private String id;
    @Indexed(unique = true)
    private String description;
    private String position;
    private User user;
    private Integer salary;
    private String about;
    private Integer requiredExperience;
    private List<Summary> requests;

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setPosition(String position) {
        this.position = position;
    }


    public void setUser(User user) {
        this.user = user;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }


    public void setAbout(String about) {
        this.about = about;
    }


    public void setRequiredExperience(Integer requiredExperience) {
        this.requiredExperience = requiredExperience;
    }

    public void setRequests(Summary summary) {
        if (this.requests == null) {
            this.requests = new ArrayList<>();
        }
        this.requests.add(summary);

    }
}
