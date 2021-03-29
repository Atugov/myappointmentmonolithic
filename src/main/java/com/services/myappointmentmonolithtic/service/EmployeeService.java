package com.services.myappointmentmonolithtic.service;

import com.services.myappointmentmonolithtic.model.Admin;
import com.services.myappointmentmonolithtic.model.Employee;
import com.services.myappointmentmonolithtic.repository.JPAEmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final JPAEmployeeRepository employeeRepository;

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeService.class);

    public EmployeeService(JPAEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void saveEmployee(Employee employee) {
        LOG.debug("saveEmployee(), saving employee");
        employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee() {
        LOG.debug("getAllEmployee(), getting all employees");
        return employeeRepository.findAll();
    }
    public Employee findEmployeeById(String id){
        LOG.debug("findEmployeeById(), Receiving employee by id");
        return employeeRepository.findById(id).orElseThrow(NullPointerException::new);
    }
}
