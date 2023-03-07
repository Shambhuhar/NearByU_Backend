package com.example.springproject.Beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "workers")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String email;
    private String firstname;
    private String lastname;
    private String password;
    private String phone;
    private String address;
    private int aadharno;
    private int pincode;
    private String city;
    private int workexperiance;
    private int status;
    private String activetime;

    @OneToOne(mappedBy = "worker")
    private Order order;

    @JsonIgnore
    @OneToOne(mappedBy = "worker")
    private Feedback feedback;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "workers_categories", joinColumns = { @JoinColumn(name = "worker_id") }, inverseJoinColumns = {
            @JoinColumn(name = "category_id") })
    private Set<Category> categories = new HashSet<>();

    /**
     * 
     */
    public Worker() {
    }

    public Worker(int id, String email, String firstname, String lastname, String password, String phone,
            String address, int aadharno, int pincode, String city, int workexperiance, int status, String activetime,
            Order order) {
        this.id = id;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.aadharno = aadharno;
        this.pincode = pincode;
        this.city = city;
        this.workexperiance = workexperiance;
        this.status = status;
        this.activetime = activetime;
        this.order = order;
    }

    public Worker(int id, String email, String firstname, String lastname, String password, String phone,
            String address, int aadharno, int pincode, String city, int workexperiance, int status, String activetime) {
        this.id = id;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.aadharno = aadharno;
        this.pincode = pincode;
        this.city = city;
        this.workexperiance = workexperiance;
        this.status = status;
        this.activetime = activetime;
    }

    public Worker(int id, String email, String firstname, String lastname, String password, String phone,
            String address, int aadharno, int pincode, String city, int workexperiance, int status, String activetime,
            Set<Category> categories) {
        this.id = id;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.aadharno = aadharno;
        this.pincode = pincode;
        this.city = city;
        this.workexperiance = workexperiance;
        this.status = status;
        this.activetime = activetime;
        this.categories = categories;
    }

    /**
     * @param email
     * @param firstname
     * @param lastname
     * @param password
     * @param categories
     */
    public Worker(String email, String firstname, String lastname, String password, Set<Category> categories) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.categories = categories;
    }

    public Worker(int id, String email, String firstname, String lastname, String password, String phone,
            String address, int aadharno, int pincode, String city, int workexperiance, int status, String activetime,
            Order order, Feedback feedback, Set<Category> categories) {
        this.id = id;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.aadharno = aadharno;
        this.pincode = pincode;
        this.city = city;
        this.workexperiance = workexperiance;
        this.status = status;
        this.activetime = activetime;
        this.order = order;
        this.feedback = feedback;
        this.categories = categories;
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

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAadharno() {
        return this.aadharno;
    }

    public void setAadharno(int aadharno) {
        this.aadharno = aadharno;
    }

    public int getPincode() {
        return this.pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getWorkexperiance() {
        return this.workexperiance;
    }

    public void setWorkexperiance(int workexperiance) {
        this.workexperiance = workexperiance;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getActivetime() {
        return this.activetime;
    }

    public void setActivetime(String activetime) {
        this.activetime = activetime;
    }

    public Set<Category> getCategories() {
        return this.categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    /**
     * @return the order
     */
    public Order getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(Order order) {
        this.order = order;
    }

    /**
     * @return the feedback
     */
    public Feedback getFeedback() {
        return feedback;
    }

    /**
     * @param feedback the feedback to set
     */
    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

	@Override
	public String toString() {
		return "Worker [id=" + id + ", email=" + email + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", password=" + password + ", phone=" + phone + ", address=" + address + ", aadharno=" + aadharno
				+ ", pincode=" + pincode + ", city=" + city + ", workexperiance=" + workexperiance + ", status="
				+ status + ", activetime=" + activetime + ", order=" + order + ", feedback=" + feedback
				+ ", categories=" + categories + "]";
	}

}
