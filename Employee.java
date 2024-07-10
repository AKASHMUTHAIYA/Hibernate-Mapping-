package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
	@Table(name="employee")
	public class Employee {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="emp_id")
		private int id;
		@Column(name="emp_name")
		private String name;
		@Column(name="emp_salary")
		private float salary;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public float getSalary() {
			return salary;
		}
		public void setSalary(float salary) {
			this.salary = salary;
		}
		public Employee() {
			// TODO Auto-generated constructor stub
		}
		}
		
	    

