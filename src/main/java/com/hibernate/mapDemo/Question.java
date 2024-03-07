package com.hibernate.mapDemo;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Question {
    @Id
    private int id;
    private String question;

    @OneToMany(mappedBy = "question")
    private List<Answer> answer;

    public Question(){}

    public Question(int id, String question, List<Answer> answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Answer> answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer=" + answer +
                '}';
    }
}
