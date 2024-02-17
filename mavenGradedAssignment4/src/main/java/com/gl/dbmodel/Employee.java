package com.gl.dbmodel;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Employee_Id;
	private String Employee_Name;
	private String Employee_Address;
	private String Employee_Phone;
	private String Employee_Salary;
	
	public Employee() {
		
	}

	public Employee(String employee_Name, String employee_Address, String employee_Phone, String employee_Salary) {
		super();
		Employee_Name = employee_Name;
		Employee_Address = employee_Address;
		Employee_Phone = employee_Phone;
		Employee_Salary = employee_Salary;
	}

	public Employee(int employee_Id, String employee_Name, String employee_Address, String employee_Phone,
			String employee_Salary) {
		super();
		Employee_Id = employee_Id;
		Employee_Name = employee_Name;
		Employee_Address = employee_Address;
		Employee_Phone = employee_Phone;
		Employee_Salary = employee_Salary;
	}
	
	

	public Employee(int employee_Id) {
		super();
		Employee_Id = employee_Id;
	}

	public int getEmployee_Id() {
		return Employee_Id;
	}

	public void setEmployee_Id(int employee_Id) {
		Employee_Id = employee_Id;
	}

	public String getEmployee_Name() {
		return Employee_Name;
	}

	public void setEmployee_Name(String employee_Name) {
		Employee_Name = employee_Name;
	}

	public String getEmployee_Address() {
		return Employee_Address;
	}

	public void setEmployee_Address(String employee_Address) {
		Employee_Address = employee_Address;
	}

	public String getEmployee_Phone() {
		return Employee_Phone;
	}

	public void setEmployee_Phone(String employee_Phone) {
		Employee_Phone = employee_Phone;
	}

	public String getEmployee_Salary() {
		return Employee_Salary;
	}

	public void setEmployee_Salary(String employee_Salary) {
		Employee_Salary = employee_Salary;
	}


	
	

}
