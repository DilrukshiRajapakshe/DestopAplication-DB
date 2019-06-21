package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageParentDetailsCountroller {

    @FXML
    public TextField Sid;
    @FXML
    public TextField name;
    @FXML
    public TextField Mtel;
    @FXML
    public TextField Ftel;
    @FXML
    public TextField email;
    @FXML
    public TextField postion;
    @FXML
    public TextField work;
    @FXML
    public TextField add;
    public AnchorPane parentForm;

    public void goHome(MouseEvent mouseEvent) throws IOException {
        Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/sliit/destope/dilrukshi/rajapakshe/application/architecture/student/system/view/frame/selectFunctionForm.fxml"));
        loginPage(dashRoot);
    }

    public void goBack(MouseEvent mouseEvent) throws IOException {
        Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/sliit/destope/dilrukshi/rajapakshe/application/architecture/student/system/view/frame/selectFunctionForm.fxml"));
        loginPage(dashRoot);
    }

    public void SaveANDUpdate(MouseEvent mouseEvent) {

        if(name.getText().trim().isEmpty()){
            System.out.println("1");
        }else if(Mtel.getText().trim().isEmpty()){
            System.out.println("2");
        }else if(Ftel.getText().trim().isEmpty()){
            System.out.println("3");
        }else if(email.getText().trim().isEmpty()){
            System.out.println("4");
        }else if(postion.getText().trim().isEmpty()){
            System.out.println("5");
        }else if(work.getText().trim().isEmpty()){
            System.out.println("6");
        }else if(add.getText().trim().isEmpty()) {
            System.out.println("7");
        }else{

        }

    }

    public void loginPage(Parent dashRoot){
        Scene se = new Scene(dashRoot);
        Stage primaryStage = (Stage)parentForm.getScene().getWindow();
        primaryStage.setScene(se);
        primaryStage.show();
    }
}
