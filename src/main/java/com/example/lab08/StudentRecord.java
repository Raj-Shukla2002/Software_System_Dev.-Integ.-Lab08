package com.example.lab08;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;

public class StudentRecord {
    private SimpleStringProperty studentID;
    private SimpleFloatProperty studentAssginment;
    private SimpleFloatProperty studentMidterm;
    private SimpleFloatProperty studentExam;
    private SimpleFloatProperty studentFinal;
    private SimpleStringProperty studentLetter;

    private float x;
    private float a, m, e;

    public StudentRecord(String studentID, float studentAssginment, float studentMidterm, float studentExam) {
        this.studentID = new SimpleStringProperty(studentID);
        this.studentAssginment = new SimpleFloatProperty(studentAssginment);
        this.studentMidterm = new SimpleFloatProperty(studentMidterm);
        this.studentExam = new SimpleFloatProperty(studentExam);

        x = (studentAssginment * 0.20f) + (studentMidterm * 0.30f) + (studentExam * 0.50f);
        this.studentFinal = new SimpleFloatProperty(x);
        if (x >= 80) {
            this.studentLetter = new SimpleStringProperty("A");
        } else if (x <= 79 && x >= 70) {
            this.studentLetter = new SimpleStringProperty("B");
        } else if (x <= 69 && x >= 60) {
            this.studentLetter = new SimpleStringProperty("C");
        } else if (x <= 59 && x >= 50) {
            this.studentLetter = new SimpleStringProperty("D");
        } else {
            this.studentLetter = new SimpleStringProperty("F");
        }
    }

    public String getStudentID() {
        return studentID.get();
    }

    public void setStudentID(String studentID) {
        this.studentID = new SimpleStringProperty(studentID);
    }

    public float getStudentAssginment() {
        return studentAssginment.get();
    }

    public void setStudentAssginment(float studentAssginment) {
        this.studentAssginment = new SimpleFloatProperty(studentAssginment);
    }

    public float getStudentMidterm() {
        return studentMidterm.get();
    }

    public void setStudentMidterm(float studentMidterm) {
        this.studentMidterm = new SimpleFloatProperty(studentMidterm);
    }

    public float getStudentExam() {
        return studentExam.get();
    }

    public void setStudentExam(float studentExam) {
        this.studentExam = new SimpleFloatProperty(studentExam);
    }

    public float getStudentFinal() {
        return studentFinal.get();
    }

    public void setStudentFinal() {
        x = (a * 0.20f) + (m * 0.30f) + (e * 0.50f);
        this.studentFinal = new SimpleFloatProperty(x);
    }

    public String getStudentLetter() {
        return studentLetter.get();
    }

    public void setStudentLetter() {
        if (x >= 80) {
            this.studentLetter = new SimpleStringProperty("A");
        } else if (x <= 79 && x >= 70) {
            this.studentLetter = new SimpleStringProperty("B");
        } else if (x <= 69 && x >= 60) {
            this.studentLetter = new SimpleStringProperty("C");
        } else if (x <= 59 && x >= 50) {
            this.studentLetter = new SimpleStringProperty("D");
        } else {
            this.studentLetter = new SimpleStringProperty("F");
        }
    }
}
