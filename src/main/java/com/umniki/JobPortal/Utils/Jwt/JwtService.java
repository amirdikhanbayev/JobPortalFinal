package com.umniki.JobPortal.Utils.Jwt;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String extractUserName(String token);
    String generateAccessToken(UserDetails userDetails);
    boolean isTokenValid(String token, UserDetails userDetails);

}
