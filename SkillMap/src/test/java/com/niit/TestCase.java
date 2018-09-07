package com.niit;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.EmployeeDao;
import com.niit.model.Employee;


public class TestCase {
	public static void main(String[] args) 
	{
		System.out.println("inside annotatio");
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		EmployeeDao employeedao=(EmployeeDao)context.getBean("employeeDAO");
		System.out.println("before employee");
		Employee emp=new Employee();
		System.out.println("after employee");	
		
		/*	emp.setActive("0");
			emp.setCertification("mca,bca,Pgpit");
			emp.setEmailId("h@gmail.com");
			emp.setDate_of_joining(new Date());
			emp.setFirstName("Saumya");
			System.out.println("after set employee");
			employeedao.addEmployee(emp);
			System.out.println("Blog Details Added");
		List<Employee> b=employeedao.findAll();
		for(Employee n:b){
			System.out.println(n.getFirstName());
			
		
		}
		/*
		List<Employee> en=employeedao.getApprovedEmp();
		for(Employee n:en){
			System.out.println(n.getFirstName());
		
	       }*/
	
	//	Employee emp=new Employee();
		/*emp.setFirstName("saumya");
		emp.setPassword("123");
		System.out.println("Employee :--------------------->"+emp);
		assertEquals(true,employeedao.employeeAuthentication(emp));
		System.out.println(emp.getFirstName());
		
		/*{
			emp.setEmpId(2);
			assertEquals(true,employeedao.viewCertificate(emp));
		}*/
		emp.setSkill("abc");
		emp.setEmpId(1);
		System.out.println("Employee :--------------------->"+emp);
		int x=employeedao.updateEmpSkills(emp);
		//assertEquals(1,employeedao.updateEmpSkills(emp));
		System.out.println("x = "+x);
		System.out.println(emp.getSkill());
		  		
		
	}
}
	




