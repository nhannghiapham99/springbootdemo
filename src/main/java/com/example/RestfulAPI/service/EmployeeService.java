package com.example.RestfulAPI.service;



import com.example.RestfulAPI.entity.Employee;

import com.example.RestfulAPI.respository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
    public  List<Employee> getBySalary(double salary){
        return employeeRepository.findBySalary(salary);
    }
    public List<Employee> getByFirstName(String firstName){
        return employeeRepository.findByFirstName(firstName);
    }
    public List<Employee> getByFirstNameContaining(String firstNamePart){
        return employeeRepository.findByFirstNameContaining(firstNamePart);
    }
    /*public Map<String, Object> getAllEmployee(String firstName, double salary) {
        Map<String, Object> result = new HashMap<>();
      *//*  List<Employee> byFirstNameContaining = employeeRepository.findByFirstNameContaining(firstName);*//*
        List<Employee> bySalary = employeeRepository.findBySalary(salary);
        *//*List<Employee> byEmployees = employeeRepository.findAll();*//*

      *//*  result.put("byFirstNameContaining",byFirstNameContaining);*//*
        result.put("bySalary", bySalary);

        return result;
    }*/
    /*public List<Employee> getEmployeeByFirstName(String firstName) {
        return employeeRepository.findByFirstName(firstName);
    }*/
    public Optional<Employee> getEmployeeById(Integer id) {
        return employeeRepository.findById(id);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
}
