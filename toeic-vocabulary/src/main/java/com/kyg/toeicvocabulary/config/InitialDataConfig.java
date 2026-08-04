package com.kyg.toeicvocabulary.config;

import com.kyg.toeicvocabulary.domain.User;
import com.kyg.toeicvocabulary.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitialDataConfig implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (userRepository.findByUsername("kyg").isEmpty()) {
            User user = User.builder()
                    .username("kyg")
                    .password(passwordEncoder.encode("test1234"))
                    .build();
            userRepository.save(user);
        }
    }
}
