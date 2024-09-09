package com.example.RestfulAPI.controller;


import com.example.RestfulAPI.entity.Employee;
import com.example.RestfulAPI.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping ("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployee() {

        return employeeService.getAllEmployee();
    }
    @GetMapping("/by-salary")
    public List<Employee> getBySalary(@RequestParam double salary){
        return employeeService.getBySalary(salary);
    }
    @GetMapping("/by-firstName")
    public List<Employee> getByFirstName(@RequestParam String firstName){
        return employeeService.getByFirstName(firstName);
    }
    @GetMapping("/by-firstNameContaining")
    public List<Employee> getByFirstNameContaining(@RequestParam String firstNamePart){
        System.out.println("firstNamePart : "+ firstNamePart);

        return employeeService.getByFirstNameContaining(firstNamePart);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable  Integer id) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        try {
            Employee savedEmployee = employeeService.saveEmployee(employee);
            return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
        }catch (Exception e) {
            // Log the exception
            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        if (!employeeService.getEmployeeById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        employee.setId(id);
        Employee updatedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        if (!employeeService.getEmployeeById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
