package com.gym.web.webappsv.repository;

import com.gym.web.webappsv.model.Role;
import com.gym.web.webappsv.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
