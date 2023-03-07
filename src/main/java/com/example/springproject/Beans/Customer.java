package com.example.springproject.Beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(unique = true)
	private String email;

	private String first_name;

	private String last_name;;

	private String password;

	private int phone_no;

	private String address;

	private int aadhar_no;

	private int pin_code;

	private String city;

	@OneToOne(mappedBy = "customer")
	private Order order;

	@JsonIgnore
	@OneToOne(mappedBy = "customer")
	private Feedback feedback;

	public Customer() {
	}

	public Customer(int id, String email, String first_name, String last_name, String password, int phone_no,
			String address, int aadhar_no, int pin_code, String city) {
		this.id = id;
		this.email = email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.password = password;
		this.phone_no = phone_no;
		this.address = address;
		this.aadhar_no = aadhar_no;
		this.pin_code = pin_code;
		this.city = city;
	}

	public Customer(int id, String email, String first_name, String last_name, String password, int phone_no,
			String address, int aadhar_no, int pin_code, String city, Order order, Feedback feedback) {
		this.id = id;
		this.email = email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.password = password;
		this.phone_no = phone_no;
		this.address = address;
		this.aadhar_no = aadhar_no;
		this.pin_code = pin_code;
		this.city = city;
		this.order = order;
		this.feedback = feedback;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst_name() {
		return this.first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return this.last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhone_no() {
		return this.phone_no;
	}

	public void setPhone_no(int phone_no) {
		this.phone_no = phone_no;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAadhar_no() {
		return this.aadhar_no;
	}

	public void setAadhar_no(int aadhar_no) {
		this.aadhar_no = aadhar_no;
	}

	public int getPin_code() {
		return this.pin_code;
	}

	public void setPin_code(int pin_code) {
		this.pin_code = pin_code;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Feedback getFeedback() {
		return this.feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", email=" + email + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", password=" + password + ", phone_no=" + phone_no + ", address=" + address + ", aadhar_no="
				+ aadhar_no + ", pin_code=" + pin_code + ", city=" + city + ", order=" + order + ", feedback="
				+ feedback + "]";
	}

}
