package com.example.springproject.Controller;

import java.util.List;
import java.util.Optional;

import com.example.springproject.Beans.Category;
import com.example.springproject.Service.CategoryService;

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
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public List<Category> getAllCategory() {
        return categoryService.displayAll();
    }

    @GetMapping("/category/{id}")
    public Category getById(@PathVariable int id) {
        Optional<Category> p = categoryService.getById(id);
        if (p.isPresent()) {
            return p.get();
        } else {
            return null;
        }
    }

    @PostMapping("/category")
    public Category addcategory(@RequestBody Category p) {
        return categoryService.addCategory(p);
    }

    @PutMapping("/category/{id}")
    public Category updatecategory(@RequestBody Category p) {
        return categoryService.updateById(p);
    }

    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable int id) {
        categoryService.deleteById(id);
    }

}
