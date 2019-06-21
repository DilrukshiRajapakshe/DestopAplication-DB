package sliit.destope.dilrukshi.rajapakshe.controller;

import ijse.dep.dilrukshi.rajapakshe.business.BOFactory;
import sliit.destope.dilrukshi.rajapakshe.business.custom.ManageLoginBO;
import ijse.dep.dilrukshi.rajapakshe.dto.loginDTO;
import ijse.dep.dilrukshi.rajapakshe.entity.loginFK;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ChangePasswordController {
    @FXML
    public AnchorPane changePassword;
    @FXML
    public TextField email;
    @FXML
    public TextField password;
    @FXML
    public TextField conformPass;
    @FXML
    public TextField Oldpassword;

    private ManageLoginBO manageLoginBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.MANAGE_LOGIN);

    public void reset(ActionEvent actionEvent) {
        if(email.getText().trim().isEmpty()){
            System.out.println("User name is empty");
            new Alert(Alert.AlertType.ERROR, "User name is empty", ButtonType.OK).showAndWait();
            email.requestFocus();
            return;
        }else if(Oldpassword.getText().trim().isEmpty()){
            System.out.println("User name is empty");
            new Alert(Alert.AlertType.ERROR, "Old password is empty", ButtonType.OK).showAndWait();
            Oldpassword.requestFocus();
            return;
        }else if(password.getText().trim().isEmpty()){
            System.out.println("User name is empty");
            new Alert(Alert.AlertType.ERROR, "Password is empty", ButtonType.OK).showAndWait();
            password.requestFocus();
            return;
        }else if(conformPass.getText().trim().isEmpty()){
            System.out.println("User name is empty");
            new Alert(Alert.AlertType.ERROR, "Conform password name is empty", ButtonType.OK).showAndWait();
            conformPass.requestFocus();
            return;
        }
        if(!email.getText().trim().isEmpty() || !Oldpassword.getText().trim().isEmpty() || !password.getText().trim().isEmpty() || !conformPass.getText().trim().isEmpty()){
            String eid ;
            try {
                loginFK fk = new loginFK(email.getText(),Oldpassword.getText());
                loginDTO employeeLogin = manageLoginBO.findEmployeeLogin(fk);

                if(employeeLogin == null){
                    new Alert(Alert.AlertType.ERROR, "Your user name or Old password are incorrect please recheck", ButtonType.OK).showAndWait();
                }else {
                    eid = employeeLogin.getNic();
                   if(password.getText().equals(conformPass.getText())){
                       System.out.println(eid);
                       System.out.println(password.getText());
                       System.out.println(email.getText());
                       System.out.println(new loginDTO(email.getText(),password.getText(),eid)+"213");
                       manageLoginBO.updateEmployeeLogin(new loginDTO(email.getText(),password.getText(),eid));
                       new Alert(Alert.AlertType.ERROR, "Your are successfully update your password", ButtonType.OK).showAndWait();
                       Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/sliit/destope/dilrukshi/rajapakshe/view/Login.fxml"));
                       loginPage(dashRoot);
                   }else{
                       new Alert(Alert.AlertType.ERROR, "Your new password and conform password not same re Enter details ", ButtonType.OK).showAndWait();
                   }

                }

            } catch (Exception e) {
                Logger.getLogger("").log(Level.SEVERE, null, e);
            }
        }
    }

    public void loginPage(Parent dashRoot){
        Scene se = new Scene(dashRoot);
        Stage primaryStage = (Stage)changePassword.getScene().getWindow();
        primaryStage.setScene(se);
        primaryStage.show();
    }
}
