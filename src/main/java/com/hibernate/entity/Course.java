package com.hibernate.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Course {
    private String courseName;
    private String courseDuration;

    public Course(){

    }

    public Course(String courseName, String courseDuration) {
        this.courseName = courseName;
        this.courseDuration = courseDuration;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", courseDuration='" + courseDuration + '\'' +
                '}';
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }
}
