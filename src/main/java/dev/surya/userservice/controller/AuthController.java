package dev.surya.userservice.controller;

import dev.surya.userservice.dtos.LoginRequestDto;
import dev.surya.userservice.dtos.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public UserDto createUser(@RequestBody UserDto userDto){
        return authService.createUser(userDto);

    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody LoginRequestDto request) {
        return authService.login(request.getEmail(), request.getPassword());
    }

    @PostMapping("/logout")
    public ResponseEntity<UserDto> logout(@RequestBody LogoutRequestDto request)
    {
       return authService.logout(request.getToken(), request.getUserId());
    }


}
