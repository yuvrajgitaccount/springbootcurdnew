package com.example.Employeemangement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "react_emp")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;

	private String name;

	private String email;

	private String adress;

}
