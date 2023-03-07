package com.example.springproject.Dao;

import com.example.springproject.Beans.Feedback;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackDao extends JpaRepository<Feedback, Integer> {

}
