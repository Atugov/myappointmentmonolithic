package com.services.myappointmentmonolithtic.repository;

import com.services.myappointmentmonolithtic.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JPAEmployeeRepository extends JpaRepository<Employee, String> {

}
