package com.example.springproject.Controller;

import java.util.List;
import java.util.Optional;

import com.example.springproject.Beans.Worker;
import com.example.springproject.Service.WorkerService;

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
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @GetMapping("/worker")
    public List<Worker> getAllWorker() {
        return workerService.displayAll();
    }

    @GetMapping("/worker/{id}")
    public Worker getById(@PathVariable int id) {
        Optional<Worker> p = workerService.getById(id);
        if (p.isPresent()) {
            return p.get();
        } else {
            return null;
        }
    }

    @PostMapping("/worker")
    public Worker addworker(@RequestBody Worker p) {
        return workerService.addWorker(p);
    }

    @PutMapping("/worker/{id}")
    public Worker updateworker(@RequestBody Worker p) {
        return workerService.updateById(p);
    }

    @DeleteMapping("/worker/{id}")
    public void deleteWorker(@PathVariable int id) {
        workerService.deleteById(id);
    }

}
