package com.example.springproject.Service;

import java.util.List;
import java.util.Optional;

import com.example.springproject.Beans.Worker;
import com.example.springproject.Dao.WorkerDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {

    @Autowired
    private WorkerDao workerDao;

    public Worker addWorker(Worker p) {
        try {
            return workerDao.save(p);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public List<Worker> displayAll() {
        return workerDao.findAll();
    }

    public Optional<Worker> getById(int id) {
        Optional<Worker> op = workerDao.findById(id);
        if (op.isPresent()) {
            return op;
        } else {
            return Optional.empty();
        }
    }

    public void deleteById(int id) {
        workerDao.deleteById(id);
    }

    public Worker updateById(Worker p) {
        Optional<Worker> p1 = workerDao.findById(p.getId());
        if (p1.isPresent()) {
            Worker p2 = p1.get();
            p2.setFirstname(p.getFirstname());
            p2.setLastname(p.getLastname());
            p2.setPassword(p.getPassword());
            p2.setPhone(p.getPhone());
            p2.setAddress(p.getAddress());
            p2.setAadharno(p.getAadharno());
            p2.setPincode(p.getPincode());
            p2.setCity(p.getCity());
            p2.setCategories(p.getCategories());

            return workerDao.save(p2);

        } else {
            return null;
        }
    }
}
