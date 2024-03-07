package com.hibernate;


import com.hibernate.mapDemos.Employee;
import com.hibernate.mapDemos.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        System.out.println("program started");
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        System.out.println(factory);

//        ManyToMany

        Employee employee=new Employee();
        Employee employee1=new Employee();

        Project project=new Project();
        Project project1=new Project();

        employee.setId(1);
        employee.setEmpName("shuvra");

        employee1.setId(2);
        employee1.setEmpName("shuvankar");

        project.setId(1);
        project.setProjName("ChatBot");

        project1.setId(2);
        project1.setProjName("Image processing");

        List<Employee> list=new ArrayList<>();
        list.add(employee);
        list.add(employee1);

        List<Project>list1=new ArrayList<>();
        list1.add(project);
        list1.add(project1);

        employee1.setProjects(list1);
        project1.setEmployees(list);

        Session session= factory.openSession();
        Transaction transaction= session.beginTransaction();

        session.persist(employee);
        session.persist(employee1);
        session.persist(project);
        session.persist(project1);

        transaction.commit();
        session.close();

        factory.close();
    }
}
