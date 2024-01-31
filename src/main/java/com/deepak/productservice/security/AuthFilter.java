package com.deepak.productservice.security;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.deepak.productservice.services.AuthService;
import com.deepak.productservice.services.IAuthService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
@Order(1)
public class AuthFilter implements Filter {
    private final IAuthService authService;

    AuthFilter(IAuthService authService) {
        this.authService = authService;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IllegalStateException, ServletException, IOException {
        try {
            HttpServletRequest req = (HttpServletRequest) request;
            final String authHeader = req.getHeader("Authorization");
            final String jwt;
            if (authHeader == null || !authHeader.startsWith("Bearer ")){
                throw new Exception("Unauthorized");
            }

            jwt = authHeader.substring(7);
            // Call userService to authenticate the user
            if (authService.isAuthenticated(jwt)) {
                filterChain.doFilter(request, response);
            }
            else {
                throw new Exception("Unauthorized");
            }

        }
        catch (Exception ex) {
            HttpServletResponse res = (HttpServletResponse) response;
            res.getWriter().write("Unauthorized");
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
