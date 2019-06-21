package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.controller;

import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.BOFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.custom.ManageStudentBO;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.studentDTO;

import java.io.IOException;
import java.util.ArrayList;

public class StudentRegisterFormController {
    public AnchorPane registerForm;
    @FXML
    public TextField Sid;
    @FXML
    public TextField SIniName;
    @FXML
    public TextField SfulName;
    @FXML
    public TextField SAdd;
    @FXML
    public TextField Scity;
    @FXML
    public TextField Htel;
    @FXML
    public TextField Mtel;
    @FXML
    public TextField Email;
    @FXML
    public TextField Sbd;
    @FXML
    public HBox genderGroup;
    @FXML
    public RadioButton fmail;
    @FXML
    public ToggleGroup gender;
    @FXML
    public RadioButton mail;
    private ManageStudentBO manageStudentBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.MANAGE_STUDENT);
    static ArrayList<sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.studentDTO> Student_list = new ArrayList<>();
    public void goHome(MouseEvent mouseEvent) {

    }

    public void goBack(MouseEvent mouseEvent) {

    }

    public void SaveANDUpdate(MouseEvent mouseEvent) throws IOException {
        if(Sid.getText().trim().isEmpty()){
            System.out.println("0");
        }else if(SIniName.getText().trim().isEmpty()){
            System.out.println("1");
        }else if(SfulName.getText().trim().isEmpty()){
            System.out.println("2");
        }else if(SAdd.getText().trim().isEmpty()){
            System.out.println("3");
        }else if(Scity.getText().trim().isEmpty()){
            System.out.println("4");
        }else if(Htel.getText().trim().isEmpty()){
            System.out.println("5");
        }else if(Mtel.getText().trim().isEmpty()){
            System.out.println("6");
        }else if(Email.getText().trim().isEmpty()){
            System.out.println("7");
        }else if(Sbd.getText().trim().isEmpty()){
            System.out.println("8");
        }else if(!fmail.isSelected()&&!mail.isSelected()){
            System.out.println("9");
        }else{
            sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.studentDTO StudentDTO = new studentDTO(Sid.getText(), SIniName.getText(), SfulName.getText(), SAdd.getText(),Scity.getText(),Htel.getText(),Mtel.getText(),Email.getText(),Sbd.getText(),selectedRadioButton());
            Student_list.add(StudentDTO);
            Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/sliit/destope/dilrukshi/rajapakshe/application/architecture/student/system/view/frame/ParentDetailsForm.fxml"));
            loginPage(dashRoot);
//            boolean result = false;
//            try {
//                result = manageStudentBO.createStudent(StudentDTO);
//            } catch (Exception e) {
//                    Logger.getLogger("").log(Level.SEVERE, null, e);
//            }
//
//            if (result) {
//                new Alert(Alert.AlertType.INFORMATION, "Student has been saved successfully", ButtonType.OK).showAndWait();
//
//            } else {
//                new Alert(Alert.AlertType.ERROR, "Failed to save the Batch", ButtonType.OK).showAndWait();
//            }
        }
    }

    public void UpdatedDetailed(MouseEvent mouseEvent) {

    }

    public void loginPage(Parent dashRoot){
        Scene se = new Scene(dashRoot);
        Stage primaryStage = (Stage)registerForm.getScene().getWindow();
        primaryStage.setScene(se);
        primaryStage.show();
    }

    public String selectedRadioButton(){
        String gender;
        if(fmail.isSelected()){
            gender=fmail.getText();
            System.out.println("aaaaa"+gender);
            return  gender;
        }
        gender=mail.getText();
        System.out.println("aaaaa"+gender);
        return gender;
    }
}
