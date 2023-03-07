package com.example.springproject.Controller;

import java.util.List;
import java.util.Optional;

import com.example.springproject.Beans.Order;
import com.example.springproject.Service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/order")
	public List<Order> getAllOrder() {
		return orderService.displayAll();
	}

	@GetMapping("/order/{id}")
	public Order getById(@PathVariable int id) {
		Optional<Order> p = orderService.getById(id);
		if (p.isPresent()) {
			return p.get();
		} else {
			return null;
		}
	}

	@PostMapping("/order")
	public Order addOrder(@RequestBody Order p) {
		System.out.println(p);
		return orderService.addOrder(p);
	}

	@PutMapping("/order/{id}")
	public Order updateOrder(@RequestBody Order p) {
		return orderService.updateById(p);
	}

}
