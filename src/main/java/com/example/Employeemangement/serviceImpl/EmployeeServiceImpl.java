package com.example.Employeemangement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Employeemangement.dao.EmployeeDao;
import com.example.Employeemangement.model.Employee;
import com.example.Employeemangement.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeedao;

	@Override
	public Employee saveEmployee(Employee employee) {

		Employee employee2 = employeedao.save(employee);

		return employee2;
	}

	@Override
	public List<Employee> getAllEmployee() {

		List<Employee> list = employeedao.findAll();

		return list;
	}

	@Override
	public Employee getByEmployeeId(int id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		Employee employee = employeedao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("the id is " + id + "not present"));
		return employee;
	}

	@Override
	public Employee UpdateEmployee(Employee employee, int id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		Employee employee2 = employeedao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("the id is " + id + "not present"));

		employee2.setName(employee.getName());
		employee2.setEmail(employee.getEmail());
		employee2.setAdress(employee.getAdress());

		Employee employee3 = employeedao.save(employee2);

		return employee3;
	}

	@Override
	public void delteEmployee(int id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub

		Employee employee2 = employeedao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("the id is " + id + "not present"));

		employeedao.delete(employee2);

	}

}
