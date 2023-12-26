package com.umniki.JobPortal.Security;

import com.umniki.JobPortal.Entity.User;
import com.umniki.JobPortal.Repository.UserRepository;
import com.umniki.JobPortal.Utils.Jwt.JwtService;
import com.umniki.JobPortal.Utils.Request.SingInRequest;
import com.umniki.JobPortal.Utils.Request.SingUpRequest;
import com.umniki.JobPortal.Utils.Response.JwtAuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthenticationResponse singIn(SingInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findUserByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateAccessToken(user);
        return JwtAuthenticationResponse.builder().accessToken(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse singUp(SingUpRequest request) {
        User user = User
                .builder()
                .firstName(request.getFirstName())
                .lastName(request.getFirstName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
        userRepository.save(user);
        String jwt = jwtService.generateAccessToken(user);
        return JwtAuthenticationResponse.builder().accessToken(jwt).build();
    }

}
