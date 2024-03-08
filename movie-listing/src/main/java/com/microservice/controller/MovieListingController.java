package com.microservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie-listing")
public class MovieListingController {

    @GetMapping("/user")
    public String getUser() {
        return "Hello User";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "Hello Admin";
    }

}
