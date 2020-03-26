package com.raya.aman.TrainAgent.repos;


import com.raya.aman.TrainAgent.model.ERole;
import com.raya.aman.TrainAgent.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}