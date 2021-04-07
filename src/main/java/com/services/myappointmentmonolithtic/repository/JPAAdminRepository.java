package com.services.myappointmentmonolithtic.repository;

import com.services.myappointmentmonolithtic.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JPAAdminRepository extends JpaRepository<Admin, String> {
}
