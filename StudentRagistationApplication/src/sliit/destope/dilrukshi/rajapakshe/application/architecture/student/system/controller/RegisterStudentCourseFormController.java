package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.controller;

import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dataBase.DBConnection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegisterStudentCourseFormController {
    
    @FXML
    ComboBox Cname;
    @FXML
    TextField Sid;
    @FXML 
    TextField Cid;
    @FXML
    TextField Bid;
    static ObservableList<String> items= FXCollections.observableArrayList();


//    private ManageBatchBO manageBatchBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.MANAGE_BATCH);
//    private ManageCourseBO manageCourseBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.MANAGE_COURSE);

    public void initialize() throws Exception {
        showCourseName();
        Cname.setItems(items);
    }
    
    public void goHome(MouseEvent mouseEvent) {

    }

    public void goBack(MouseEvent mouseEvent) {

    }

    public void SaveANDUpdate(MouseEvent mouseEvent) {

    }

    public void DeletedRow(MouseEvent mouseEvent) {

    }

    public void DeletedDetils(MouseEvent mouseEvent) {

    }

    public void UpdatedDetailed(MouseEvent mouseEvent) {

    }

    public void RegisterTheCourse(MouseEvent mouseEvent) {
    }

    public void SearchCourse(MouseEvent mouseEvent) {

    }


    public void showCourseName()throws Exception{
        Connection conn;
        conn= DBConnection.getConnection();
        PreparedStatement ps1 =  conn.prepareStatement("SELECT Cid, Cname FROM course");
        ResultSet r = ps1.executeQuery();
        while (r.next()) {
            items.add(r.getString("Cid"));
            items.add(r.getString("Cname"));

        }
        System.out.println(items);

    }

}
