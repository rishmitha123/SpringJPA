package com.codegnan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codegnan.entity.Employee;
import com.codegnan.exception.InvalidEmployeeIdException;
import com.codegnan.repo.EmployeeRepo;
@Service
public class EmployeeService {
	EmployeeRepo employeeRepo;

	@Autowired
	public void setEmployeeRepo(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;

	}

	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);

	}

	public Employee findEmployeeById(int id) throws InvalidEmployeeIdException {
		Optional<Employee> optEmp = employeeRepo.findById(id);
		if (!optEmp.isPresent()) {
			throw new InvalidEmployeeIdException("employee not found by id :" + id);
		}
		return optEmp.get();

	}

	public List<Employee> findAllEmployee() {
		return (List<Employee>) employeeRepo.findAll();
	}

	public Employee editEmployee(Employee employee) throws InvalidEmployeeIdException {
		findEmployeeById(employee.getId());
		return employeeRepo.save(employee);
	}
	public Employee deleteEmployee(int id) throws InvalidEmployeeIdException {
		Employee employee = findEmployeeById(id);
		employeeRepo.deleteById(id);
		return employee;
	}
		
	

}
