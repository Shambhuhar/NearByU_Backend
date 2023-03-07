package com.example.springproject.Service;

import java.util.List;
import java.util.Optional;

import com.example.springproject.Beans.Customer;
import com.example.springproject.Dao.CustomerDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	@Autowired
	private CustomerDao customerDao;

	public List<Customer> displayAll() {
		return customerDao.findAll();
	}

	public Optional<Customer> getById(int id) {
		Optional<Customer> op = customerDao.findById(id);
		if (op.isPresent()) {
			return op;
		} else {
			return Optional.empty();
		}

	}

	public Customer addCustomer(Customer p) {

		try {
			return customerDao.save(p);
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	public Customer updateById(Customer p) {
		Optional<Customer> p1 = customerDao.findById(p.getId());
		if (p1.isPresent()) {
			Customer p2 = p1.get();
			p2.setEmail(p.getEmail());
			p2.setFirst_name(p.getFirst_name());
			p2.setLast_name(p.getLast_name());
			p2.setPassword(p.getPassword());
			p2.setPhone_no(p.getPhone_no());
			p2.setAddress(p.getAddress());
			p2.setAadhar_no(p.getAadhar_no());
			p2.setAadhar_no(p.getAadhar_no());
			p2.setCity(p.getCity());

			return customerDao.save(p2);

		} else {
			return null;
		}
	}

	public void deleteById(int id) {
		customerDao.deleteById(id);

	}

}
