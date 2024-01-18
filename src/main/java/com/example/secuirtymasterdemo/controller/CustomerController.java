package com.example.secuirtymasterdemo.controller;

import com.example.secuirtymasterdemo.dao.CustomerDao;
import com.example.secuirtymasterdemo.entity.Customer;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerDao customerDao;
    @GetMapping("/customer/save-customer")
    public String createCustomer(@ModelAttribute Customer customer){
        return "customerForm";
    }
    @PostMapping("/customer/save-customer")
    public String processCustomer(@Valid Customer customer, BindingResult result){
        if (result.hasErrors()){
            return "customerForm";

        }
        customerDao.save(customer);
        return "redirect:/customer/list-customers";
    }
    @GetMapping("/customer/list-customers")
    public String listCustomers(Model model){
        model.addAttribute("customers",customerDao.findAll());
        return "customers";
    }
    @GetMapping("/customer/delete")
    public String deleteCustomer(@RequestParam("id")int id){
        customerDao.deleteById(id);
        return "redirect:/customer/list-customer";
    }
}
