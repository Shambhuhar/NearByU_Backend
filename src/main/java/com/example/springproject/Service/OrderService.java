package com.example.springproject.Service;

import java.util.List;
import java.util.Optional;

import com.example.springproject.Beans.Order;
import com.example.springproject.Dao.OrderDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;

	public Order addOrder(Order p) {
		try {
			return orderDao.save(p);
		} catch (IllegalArgumentException e) {
			return null;
		}

	}

	public List<Order> displayAll() {
		return orderDao.findAll();
	}

	public Optional<Order> getById(int id) {
		Optional<Order> op = orderDao.findById(id);
		if (op.isPresent()) {
			return op;
		} else {
			return Optional.empty();
		}

	}

	public Order updateById(Order p) {
		Optional<Order> p1 = orderDao.findById(p.getId());
		if (p1.isPresent()) {
			Order p2 = p1.get();
			// p2.setCustomer(p.getCustomer());
			p2.setWorker(p.getWorker());
			p2.setOrder_date(p.getOrder_date());
			p2.setOrder_time(p.getOrder_time());
			p2.setDescription(p.getDescription());
			p2.setTotal_amount(p.getTotal_amount());
			p2.setStatus(p.getStatus());

			return orderDao.save(p2);
		}

		return null;
	}
}
