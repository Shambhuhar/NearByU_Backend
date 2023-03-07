package com.example.springproject.Dao;

import com.example.springproject.Beans.Worker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerDao extends JpaRepository<Worker, Integer> {

}
