package com.example.secuirtymasterdemo.dao;

import com.example.secuirtymasterdemo.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee,Integer> {
}
