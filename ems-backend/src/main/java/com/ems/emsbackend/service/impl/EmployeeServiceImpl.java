package com.ems.emsbackend.service.impl;

import com.ems.emsbackend.Exception.ResourceNotFoundException;
import com.ems.emsbackend.dto.EmployeeDto;
import com.ems.emsbackend.entity.Employee;
import com.ems.emsbackend.mapper.EmployeeMapper;
import com.ems.emsbackend.repository.EmployeeRepository;
import com.ems.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee=employeeRepository.save(employee);
        return EmployeeMapper.maptoEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee=employeeRepository.findById(employeeId)
                .orElseThrow( () ->new ResourceNotFoundException("Employee not found"+employeeId));
        return EmployeeMapper.maptoEmployeeDto(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees=employeeRepository.findAll();
        return employees;
    }

    @Override
    public Employee updateEmployee(Long employeeId, Employee updateEmployee) {
        Employee employee=employeeRepository.findById(employeeId)
                .orElseThrow( () ->new ResourceNotFoundException("Employee not found"+employeeId));
        employee.setFirstName(updateEmployee.getFirstName());
        employee.setLastName(updateEmployee.getLastName());
        employee.setEmailId(updateEmployee.getEmailId());

        Employee employee1=employeeRepository.save(employee);

        return employee1;
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee=employeeRepository.findById(employeeId)
                .orElseThrow( () ->new ResourceNotFoundException("Employee not found"+employeeId));
        employeeRepository.deleteById(employeeId);
    }
}
