package com.example.RestfulAPI.respository;

import com.example.RestfulAPI.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

   /* List<Employee> findByFirstName(String firstName);*/
    /*@Query("SELECT e  FROM employee e WHERE e.first_name LIKE %:firstName%")
    List<Employee> findByFirstNameContaining(@Param("firstName")String firstName) ;*/
    /*@Query("SELECT e  FROM employee e WHERE e.salary = :salary")  */
    List<Employee> findBySalary(double salary);
    List<Employee> findByFirstName(String firstName);
//    @Query("SELECT e FROM employee e WHERE e.firstName = ?1")
    List<Employee> findByFirstNameContaining(String firstName);

//    @Query("Select e from Employee e where e.firstName like %:nameLike%")
//    List<Employee> customizedFind(String nameLike);

}
