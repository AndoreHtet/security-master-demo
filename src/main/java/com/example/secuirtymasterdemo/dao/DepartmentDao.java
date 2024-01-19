package com.example.secuirtymasterdemo.dao;

import com.example.secuirtymasterdemo.entity.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentDao extends CrudRepository<Department,Integer> {
}
