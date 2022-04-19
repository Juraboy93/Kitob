package com.example.kitob.service;

import com.example.kitob.entity.User;
import com.example.kitob.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {
   final    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<User> byUsername=userRepository.findByUsername(name);
        return (UserDetails) userRepository.findByUsername(name)
                .orElseThrow(() -> new UsernameNotFoundException(name));
    }
}
