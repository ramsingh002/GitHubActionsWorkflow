package com.github.actions.controller;

import com.github.actions.model.Employee;
import com.github.actions.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee>  createEmployee(
            @RequestBody Employee employee
    ) {
        return ResponseEntity.ok(employeeService.createEmployee(employee));
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        System.out.println("Employee fetching from database:: ");
        return employeeService.getAllEmployees();
    }

    @GetMapping("{employeeId}")
    public Employee findEmployeeById(
            @PathVariable(value = "employeeId") Long employeeId
    ) {
        System.out.println("Employee fetching from database:: "+employeeId);
        return employeeService.getEmployeeById(employeeId);
    }

    @PutMapping("{employeeId}")
    public Employee updateEmployee(
            @PathVariable(value = "employeeId") Long employeeId,
            @RequestBody Employee employee
    ) {
        return employeeService.updateEmployee(employeeId,employee);
    }

    @DeleteMapping("{id}")
    public void deleteEmployee(
            @PathVariable(value = "id") Long employeeId
    ) {
        employeeService.deleteEmployee(employeeId);
    }
}
