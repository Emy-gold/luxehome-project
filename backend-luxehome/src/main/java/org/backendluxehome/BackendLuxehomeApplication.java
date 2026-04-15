package org.backendluxehome;

import org.backendluxehome.model.Role;
import org.backendluxehome.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class BackendLuxehomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendLuxehomeApplication.class, args);}

    @Bean
    public CommandLineRunner runner(RoleRepository roleRepository){
        return args -> {
            if(roleRepository.findByRoleName("ROLE_USER").isEmpty()) {
                roleRepository.save(
                        Role.builder().roleName("ROLE_USER").build()
                );
            }
        };
    }
}
