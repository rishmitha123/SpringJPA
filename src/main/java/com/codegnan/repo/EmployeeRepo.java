package com.codegnan.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codegnan.entity.Employee;
@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Integer> {

}
