package org.backendluxehome.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.backendluxehome.dto.AuthentificationRequest;
import org.backendluxehome.dto.AuthentificationResponse;
import org.backendluxehome.dto.RegistrationRequest;
import org.backendluxehome.service.AuthentificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
@Tag(name = "Authentication")
public class AuthentificationController {

    private final AuthentificationService service;


    @PostMapping(value = "/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> register(
            @RequestBody @Valid RegistrationRequest request
    ) throws MessagingException {
        System.out.println("CONTROLLER HIT ✔");
        service.register(request);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/login")
    public ResponseEntity<AuthentificationResponse> login(
            @RequestBody @Valid AuthentificationRequest request){
        return ResponseEntity.ok(service.login(request));
    }
}