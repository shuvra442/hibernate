package com.hibernate.mapDemos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Project {
    @Id
    private int id;
    private String projName;

    @ManyToMany(mappedBy = "projects")
    private List<Employee>employees;

    public Project() {
    }

    public Project(int id, String projName, List<Employee> employees) {
        this.id = id;
        this.projName = projName;
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
