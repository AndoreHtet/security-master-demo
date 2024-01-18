package com.example.secuirtymasterdemo.dao;

import com.example.secuirtymasterdemo.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDao extends CrudRepository<Customer,Integer> {
}
