package com.greatlearing.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearing.ems.entity.Employee;
import com.greatlearing.ems.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/list")
	public String listEmployees(Model theModel ) {
		
		//Get employees details from DB
		List<Employee> employees=employeeService.findAll();
		
		//Add to the model
		theModel.addAttribute("employees", employees);
		
		return "employees/list-employees";
			
		
	}
	
	//Add employee will have two steps
	//1. show form to take user input
	//2. Save form data to database
	
	@RequestMapping("/showEmployeeForm_Save")
	public String saveEmployee_Step1(Model theModel) {
		
		//Create model attribute
		Employee employee= new Employee();
		theModel.addAttribute("employee", employee);
		
		return "employees/employee-form";
		
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		
		//save employee
		employeeService.save(employee);
		
		//redirect to listing page
		return "redirect:/employees/list";
	}
	
	@RequestMapping("/showEmployeeForm_Update")
	public String updateEmployee_Step1(@RequestParam("employeeId") Integer employeeId, Model theModel) {
		
		Employee employee =employeeService.findById(employeeId);
		theModel.addAttribute("employee", employee);
		
		return "employees/employee-form";
		
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("employeeId") Integer employeeId) {
		
		employeeService.deleteById(employeeId);
		
		return "redirect:/employees/list";
	}
	
		

}
