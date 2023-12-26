package com.umniki.JobPortal.Controller.AuthController;


import com.umniki.JobPortal.Security.AuthenticationService;
import com.umniki.JobPortal.Utils.Request.SingInRequest;
import com.umniki.JobPortal.Utils.Request.SingUpRequest;
import com.umniki.JobPortal.Utils.Response.JwtAuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequiredArgsConstructor
@RequestMapping("api/v1/auth")
@CrossOrigin(origins = "*")
public class AuthenticationController {

    private final AuthenticationService authenticationService;


    @PostMapping("/signUp")
    public ResponseEntity<JwtAuthenticationResponse> signUp(@RequestBody SingUpRequest request){
        return ResponseEntity.ok(authenticationService.singUp(request));
    }

    @PostMapping("/signIn")
    public ResponseEntity<JwtAuthenticationResponse> signIn(@RequestBody SingInRequest request){
        return ResponseEntity.ok(authenticationService.singIn(request));
    }
}
