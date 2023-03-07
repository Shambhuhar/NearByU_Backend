package com.example.springproject.Controller;

import java.util.Optional;

import com.example.springproject.Beans.Customer;
import com.example.springproject.Beans.Worker;
import com.example.springproject.Service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login/worker")
    public Worker login(@RequestBody Worker w) {
        if (authService.loginWorker(w.getEmail(), w.getPassword())) {
            return authService.getWorker(w.getEmail());

        }
        return null;
    }

    @PostMapping("/login/customer")
    public Customer login(@RequestBody Customer c) {
        // if (Integer i= authService.loginCustomers(c.getEmail(), c.getPassword())) {
        // return authService.getCustomer(c.getEmail());

        // }
        Integer i = authService.loginCustomers(c.getEmail(), c.getPassword());
        if (i != null) {
            Optional<Customer> c1 = authService.getById(i);
            return c1.get();
        }
        return null;
    }
}
