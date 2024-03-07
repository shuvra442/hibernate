package com.hibernate;

import com.hibernate.mapDemo.Answer;
import com.hibernate.mapDemo.Question;
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


//        ManyToOne mapping

        Question question=new Question();
        question.setId(1);
        question.setQuestion("what is java");

        Answer answer=new Answer();
        answer.setId(1);
        answer.setAnswer("java is a programming language");
        answer.setQuestion(question);

        Answer answer1=new Answer();
        answer1.setId(2);
        answer1.setAnswer("its has a different type of framework");
        answer1.setQuestion(question);

        Answer answer2=new Answer();
        answer2.setId(3);
        answer2.setAnswer("also is a oops concept");
        answer2.setQuestion(question);

        List<Answer> answers=new ArrayList<>();
        answers.add(answer);
        answers.add(answer1);
        answers.add(answer2);

        question.setAnswer(answers);

        Session session= factory.openSession();
        Transaction transaction= session.beginTransaction();

        session.save(question);
        session.save(answer);
        session.save(answer1);
        session.save(answer2);

        Question questions=session.get(Question.class,1);
        System.out.println(questions.getQuestion());
        for (Answer e: questions.getAnswer()){
            System.out.println(e.getAnswer());
        }
        transaction.commit();
        factory.close();
    }
}
