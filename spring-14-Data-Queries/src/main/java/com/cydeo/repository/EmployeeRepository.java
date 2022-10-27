package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //Display all employees with email address
    List<Employee> findByEmail(String email);

    //Display all employees with  firstname"" and lastname""
    // also show all employees with an email address
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstname, String lastname, String email);

    //Display all employees that first name is not ""
    List<Employee> findByFirstNameIsNot(String firstname);

    //Display all employees  where lastname
    List<Employee> findByLastNameStartingWith(String pattern);

   //Display all employees with salaries start greater than""
    List<Employee> findBySalaryGreaterThan(Integer salary);

    //Display all employees with salaries start less than""
    List<Employee> findBySalaryLessThan(Integer salary);


    //Display all employees that hired between ""and ""
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    //Display all employees where salaries greaten and equal to "" in order salary
    List<Employee>  findBySalaryGreaterThanEqualOrderBySalary(Integer salary);

    //Display top 3 employees that makes less than ""
    List<Employee> findDistinctTopBySalaryLessThan(Integer salary);

   // Display employees who don't have email
    List<Employee> findByEmailIsNull();

    @Query("SELECT employee from Employee employee where employee.email= 'amcnee1@google.es'  ")
    Employee retrieveEmployeeDetail();

    @Query("SELECT e.salary from Employee e where e.email='amcnee1@google.es' ")
    Integer retrieveEmployeeSalary();


}
