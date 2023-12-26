package com.umniki.JobPortal.Security;

import com.umniki.JobPortal.Utils.Request.SingInRequest;
import com.umniki.JobPortal.Utils.Request.SingUpRequest;
import com.umniki.JobPortal.Utils.Response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse singIn(SingInRequest request);
    JwtAuthenticationResponse singUp(SingUpRequest request);

}
