package com.deepak.productservice.services;

import com.deepak.productservice.dtos.AuthRequestDTO;
import com.deepak.productservice.dtos.SessionStatus;
import com.deepak.productservice.fakestoreapi.FakeStoreProductRequest;
import com.deepak.productservice.fakestoreapi.FakeStoreProductResponse;
import com.deepak.productservice.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService implements IAuthService {
    private RestTemplateBuilder templateBuilder;
    private final RestTemplate template;
    @Autowired
    public AuthService(RestTemplateBuilder templateBuilder) {
        template = templateBuilder.build();
    }
    public boolean isAuthenticated(String token) {
        AuthRequestDTO authRequestDTO = new AuthRequestDTO();
        authRequestDTO.setToken(token);
        SessionStatus dto = template.
                postForObject("http://localhost:8081/auth/validate",
                        authRequestDTO,
                        SessionStatus.class);
        return dto == SessionStatus.ACTIVE;
    }
}
