package com.example.springproject.Service;

import java.util.List;
import java.util.Optional;

import com.example.springproject.Beans.Category;
import com.example.springproject.Dao.CategoryDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    public Category addCategory(Category p) {
        try {
            return categoryDao.save(p);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public List<Category> displayAll() {
        return categoryDao.findAll();
    }

    public Optional<Category> getById(int id) {
        Optional<Category> op = categoryDao.findById(id);
        if (op.isPresent()) {
            return op;
        } else {
            return Optional.empty();
        }
    }

    public void deleteById(int id) {
        categoryDao.deleteById(id);
    }

    public Category updateById(Category p) {
        Optional<Category> p1 = categoryDao.findById(p.getId());
        if (p1.isPresent()) {
            Category p2 = p1.get();
            p2.setName(p.getName());
            p2.setDescription(p.getDescription());
            return categoryDao.save(p2);

        } else {
            return null;
        }
    }
}
