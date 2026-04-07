package org.backendluxehome.service;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.backendluxehome.dto.RegistrationRequest;
import org.springframework.stereotype.Service;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class AuthentificationService {

    public void register(@Valid RegistrationRequest request) {

    }
}
