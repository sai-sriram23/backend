package com.example.cabsystemsms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "${FRONTEND_URL:*}")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/demo")
    public String demo() {
        return "Application is running!";
    }

    @GetMapping("/users")
    public List<Users> getAllUsers() {
        return this.userRepo.findAll();
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody Users user) {
        Users existing = this.userRepo.findByEmail(user.getEmail());
        if (existing != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
        }
        this.userRepo.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }
}
