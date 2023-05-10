package com.example.Employeemangement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employeemangement.model.Employee;
import com.example.Employeemangement.service.EmployeeService;
import com.example.Employeemangement.serviceImpl.ResourceNotFoundException;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/saveEmployee")

	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		Employee employee2 = employeeService.saveEmployee(employee);

		return new ResponseEntity<>(employee2, HttpStatus.CREATED);
	}

	@GetMapping("/getAllemployee")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> employee = employeeService.getAllEmployee();

		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@GetMapping("/getId/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) throws ResourceNotFoundException {

		Employee employee = employeeService.getByEmployeeId(id);

		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@PutMapping("/updateEmployee/{id}")

	public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee)
			throws ResourceNotFoundException {
		Employee employee2 = employeeService.UpdateEmployee(employee, id);

		return new ResponseEntity<>(employee2, HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteId/{id}")
	public ResponseEntity<Map<String, Boolean>> delteById(@PathVariable int id) throws ResourceNotFoundException {

		Map<String, Boolean> map = new HashMap<>();
		employeeService.delteEmployee(id);
		map.put("delete data", Boolean.TRUE);

		return new ResponseEntity<>(map, HttpStatus.OK);
	}
}
