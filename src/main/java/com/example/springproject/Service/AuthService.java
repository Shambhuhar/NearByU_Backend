package com.example.springproject.Service;

import java.util.Optional;

import com.example.springproject.Beans.Customer;
import com.example.springproject.Beans.Worker;
import com.example.springproject.Dao.AuthDao;
import com.example.springproject.Dao.CustomerDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthDao authDao;

    @Autowired
    private CustomerDao customerDao;

    public boolean loginWorker(String username, String password) {
        Worker w = authDao.findByEmail(username);
        if (w != null) {
            Worker w1 = authDao.loginCheck(username, password);
            if (w1 != null) {
                return true;
            }
        }
        return false;
    }

    public Integer loginCustomers(String username, String password) {
        // Customer w = authDao.findByEmailCust(username);
        String email = authDao.findByEmailCust(username);
        // System.out.println(w);
        if (email != null) {
            Integer w1 = authDao.loginCheckCust(username, password);
            if (w1 != null) {
                return w1;
            }

        }
        return null;
    }

    public Worker getWorker(String username) {
        return authDao.getByEmail(username);
    }

    public Customer getCustomer(String email) {
        return authDao.getByEmailCust(email);
    }

    public Optional<Customer> getById(int id) {
        Optional<Customer> op = customerDao.findById(id);
        if (op.isPresent()) {
            return op;
        } else {
            return Optional.empty();
        }

    }
}
