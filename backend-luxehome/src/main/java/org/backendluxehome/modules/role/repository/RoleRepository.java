package org.backendluxehome.modules.role.repository;

import org.backendluxehome.modules.role.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {


    Optional<Role> findByRoleName(String roleName);
}
