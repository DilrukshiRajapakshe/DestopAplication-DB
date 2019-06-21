package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SelectFuntionCountroller {

    public AnchorPane selectMenu;

    public void ManageRegisterUser(MouseEvent mouseEvent) throws IOException {
        Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/sliit/destope/dilrukshi/rajapakshe/application/architecture/student/system/view/frame/ManageRegistationForm.fxml"));
        loginPage(dashRoot);
    }

    public void RigsterCourse(MouseEvent mouseEvent)throws IOException {
        Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/sliit/destope/dilrukshi/rajapakshe/application/architecture/student/system/view/frame/RegisterCourseForm.fxml"));
        loginPage(dashRoot);
    }

    public void CourseDetails(MouseEvent mouseEvent)throws IOException {
        Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/sliit/destope/dilrukshi/rajapakshe/application/architecture/student/system/view/frame/CourseForm.fxml"));
        loginPage(dashRoot);
    }

    public void GroupDetail(MouseEvent mouseEvent)throws IOException {
        Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/sliit/destope/dilrukshi/rajapakshe/application/architecture/student/system/view/frame/BatchForm.fxml"));
        loginPage(dashRoot);
    }

    public void loginPage(Parent dashRoot){
        Scene se = new Scene(dashRoot);
        Stage primaryStage = (Stage)selectMenu.getScene().getWindow();
        primaryStage.setScene(se);
        primaryStage.show();
    }

    public void NewUserCreation(MouseEvent mouseEvent) throws IOException {
        Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/sliit/destope/dilrukshi/rajapakshe/application/architecture/student/system/view/frame/RegisterStudentForm.fxml"));
        loginPage(dashRoot);
    }
}
