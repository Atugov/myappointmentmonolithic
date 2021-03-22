package com.services.myappointmentmonolithtic.repository;

import com.services.myappointmentmonolithtic.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JPAEmployeeRepository extends JpaRepository<Employee, String> {
    List<Employee> findEmployeesByName(String name);
}
