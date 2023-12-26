package com.umniki.JobPortal.Utils.Response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class JwtAuthenticationResponse {
    private String accessToken;
}
