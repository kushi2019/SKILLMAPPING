package com.niit.service;

/*import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.EmployeeDao;
import com.niit.model.Employee;




@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDAO;
	
	public List<Employee> findAllEmployees() {
		
		return employeeDAO.findAll();
	}

	public Employee findEmployeesById(int empId) {
		
		return employeeDAO.findById(empId);
	}

	public boolean addEmployee(Employee employee) {
		
		if(employeeDAO.findById(employee.getEmpId())!=null) {
			return false;
		}
		else {
			employeeDAO.addEmployee(employee);
			return true;
		}
	}

	public boolean updateEmployee(Employee employee) {
		if(employeeDAO.findById(employee.getEmpId())!=null) {	
			employeeDAO.updateEmployee(employee);
			return true;
		}
		else {
			return false;
		}
	}

	public boolean deleteEmployee(int empId) {
		if(employeeDAO.findById(empId)!=null) {	
			employeeDAO.deleteEmployee(empId);
			return true;
		}
		else {
			return false;
		}
	}

	public Employee findEmployeesByName(String name) {
		
		return employeeDAO.findByName(name);
	}

}
*/