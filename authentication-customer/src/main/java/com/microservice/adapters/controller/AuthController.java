package com.microservice.adapters.controller;

import com.microservice.domain.dtos.AuthRequest;
import com.microservice.infrastructure.entity.Customer;
import com.microservice.domain.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/authentication-customer")
public class AuthController {

    private final AuthService service;

    private final AuthenticationManager authenticationManager;

    public AuthController(AuthService service, AuthenticationManager authenticationManager) {
        this.service = service;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public String addCustomer(@RequestBody Customer customer) {
        return service.saveCustomer(customer);
    }

    @PostMapping("/token")
    public String getToken(@RequestBody AuthRequest authRequest) {
        Authentication authenticate = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
            return service.generateToken(authRequest.getUsername());
        } else {
            throw new InvalidCredentialsException("Invalid username or password");
        }
    }

    public static class InvalidCredentialsException extends RuntimeException {
        public InvalidCredentialsException(String message) {
            super(message);
        }
    }

}
