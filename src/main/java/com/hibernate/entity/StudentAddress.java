package com.hibernate.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student_address")
public class StudentAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "village_PO")
    private String village;
    @Column(name = "P_S")
    private String policeStation;
    private boolean isMunicipleArea;
    private  String state;

    public StudentAddress(){

    }

    @Override
    public String toString() {
        return "StudentAddress{" +
                "id=" + id +
                ", village='" + village + '\'' +
                ", policeStation='" + policeStation + '\'' +
                ", isMunicipleArea=" + isMunicipleArea +
                ", state='" + state + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getPoliceStation() {
        return policeStation;
    }

    public void setPoliceStation(String policeStation) {
        this.policeStation = policeStation;
    }

    public boolean isMunicipleArea() {
        return isMunicipleArea;
    }

    public void setMunicipleArea(boolean municipleArea) {
        isMunicipleArea = municipleArea;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
