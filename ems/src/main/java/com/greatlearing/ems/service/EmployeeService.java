package com.greatlearing.ems.service;

import java.util.List;

import com.greatlearing.ems.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public void save(Employee employee);
	
	public Employee findById(Integer employeeId);
	
	public void deleteById(Integer employeeId);
	

}
