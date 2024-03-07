package com.hibernate.mapDemos;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Employee {
    @Id
    private int id;
    private String empName;

    @ManyToMany
    @JoinTable(name = "TotalEmpProj",joinColumns =
            {
                    @JoinColumn (name = "emp_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "proj_id")
    })
    private List<Project>projects;

    public Employee() {
    }

    public Employee(int id, String empName, List<Project> projects) {
        this.id = id;
        this.empName = empName;
        this.projects = projects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
