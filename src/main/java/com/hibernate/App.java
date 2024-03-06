package com.hibernate;

import com.hibernate.entity.Course;
import com.hibernate.entity.Student;
import com.hibernate.entity.StudentAddress;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class App
{
    public static void main( String[] args )
    {
        System.out.println("program started");
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        System.out.println(factory);

//        1
//        set student table data in database
//        Student student=new Student();
//        student.setId(2);
//        student.setName("shuvra");
//        student.setAddress("jasora");



//        set studentAddress table data in database
//        StudentAddress studentAddress=new StudentAddress();
//        studentAddress.setVillage("jasora");
//        studentAddress.setPoliceStation("pasnkura");
//        studentAddress.setMunicipleArea(true);
//        studentAddress.setState("west bengal");

//     now define session to save data into database

//       session.save(student);
//       session.save(studentAddress);
//       transaction.commit();

//         2
//        using get() and load() find data form database
//       Student student1=session.get(Student.class, 2);
//       System.out.println(student1);
//       System.out.println(student1.getAddress());
//
//      StudentAddress address= session.load(StudentAddress.class,1);
//        System.out.println(address.getPoliceStation());


//        3 @Embeddable  annotation in java
        Student student=new Student();
        student.setId(2);
        student.setName("nirupam");
        student.setAddress("mecheda");

        Course course=new Course();
        course.setCourseName("Java FullStack");
        course.setCourseDuration("six month");

        StudentAddress address=new StudentAddress();
        address.setVillage("jasora");
        address.setPoliceStation("panskura");
        address.setState("West Bengal");
        address.setMunicipleArea(true);

        student.setCourse(course);

        Session session= factory.openSession();
        Transaction transaction=  session.beginTransaction();
//       save the student data and aso save the course data in the student table without creating course table
        session.save(student);
        session.save(address);

        transaction.commit();
        session.close();
        factory.close();
    }
}
