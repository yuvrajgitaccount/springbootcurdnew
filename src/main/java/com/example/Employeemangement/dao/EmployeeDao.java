package com.example.Employeemangement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Employeemangement.model.Employee;

public interface EmployeeDao extends JpaRepository<Employee,Integer> {

}
