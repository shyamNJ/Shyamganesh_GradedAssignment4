package com.gl.controller;

import java.util.List;


import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.dbmodel.Employee;







@Controller
public class EmployeeController {
	
	@GetMapping("/")
	public String welcome() {
		return "welcome";
		
	}
	
	   //-----------------------------insert-----------------------//
		@RequestMapping("/insert")
		public String insert() {
			return "insert-Employee";
		}

		@PostMapping("/insert-param")
		public String insertParam(@RequestParam String Employee_Name, @RequestParam String Employee_Address, @RequestParam String Employee_Phone, @RequestParam String Employee_Salary) {

			SessionFactory factory = new Configuration ().configure().buildSessionFactory();

			Session session =factory.openSession();

			try {
				Transaction tx = session.beginTransaction();

				Employee s1=new Employee(Employee_Name, Employee_Address, Employee_Phone, Employee_Salary);
				session.save(s1);
				tx.commit();

			}
			catch(Exception ex) {
				System.out.println("hibernate error: "+ex.getMessage());
			}

			return "welcome";

		}
		
		//----------------------------------Display----------------------------------//
		@RequestMapping("show")
		public String showStudent(Model data) {
			
			SessionFactory factory = new Configuration ().configure().buildSessionFactory();

			Session session =factory.openSession();
			
			try {
				Query q1=session.createQuery("from Employee");
				List<Employee> employ = q1.getResultList();
				data.addAttribute("emp", employ);
			}
			catch(Exception ex) {
				System.out.println("hibernate error: "+ex.getMessage());
			}
			return "show-Employee";
				
		}
		
		//---------------------update-------------------------------//

		@GetMapping("/update-employee")
		public String updateStudentForm(@RequestParam int Employee_Id, Model data) {
			
			SessionFactory factory = new Configuration ().configure().buildSessionFactory();

			Session session =factory.openSession();
			try {
				//
				Employee updateemploy = session.get(Employee.class, Employee_Id);
				data.addAttribute("empo",updateemploy);
			}
			catch(Exception ex) {
				System.out.println("hibernate error: "+ex.getMessage());
			}
			return "update-Employee";
			
		}
		
		@PostMapping("/update")
		public String  update(@RequestParam int Employee_Id,@RequestParam String Employee_Name, @RequestParam String Employee_Address, @RequestParam String Employee_Phone, @RequestParam String Employee_Salary  ) {

			SessionFactory factory = new Configuration ().configure().buildSessionFactory();

			Session session =factory.openSession();

			try {

				Transaction tx = session.beginTransaction();

			
				Employee e1=new Employee(Employee_Id, Employee_Name, Employee_Address, Employee_Phone, Employee_Salary);
				session.update(e1);
				
			tx.commit();



			}
			catch(Exception ex) {
				System.out.println("hibernate error: "+ex.getMessage());
			}

			return "welcome";

		}

		//--------------------------------------Delete--------------------------------------------//
		
		@GetMapping("/delete-employee")
		public String deleteemp(@RequestParam int Employee_Id, Model data) {
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();
			
			try {
				Transaction tx=session.beginTransaction();
				Employee deleteemp = new Employee(Employee_Id);
				session.delete(deleteemp);
				tx.commit();
				
				
			}
			catch(Exception ex) {
				System.out.println("hibernate error: "+ex.getMessage());
			}
			return "welcome";
		}

}
