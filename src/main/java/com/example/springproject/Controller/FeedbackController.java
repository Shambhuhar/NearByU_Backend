package com.example.springproject.Controller;

import java.util.List;
import java.util.Optional;

import com.example.springproject.Beans.Feedback;
import com.example.springproject.Service.FeedbackService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/feedback")
    public List<Feedback> getAllFeedback() {
        return feedbackService.displayAll();
    }

    @GetMapping("/feedback/{id}")
    public Feedback getById(@PathVariable int id) {
        Optional<Feedback> p = feedbackService.getById(id);
        if (p.isPresent()) {
            return p.get();
        } else {
            return null;
        }
    }

    @PostMapping("/feedback")
    public Feedback addfeedback(@RequestBody Feedback p) {
        return feedbackService.addFeedback(p);
    }

    @PutMapping("/Feedback/{id}")
    public Feedback updateFeedback(@RequestBody Feedback p) {
        return feedbackService.updateById(p);
    }

    @DeleteMapping("/Feedback/{id}")
    public void deleteFeedback(@PathVariable int id) {
        feedbackService.deleteById(id);
    }

}
