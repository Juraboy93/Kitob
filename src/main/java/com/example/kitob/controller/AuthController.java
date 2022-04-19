package com.example.kitob.controller;

import com.example.kitob.dto.LoginDTO;
import com.example.kitob.security.JwtProvider;
import com.example.kitob.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

   final  AuthenticationManager authenticationManager;

   final AuthService authService;

    final JwtProvider jwtProvider;

    @PostMapping("/login")
    public HttpEntity<?> login(@RequestBody LoginDTO loginDTO){
        String token=jwtProvider.generateToken(loginDTO.getUserName());
        return ResponseEntity.ok().body(token);
    }


}
