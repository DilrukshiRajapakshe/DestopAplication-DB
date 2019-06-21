package sliit.destope.dilrukshi.rajapakshe.controller;

import ijse.dep.dilrukshi.rajapakshe.business.BOFactory;
import sliit.destope.dilrukshi.rajapakshe.business.custom.ManageLoginBO;
import ijse.dep.dilrukshi.rajapakshe.dto.loginDTO;
import ijse.dep.dilrukshi.rajapakshe.entity.loginFK;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginController {
    public AnchorPane login;
    public TextField email;
    public TextField password;
    private ManageLoginBO manageLoginBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.MANAGE_LOGIN);
    public void login(ActionEvent actionEvent) {
        if(email.getText().trim().isEmpty()){
            System.out.println("User name is empty");
            new Alert(Alert.AlertType.ERROR, "User name is empty", ButtonType.OK).showAndWait();
            email.requestFocus();
            return;
        }else if(password.getText().trim().isEmpty()){
            System.out.println("User name is empty");
            new Alert(Alert.AlertType.ERROR, "Password is empty", ButtonType.OK).showAndWait();
            password.requestFocus();
            return;
        }
        if(!email.getText().trim().isEmpty()  || !password.getText().trim().isEmpty() ){

            try {
                loginFK fk = new loginFK(email.getText(),password.getText());
                loginDTO employeeLogin = manageLoginBO.findEmployeeLogin(fk);

                if(employeeLogin == null){
                    new Alert(Alert.AlertType.ERROR, "Your user name or  password are incorrect please recheck", ButtonType.OK).showAndWait();
                }else {
                    new Alert(Alert.AlertType.ERROR, "Your are successfully Login", ButtonType.OK).showAndWait();
                    Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/sliit/destope/dilrukshi/rajapakshe/view/Main.fxml"));
                    loginPage(dashRoot);
                }

            } catch (Exception e) {
                Logger.getLogger("").log(Level.SEVERE, null, e);
            }
        }
    }

    public void reset(ActionEvent actionEvent) throws IOException {
        Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/sliit/destope/dilrukshi/rajapakshe/view/ChangePassword.fxml"));
        loginPage(dashRoot);
    }

    public void loginPage(Parent dashRoot){
        Scene se = new Scene(dashRoot);
        Stage primaryStage = (Stage)login.getScene().getWindow();
        primaryStage.setScene(se);
        primaryStage.show();
    }
}
