package com.example.kitob.component;

import com.example.kitob.entity.User;
import com.example.kitob.entity.enums.RoleEnum;
import com.example.kitob.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

    final PasswordEncoder passwordEncoder;

    @Value("${spring.sql.init.mode}")
    private String mode;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddl;

    final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User user = new User();
        user.setUsername("user");
        user.setPassword(passwordEncoder.encode("user"));
        user.setRoleEnum(RoleEnum.USER);
        userRepository.save(user);

        User admin = new User();
        admin.setRoleEnum(RoleEnum.ADMIN);
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin"));
        userRepository.save(admin);
    }
}
