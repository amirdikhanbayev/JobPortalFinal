package com.umniki.JobPortal.Utils.Request;

import com.umniki.JobPortal.Entity.Role;
import lombok.Data;

@Data
public class SingUpRequest {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private Role role;
}
