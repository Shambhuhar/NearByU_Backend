package com.example.springproject.Dao;

import com.example.springproject.Beans.Customer;
import com.example.springproject.Beans.Worker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthDao extends JpaRepository<Worker, Integer> {

    @Query(value = "select * from workers where email = ?", nativeQuery = true)
    Worker findByEmail(String email);

    @Query(value = "select * from workers where email = ?", nativeQuery = true)
    Worker getByEmail(String email);

    @Query(value = "select * from workers where email = ? and password=?", nativeQuery = true)
    Worker loginCheck(String email, String password);

    @Query(value = "select email from customers where email = ?", nativeQuery = true)
    String findByEmailCust(String email);

    @Query(value = "select id,email,password from customers where email = ?", nativeQuery = true)
    Customer getByEmailCust(String email);

    @Query(value = "select id from customers where email = ? and password=?", nativeQuery = true)
    Integer loginCheckCust(String email, String password);
}
