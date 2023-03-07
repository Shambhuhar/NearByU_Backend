package com.example.springproject.Controller;

import java.util.List;
import java.util.Optional;

import com.example.springproject.Beans.Customer;
import com.example.springproject.Service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer")
    public List<Customer> getAllCustomer() {
        return customerService.displayAll();
    }

    @GetMapping("/customer/{customer_id}")
    public Customer getById(@PathVariable int customer_id) {
        Optional<Customer> p = customerService.getById(customer_id);
        if (p.isPresent()) {
            return p.get();
        } else {
            return null;
        }
    }

    @PostMapping("/customer")
    public Customer addcustomer(@RequestBody Customer p) {
        return customerService.addCustomer(p);
    }

    @PutMapping("/customer/{customer_id}")
    public Customer updateworker(@RequestBody Customer p) {
        return customerService.updateById(p);
    }

    @DeleteMapping("/customer/{customer_id}")
    public void deleteWorker(@PathVariable int id) {
        customerService.deleteById(id);
    }

}