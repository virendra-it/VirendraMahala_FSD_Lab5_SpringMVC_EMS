package com.greatlearing.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearing.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
