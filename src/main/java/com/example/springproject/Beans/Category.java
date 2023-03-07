package com.example.springproject.Beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    @JsonIgnore
    @ManyToMany(mappedBy = "categories")
    private Set<Worker> workers = new HashSet<>();

    /**
     * 
     */
    public Category() {
    }

    /**
     * @param id
     */
    public Category(int id) {
        this.id = id;
    }

    /**
     * @param id
     * @param name
     * @param description
     */
    public Category(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Category(int id, String name, String description, Set<Worker> workers) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.workers = workers;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Worker> getWorkers() {
        return this.workers;
    }

    public void setWorkers(Set<Worker> workers) {
        this.workers = workers;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", description='" + getDescription() + "'"
                + "}";
    }

}
