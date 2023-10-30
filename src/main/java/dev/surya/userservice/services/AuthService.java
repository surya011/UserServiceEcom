package dev.surya.userservice.services;

import dev.surya.userservice.dtos.LoginRequestDto;
import dev.surya.userservice.dtos.UserDto;
import dev.surya.userservice.models.User;
import dev.surya.userservice.repositories.SessionRepository;
import dev.surya.userservice.repositories.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.Random;

@Service
public class AuthService implements AuthService {
    private UserRepository userRepository;
    private SessionRepository sessionRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthService(UserRepository userRepository,
                       SessionRepository sessionRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder)
    {
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public ResponseEntity<UserDto> login(String email, String password) {
        Optional<User>  userOptional = userRepository.findByEmail(email);

        if(userOptional.isEmpty()) {
            return null;
        }
        User user = userOptional.get();
        if(!bCryptPasswordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Wrong username password");
        }

        String token = RandomStringUtils.randomAlphanumeric(30);


    }


}
