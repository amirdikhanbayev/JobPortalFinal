package com.umniki.JobPortal.Utils.Request;

import lombok.Data;

@Data
public class SingInRequest {
    private String email;
    private String password;
}
