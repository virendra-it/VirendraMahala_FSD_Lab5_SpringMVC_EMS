package com.greatlearing.ems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearing.ems.entity.Employee;
import com.greatlearing.ems.repository.EmployeeRepository;
import com.greatlearing.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	// View List
	@Override
	public List<Employee> findAll() {
		
				List<Employee> employees=employeeRepository.findAll();
		return employees;
	}
	
	//Save or Add operation
	@Override
	public void save(Employee employee) {

		employeeRepository.save(employee);
		
	}

	@Override
	public Employee findById(Integer employeeId) {
		
		return employeeRepository.findById(employeeId).get();
	}

	@Override
	public void deleteById(Integer employeeId) {
		employeeRepository.deleteById(employeeId);
	}
	
	
	
	

}
