package com.cinemax.cinemax.controller;

import com.cinemax.cinemax.model.User;
import com.cinemax.cinemax.repository.UserRepository;
import com.cinemax.cinemax.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")

public class UserController {

    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private UserRepository userRepository;

@PostMapping("/register")

public String registerUser(@RequestBody User user){

    User existingUser =
            userRepository.findByEmail(
                    user.getEmail()
            );

    if(existingUser != null){

        return "Email Already Exists";
    }

    userRepository.save(user);

    return "User Registered Successfully";
}

    @PostMapping("/login")
public String loginUser(@RequestBody User user){

    User existingUser =
            userRepository.findByEmailAndPassword(
                    user.getEmail(),
                    user.getPassword()
            );

    if(existingUser != null){

        String token =
                jwtUtil.generateToken(existingUser.getEmail());

        return token;
    }

    else{

        return "Invalid Email or Password";
    }
}
}