package com.example.Employeemangement.service;

import java.util.List;

import com.example.Employeemangement.model.Employee;
import com.example.Employeemangement.serviceImpl.ResourceNotFoundException;

public interface EmployeeService {
	
	
	public Employee saveEmployee(Employee employee);
	
	public  List<Employee>getAllEmployee();
	
	public Employee getByEmployeeId(int id) throws ResourceNotFoundException;
	
	public Employee UpdateEmployee(Employee employee,int id) throws ResourceNotFoundException;
	
	public void delteEmployee(int id) throws ResourceNotFoundException;

}
