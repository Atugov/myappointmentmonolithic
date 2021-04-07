package com.services.myappointmentmonolithtic.repository;

import com.services.myappointmentmonolithtic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAUserRepository extends JpaRepository<User, String> {
}
