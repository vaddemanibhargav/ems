package com.ems.emsbackend.service;

import com.ems.emsbackend.dto.EmployeeDto;
import com.ems.emsbackend.entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);

    List<Employee> getAllEmployees();
    Employee updateEmployee(Long employeeId,Employee updateEmployee);
    void deleteEmployee(Long employeeId);
}
