package com.hibernate;

import com.hibernate.entity.Course;
import com.hibernate.entity.Student;
import com.hibernate.entity.StudentAddress;
import com.hibernate.mapDemo.Answer;
import com.hibernate.mapDemo.Question;
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

//        oneToOne mapping example
        Question question=new Question();
        question.setId(1);
        question.setQuestion("what is java");

        Answer answer=new Answer();
        answer.setId(2);
        answer.setAnswer("java is programming language");
        question.setAnswer(answer);

        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(question);
        session.save(answer);
        transaction.commit();
        Question qs =session.get(Question.class, 1);
        System.out.println(qs.getQuestion());
        System.out.println(qs.getAnswer().getAnswer());
        factory.close();
    }
}
