package com.niit.dao;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.niit.model.Employee;

@Repository(value = "employeeDAO")
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {
	String active = "1";
	static int count = 0;

	@Autowired
	 SessionFactory sessionFactory;
	Session session = null;

	public EmployeeDaoImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.sessionFactory=sessionFactory;
	}
	@Override
	public List<Employee> findAll() {
	return sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

	@Override
	public Employee findById(int empId) {

		return (Employee) sessionFactory.getCurrentSession().createQuery("from Employee where empId=" + empId)
				.uniqueResult();
	}

	@Override
	public boolean addEmployee(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);
		return true;
	}

	// validating employee
	@Override
	public boolean updateEmployee(Employee employee) {
        boolean acti=false;
        try{
		
		String strQueary = "update Employee set active= :acti where empId=:empId";
		 acti = true;
		int empId = employee.getEmpId();
		Query queary = sessionFactory.getCurrentSession().createQuery(strQueary).setParameter("acti", acti).setParameter("empId", empId);
		 queary.executeUpdate();
		return true;
        
        }catch(Exception e){
        	e.printStackTrace();
        return false;
        }
		
	}

	// invalidating the employee
	@Override
	public boolean deleteEmployee(int empId) {
	
	try{	
	 
		String strQueary = "delete from  Employee  where empId=:empId";
	
		boolean acti = false;
		
		Query queary = sessionFactory.getCurrentSession().createQuery(strQueary);
		
		queary.setParameter("empId", empId);
		queary.executeUpdate();
	
	}catch(Exception e)
	{
		e.printStackTrace();
	}
		return true;
	}

	public Employee findByName(String name) {
		
		return (Employee) sessionFactory.getCurrentSession().createQuery("from Employee where firstName='" + name + "'")
				.uniqueResult();
		
	}

	public List<Employee> getApprovedEmp() {
		return sessionFactory.getCurrentSession().createQuery("from Employee where name='" + active + "'").list();

	}


	@Override
	public boolean rating(Employee employee) {
		boolean flag=false;
		try{int p;
		int empid = employee.getEmpId();
		
		Employee emp = sessionFactory.getCurrentSession().get(Employee.class, empid);
		int nop, nota;
		int rating1 = 0;
	       flag=false;
		nop = emp.getNoOfStudentPlaced();
		nota = emp.getNoOfStudentTaught();
		rating1 = (nop * 100) / nota;
		Query quary = sessionFactory.getCurrentSession().createQuery("update Employee set rating= :rating1 where empId=:empId");
		quary.setParameter("rating1", rating1);
		quary.setParameter("empId", empid);
		quary.executeUpdate();
		
		
	p=	quary.getMaxResults();
	
		if(p>1)
		{
			 flag=true;
		}
		else
		{
			flag=false;
		
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public int profile(Employee employee) {
		// TODO Auto-generated method stub

		String[] str = new String[6];
		int empid = employee.getEmpId();
		Employee emp = sessionFactory.getCurrentSession().get(Employee.class, empid);
		str[0] = emp.getCertification();
		str[1] = emp.getContactNo();
		int ex = emp.getExperience();
		str[2] = emp.getGender();
		str[3] = emp.getImage();
		str[4] = emp.getLastName();
		str[5] = emp.getSkill();
		for (int i = 0; i < 6; i++) {
			if (isNullOrEmpty(str[i])) {
				count++;
			}
		}
		if (isEmptyNumber(ex)) {
			count++;
		}

		return count;
	}

	public static boolean isNullOrEmpty(String str) {
		if (str != null && !str.isEmpty())
			return false;
		return true;
	}

	public static boolean isEmptyNumber(int number) {

		if (number == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean viewCertificate(Employee employee) {
		// TODO Auto-generated method stub
		try{
		String strQueary = "From Employee  where empId=:empId";
	
		int empId = employee.getEmpId();
		Employee em_p= sessionFactory.getCurrentSession().get(Employee.class, empId);
		      
		List<String> lst=new ArrayList<>();
		Employee emp=(Employee)em_p;
		String str=emp.getCertification();
		String[] cer=str.split(",");
		int len=cer.length;
		for(int i1=0;i1<len;i1++)
		{System.out.println("array"+cer[i1]);
		}
		for(int i=0;i<len;i++)
		{System.out.println(cer[i]);
			lst.add(cer[i]);
			System.out.println(lst);
		}
			
	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return true;

		
	}
	
	@Override
	public Employee employeeAuthentication(String email,String pass) {
		String query= "From Employee  where firstName=:email and password=:pass";
		
			return (Employee)sessionFactory.getCurrentSession()
					.createQuery(query).setParameter("email", email).setParameter("pass", pass)
					.uniqueResult();
		}



	@Override
	public int updateEmpSkills(Employee employee) {
	 int c=0;
		try{	
		
		int empId = employee.getEmpId();
		String ski = employee.getSkill();
	
		Query queary = sessionFactory.getCurrentSession().createQuery("update Employee set skill=:ski where empId=:empId");
		queary.setParameter("ski", ski);
		queary.setParameter("empId", empId);
		queary.executeUpdate();
		c=1;
		 }catch(Exception e){
	   e.printStackTrace();
	  }
	 return c;
	}

	@Override
	public boolean updatePersonal(Employee employee) {
      
        try{
		String strQueary = "update Employee set firstName= :firstName,lastName=:lastName,emailId=:emailId,contactNo=:contactNo,gender=:gender,password=:password,certification=:certification,skill=:skill,proLocation=:proLocation,experience=:experience,noOfStudentPlaced=:noOfStudentPlaced,noOfStudentTaught=:noOfStudentTaught where empId=:empId";
		int empId = employee.getEmpId();
		Query queary = sessionFactory.getCurrentSession().createQuery(strQueary).setParameter("firstName",employee.getFirstName()).setParameter("lastName", employee.getLastName()).setParameter("emailId", employee.getEmailId()).setParameter("contactNo",employee.getContactNo()).setParameter("gender",employee.getGender()).setParameter("password",employee.getPassword()).setParameter("certification",employee.getCertification()).setParameter("skill",employee.getSkill()).setParameter("proLocation",employee.getProLocation()).setParameter("experience", employee.getExperience()).setParameter("noOfStudentPlaced",employee.getNoOfStudentPlaced()).setParameter("noOfStudentTaught", employee.getNoOfStudentTaught()).setParameter("empId", empId);
		 queary.executeUpdate();
		return true;
         }catch(Exception e){
        	e.printStackTrace();
        return false;
        }
	}
}
