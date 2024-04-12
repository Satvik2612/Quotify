package com.booquo.Quotify.auth.service;


import com.booquo.Quotify.auth.entity.UserEntity;
import com.booquo.Quotify.auth.model.UserView;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;


    public String register(UserView request) {

        userService.findByUsername(request.getUsername()).ifPresent(userEntity -> {throw new RuntimeException("username already present");});

        UserEntity user = new UserEntity();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));


        user.setRole(request.getRole());

        userService.save(user);

        return jwtService.generateToken(user);

    }

    public String authenticate(UserView request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        UserEntity user = userService.findByUsername(request.getUsername()).orElseThrow();
        return jwtService.generateToken(user);

    }
}
