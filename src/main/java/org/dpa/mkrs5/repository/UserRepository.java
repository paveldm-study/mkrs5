package org.dpa.mkrs5.repository;

import org.dpa.mkrs5.repository.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
