package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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

import com.niit.dao.EmployeeDao;
import com.niit.model.Employee;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private Employee emp;
	@Autowired
     HttpSession session;
	@GetMapping("/employee/hr")
	public ResponseEntity<?> sayHello() {
		List<Employee> employee = employeeDao.findAll();

		return new ResponseEntity<List<Employee>>(employee, HttpStatus.OK);

	}

	@PostMapping("/employee/add")
	public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {
		
		if((employee.getFirstName()!=null)&&(employee.getLastName()!=null)&&(employee.getCertification()!=null)&&(employee.getContactNo()!=null)&&(employee.getDate_of_joining()!=null)&&(employee.getEmailId()!=null)&&(employee.getExperience()!=0)&&(employee.getGender()!=null)&&(employee.getNoOfStudentPlaced()!=0)&&(employee.getNoOfStudentTaught()!=0)&&(employee.getPassword()!=null)&&(employee.getProLocation()!=null)&&(employee.getSkill()!=null)&&(employee.getRole()!=null))
		{	
		
		return new ResponseEntity(employeeDao.addEmployee(employee), HttpStatus.OK);
		}
		else
		{
			Employee emp=new Employee();
			emp.setMessage("data not entered");
			return new ResponseEntity(emp, HttpStatus.NOT_FOUND);	
		}
		
	}

	@PutMapping("/employee/hr")
	public ResponseEntity<Void> updateEmployee(@RequestBody Employee employee) {

		employee.setEmpId(employee.getEmpId());
		employeeDao.updateEmployee(employee);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<Employee> login(@RequestBody Employee emp) {
		
		String pass=emp.getPassword();
		String str1=emp.getFirstName();
		emp = employeeDao.employeeAuthentication(str1,pass);

		if (emp==null) {
            emp=new Employee();
			emp.setErrorCode("404");

			emp.setMessage("Please enter valid Credentials");
		
			return new ResponseEntity<Employee>(emp,HttpStatus.NOT_FOUND);
		} else {
			String str=emp.getFirstName();
             System.out.println(str);
             System.out.println(emp.getGender());
             emp.setErrorCode("200");
		
			session.setAttribute("user", str);
			session.setMaxInactiveInterval(10000000);
			System.out.println("inside log in session===="+session.getAttribute("user"));
			return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		}
		
	}

		@DeleteMapping("/employee/hr/delete/{empId}")
	public ResponseEntity<Employee> deleteEmp(@PathVariable("empId") int empId) {
    
		boolean flag = employeeDao.deleteEmployee(empId);

		if (flag) {

			emp.setErrorCode("200");

			emp.setMessage("  Valid Credentials");
			System.out.println("in if rest controller" + emp.getErrorCode() + emp.getMessage()+emp.getEmpId());
			return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		} else {
			emp.setMessage("404");

			System.out.println("not run");
			emp.setMessage(" Enter Valid Credentials");
			return new ResponseEntity<Employee>(emp, HttpStatus.NOT_FOUND);
			
		}
		
	}

	@PostMapping("/employee/rating")
	public ResponseEntity<Employee> employeeRating(@RequestBody Employee emp) {
		boolean flag = employeeDao.rating(emp);

		if (flag) {
            emp.setErrorCode("200");
            emp.setMessage(" Enter Valid Credentials");
			System.out.println("in if rest controller" + emp.getErrorCode() + emp.getMessage());
		} else {
           	System.out.println("not run");
			emp.setMessage(" Enter Valid Credentials");
		}
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

	@GetMapping("/employee/hr/employeer")
	public ResponseEntity<?> listApprovedEmployee() {
		List<Employee> employee = employeeDao.getApprovedEmp();
       	return new ResponseEntity<List<Employee>>(employee, HttpStatus.OK);

	}
	@PutMapping("/employee/hr/getEmployee/{name}")
	public ResponseEntity<Employee> getEmpByName(@PathVariable("name") String name) {
		System.out.println("in employee"+name);
		emp = employeeDao.findByName(name);

		if (emp!=null) {

			emp.setErrorCode("200");
            emp.setMessage("  Valid Credentials");
			System.out.println("in update----->if rest controller" + emp.getErrorCode() + emp.getFirstName());
			return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		} else {
           	System.out.println("not run");
			emp.setMessage(" Enter Valid Credentials");
			return new ResponseEntity<Employee>(emp, HttpStatus.NOT_FOUND);
		}
		
}
	@PostMapping("/employee/update")
	public ResponseEntity<?> updatePersonEmployee(@RequestBody Employee employee) {
		boolean t=employeeDao.updatePersonal(employee);
		if(t)
		{
			Employee emp=new Employee();
			emp.setMessage("sucessfully updated");
			return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		}
		else
		{
			Employee emp=new Employee();
			emp.setMessage("not updated");
			return new ResponseEntity<Employee>(emp, HttpStatus.NOT_FOUND);
			
		}
				
	}
	@PutMapping("/employee/invalidate/{name}")
	public ResponseEntity<Employee> invalidateEmployee(@PathVariable("name") String name1) {
	String str=(String) session.getAttribute("user");
	if((name1)!=null )
		{
			System.out.println("in invalidate"+str);
			   session.invalidate();
			 
					Employee emp=new Employee();
					emp.setMessage("not updated");
					return new ResponseEntity<Employee>(emp, HttpStatus.OK);
			
		}
		else
		{Employee emp=new Employee();
		emp.setMessage("new user");
		return new ResponseEntity<Employee>(emp, HttpStatus.NOT_FOUND);
	
	
			
		}
		

		
	}

}