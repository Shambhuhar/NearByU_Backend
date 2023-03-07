package com.example.springproject.Beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "worker_id", referencedColumnName = "id")
	private Worker worker;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer customer;

	@JsonIgnore
	@OneToOne(mappedBy = "order")
	private Feedback feedback;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date order_date;

	private String order_time;

	private String description;

	private int total_amount;

	private String status;

	public Order() {
	}

	public Order(int id, Date order_date, String order_time, String description, int total_amount, String status) {
		this.id = id;
		this.order_date = order_date;
		this.order_time = order_time;
		this.description = description;
		this.total_amount = total_amount;
		this.status = status;
	}

	public Order(int id, Worker worker, Customer customer, Date order_date, String order_time, String description,
			int total_amount, String status) {
		this.id = id;
		this.worker = worker;
		this.customer = customer;
		this.order_date = order_date;
		this.order_time = order_time;
		this.description = description;
		this.total_amount = total_amount;
		this.status = status;
	}

	public Order(int id, Worker worker, Customer customer, Feedback feedback, Date order_date, String order_time,
			String description, int total_amount, String status) {
		this.id = id;
		this.worker = worker;
		this.customer = customer;
		this.feedback = feedback;
		this.order_date = order_date;
		this.order_time = order_time;
		this.description = description;
		this.total_amount = total_amount;
		this.status = status;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the worker
	 */
	public Worker getWorker() {
		return worker;
	}

	/**
	 * @param worker the worker to set
	 */
	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the order_date
	 */
	public Date getOrder_date() {
		return order_date;
	}

	/**
	 * @param order_date the order_date to set
	 */
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	/**
	 * @return the order_time
	 */
	public String getOrder_time() {
		return order_time;
	}

	/**
	 * @param order_time the order_time to set
	 */
	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the total_amount
	 */
	public int getTotal_amount() {
		return total_amount;
	}

	/**
	 * @param total_amount the total_amount to set
	 */
	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	public Feedback getFeedback() {
		return this.feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

}