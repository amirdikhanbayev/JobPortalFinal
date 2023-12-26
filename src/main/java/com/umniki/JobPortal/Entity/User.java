package com.umniki.JobPortal.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user")
@Getter
@Data
public class User implements UserDetails {
    @Id
    private String id;
    @Indexed(unique = true)
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private Role role;
    private List<Summary> summaries;
    private List<JobVacancy> jobVacancies;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public void setId(String id) {
        this.id = id;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setSummaries(Summary summary) {
        if (this.summaries == null) {
            this.summaries = new ArrayList<>();
        }
        this.summaries.add(summary);
    }

    public void setJobVacancies(JobVacancy jobVacancy) {
        if (this.jobVacancies == null) {
            this.jobVacancies = new ArrayList<>();
        }
        this.jobVacancies.add(jobVacancy);
    }

}
