package com.niftyengineer.niftymeals.controller;

import com.niftyengineer.niftymeals.config.UserAuthnProvider;
import com.niftyengineer.niftymeals.dto.CredentialsDto;
import com.niftyengineer.niftymeals.dto.SignUpDto;
import com.niftyengineer.niftymeals.dto.UserDto;
import com.niftyengineer.niftymeals.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class AuthnController {

    private final UserService userService;
    private final UserAuthnProvider userAuthnProvider;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody @Valid CredentialsDto credentialsDto) {
        UserDto userDto = userService.login(credentialsDto);
        // returns a fresh jwt
        userDto.setToken(userAuthnProvider.createToken(userDto.getUserEmail()));
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody @Valid SignUpDto user) {
        UserDto newUser = userService.register(user);
        // returns a fresh jwt
        newUser.setToken(userAuthnProvider.createToken(user.getUserEmail()));
        // returns 201 with a url link to the new entity
        return ResponseEntity.created(URI.create("/users/" + newUser.getId())).body(newUser);
    }

}
