package com.niit;

import static org.junit.Assert.assertEquals;

import javax.persistence.Column;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.NonNull;

import com.niit.dao.EmployeeDao;
import com.niit.model.Employee;

public class testEmployee {
	private static AnnotationConfigApplicationContext context;
	private static EmployeeDao employeeDao;
	private static Employee emp;
//	@Autowired
//Employee emp;
	@BeforeClass
	public static void init() {
		System.out.println("in Application context");
		context = new AnnotationConfigApplicationContext();
		emp=new Employee();
		context.scan("com.niit");
		context.refresh();
		employeeDao = (EmployeeDao) context.getBean("employeeDAO");
		System.out.println(employeeDao);
	}
	
	

	/*@Test
	public void testAddemployee() {
		Employee emp = new Employee();
		emp.setFirstName("Nidhi");
		emp.setActive(false);
		emp.setPassword("111");
		emp.setLastName("sinha");
     emp.setEmailId("n@gmail.com");
	 emp.setContactNo("56789");
		 emp.setGender("Female");
    	 emp.setRole("Employeer");
    	 
    	emp.setCertification("ocjp"); 
	 emp.setSkill("java,advance java");
	 emp.setNoOfStudentPlaced(20);
	 emp.setNoOfStudentTaught(40);
		 emp.setProLocation("noida");
	 emp.setExperience(0);
	
		System.out.println("inside testAdd");
		emp.setCertification("java,oracel");
		assertEquals(true, employeeDao.addEmployee(emp));
	}*/
	//not working
	
	@Test
	public void update()
	{Employee emp=new Employee();
		
		emp.setEmpId(1);
		emp.setActive(true);
		assertEquals(true,employeeDao.updateEmployee(emp));
		
	}
	@Test
	public void authenticateUser()
	{Employee emp=new Employee();
	emp.setFirstName("saumya");
	emp.setPassword("123");
	System.out.println("Employee :"+emp);
//	assertEquals(true,employeeDao.employeeAuthentication(emp));
	System.out.println(emp.getFirstName());
       		
	}
	@Test
	public void skillupdate()
	{
		emp=new Employee();
		emp.setCertification("java, javascript,python,node");
		emp.setEmpId(1);
		assertEquals(1,employeeDao.updateEmpSkills(emp));
		
		
	}
	@Test
   public void rating()
   {
	  emp.setEmpId(1); 
	   assertEquals(1,employeeDao.rating(emp));
   }
	@Test
	public void profile()
	{
		emp.setEmpId(2);
		assertEquals(3,employeeDao.profile(emp));
		
		
	}
	@Test
	public void certifi(Employee emp)
	{
		emp.setEmpId(1);
		assertEquals(true,employeeDao.viewCertificate(emp));
	}
}
