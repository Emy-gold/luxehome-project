package org.backendluxehome.auth.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthentificationResponse {

    private String token;
}
