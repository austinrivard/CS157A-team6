package edu.sjsu.team6.flightfinder.repositories;

import edu.sjsu.team6.flightfinder.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}