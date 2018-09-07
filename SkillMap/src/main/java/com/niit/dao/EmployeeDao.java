package com.niit.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


import com.niit.model.Employee;

public interface EmployeeDao {

	public List<Employee> findAll();
	public Employee findById(int empId);
	public Employee findByName(String name);
	public boolean addEmployee(Employee employee);
	public boolean updateEmployee(Employee employee);
	public int updateEmpSkills(Employee employee);
	public boolean deleteEmployee(int empId);
	public List<Employee>getApprovedEmp();
	public Employee employeeAuthentication(String email,String pass);
    public boolean rating(Employee employee);
	public int profile(Employee employee);
	public boolean viewCertificate(Employee employee);
	public boolean updatePersonal(Employee employee);
    
}
