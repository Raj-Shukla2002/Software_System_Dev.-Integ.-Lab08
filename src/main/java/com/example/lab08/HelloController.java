package com.example.lab08;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    public TableView<StudentRecord> tableView;
    public TableColumn<StudentRecord, String> colSID;
    public TableColumn<StudentRecord, Float> colAssignments;
    public TableColumn<StudentRecord, Float> colMidterm;
    public TableColumn<StudentRecord, Float> colExam;
    public TableColumn<StudentRecord, Float> colFinalGrade;
    public TableColumn<StudentRecord, String> colLetterGrade;

    public TextField textfieldID;
    public TextField textfieldMidterm;
    public TextField textfieldAssignment;
    public TextField textfieldExam;

    private DataSource students = new DataSource();
    public ObservableList<StudentRecord> marks = students.getAllMarks();
    public String filename = "Students.csv";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colSID.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        colAssignments.setCellValueFactory(new PropertyValueFactory<>("studentAssginment"));
        colMidterm.setCellValueFactory(new PropertyValueFactory<>("studentMidterm"));
        colExam.setCellValueFactory(new PropertyValueFactory<>("studentExam"));
        colFinalGrade.setCellValueFactory(new PropertyValueFactory<>("studentFinal"));
        colLetterGrade.setCellValueFactory(new PropertyValueFactory<>("studentLetter"));
        tableView.setItems(marks);
    }
    public void menuExit(ActionEvent actionEvent){
        System.exit(0);
    }
    public void menuNew(ActionEvent actionEvent){
        marks.remove(0,marks.size());
    }
    public void menuLoad(ActionEvent actionEvent){

    }
    public void save(ActionEvent actionEvent) throws Exception{
        Writer writer = null;
        try {
            File file = new File("E:\\Workspace\\Intelj\\Lab08\\src\\main\\resources\\com\\example\\lab08\\test.csv");
            writer = new BufferedWriter(new FileWriter(file));
            for(StudentRecord student : marks){
                String text = student.getStudentID() + ","  + student.getStudentAssginment() + "," + student.getStudentMidterm() + "," + student.getStudentExam() + "\n";
                writer.write(text);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            writer.flush();
            writer.close();
        }

    }

    public void buttonAdd(ActionEvent actionEvent){
        marks.add(new StudentRecord(textfieldID.getText(), Float.parseFloat(textfieldAssignment.getText()), Float.parseFloat(textfieldMidterm.getText()), Float.parseFloat(textfieldExam.getText())));

    }
}