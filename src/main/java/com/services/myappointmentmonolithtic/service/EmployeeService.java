package com.services.myappointmentmonolithtic.service;

import com.services.myappointmentmonolithtic.model.Employee;
import com.services.myappointmentmonolithtic.repository.JPAEmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final JPAEmployeeRepository employeeRepository;

    public EmployeeService(JPAEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
}
