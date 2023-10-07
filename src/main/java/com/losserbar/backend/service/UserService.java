package com.losserbar.backend.service;

import com.losserbar.backend.entity.User;
import com.losserbar.backend.model.login.LoginRequest;
import com.losserbar.backend.model.login.LoginResponse;
import com.losserbar.backend.model.response.OpenApiResponse;
import com.losserbar.backend.model.response.OpenApiResponseCode;
import com.losserbar.backend.repository.UserRepository;
import com.losserbar.backend.utils.OpenApiUtilService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final OpenApiUtilService openApiUtilService;

    @Autowired
    public UserService(UserRepository userRepository, OpenApiUtilService openApiUtilService) {
        this.userRepository = userRepository;
        this.openApiUtilService = openApiUtilService;
    }

    public ResponseEntity<OpenApiResponse> login(HttpHeaders httpHeaders, LoginRequest loginRequest) {

        User user = userRepository.findByUsername(loginRequest.getUsername());

        if (user == null || !user.getPassword().equals(loginRequest.getPassword())) {
            return openApiUtilService.generateResponseEntityWithStandardError(httpHeaders, OpenApiResponseCode.INVALID_USERNAME_OR_PASSWORD);
        }

        // Generate a JWT token upon successful login
        String token = generateToken(loginRequest.getUsername());

        // Return the token in the response
        LoginResponse response = new LoginResponse();
        response.setToken(token);

        return openApiUtilService.generateSuccessOpenApiResponse(response);
    }

    // Generate a JWT token with a 1-hour expiration
    private String generateToken(String username) {
        long expiration = System.currentTimeMillis() + 3600_000; // 1 hour
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(expiration))
                .signWith(SignatureAlgorithm.HS256, "your-secret-key")
                .compact();
    }
}
