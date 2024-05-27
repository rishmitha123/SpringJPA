package com.codegnan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.codegnan.entity.Employee;
import com.codegnan.exception.InvalidEmployeeIdException;
import com.codegnan.repo.EmployeeRepo;
import com.codegnan.service.EmployeeService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args)
    {
   	
    	ApplicationContext ctxt=new ClassPathXmlApplicationContext("Spring.xml");
    	EmployeeService employeeService=ctxt.getBean(EmployeeService.class);
    	Employee employee=new Employee("nani","nani@gmail.com");
    	employeeService.saveEmployee(employee);
    	try {
			Employee e=employeeService.findEmployeeById(1);
		} catch (InvalidEmployeeIdException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
}
