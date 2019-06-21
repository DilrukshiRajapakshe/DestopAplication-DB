package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.controller;

import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.BOFactory;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.view.frametable.courseTB;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.custom.ManageCourseBO;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.courseDTO;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.validation.MyForm;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CourseDetailsCountroller {
    @FXML
    public AnchorPane courseForm;
    @FXML
    public TextField Cid;
    @FXML
    public TextField Cname;
    @FXML
    public TextField Cdis;
    @FXML
    public TextField Cdu;
    @FXML
    public TableView<courseTB> CourseTable;
    private ManageCourseBO manageCourseBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.MANAGE_COURSE);

    public void initialize() {
        CourseTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Cid"));
        CourseTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Cname"));
        CourseTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Cdis"));
       CourseTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Cdura"));

        List<sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.courseDTO> courseDB = null;
        try {
            courseDB = manageCourseBO.getCourse();
        } catch (Exception e) {
           Logger.getLogger("").log(Level.SEVERE,null,e);
        }
        ObservableList<sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.courseDTO> CourseDTOS = FXCollections.observableArrayList(courseDB);
        ObservableList<courseTB> tblItems = FXCollections.observableArrayList();
        for (sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.courseDTO CourseDTO : CourseDTOS) {
            tblItems.add(new courseTB(CourseDTO.getCid(), CourseDTO.getCname(), CourseDTO.getCdis(),CourseDTO.getCdura()));
        }
        CourseTable.setItems(tblItems);

        CourseTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<courseTB>() {
            @Override
            public void changed(ObservableValue<? extends courseTB> observable, courseTB oldValue, courseTB selectedCourse) {

                if (selectedCourse == null) {
                    // Clear Selection
                    return;
                }

                Cid.setText(selectedCourse.getCid());
                Cname.setText(selectedCourse.getCname());
                Cdis.setText(selectedCourse.getCdis());
                Cdu.setText(selectedCourse.getCdura());

                Cid.setEditable(false);

            }
        });
    }




    public void goHome(MouseEvent mouseEvent) throws IOException {
        Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/sliit/destope/dilrukshi/rajapakshe/application/architecture/student/system/view/frame/selectFunctionForm.fxml"));
        loginPage(dashRoot);
    }

    public void goBack(MouseEvent mouseEvent) throws IOException {
        Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/sliit/destope/dilrukshi/rajapakshe/application/architecture/student/system/view/frame/selectFunctionForm.fxml"));
        loginPage(dashRoot);
    }

    public void SaveANDUpdate(MouseEvent mouseEvent) {
        sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.validation.MyForm f = new MyForm();
        boolean a =f.ID_Validatio(Cid.getText());
        boolean b = f.NAME_Validation(Cname.getText());
        boolean c = f.NAME_Validation(Cdis.getText());
        boolean d = f.Duration_Validation(Cdu.getText());
        System.out.println(a);
        if(Cid.getText().trim().isEmpty() || a==false){
            System.out.println("1");
            new Alert(Alert.AlertType.ERROR, "Course ID is Empty or validation error", ButtonType.OK).showAndWait();
        }else if(Cname.getText().trim().isEmpty()|| b==false){
            System.out.println("2");
            new Alert(Alert.AlertType.ERROR, "Course name is Empty", ButtonType.OK).showAndWait();
        }else if(Cdis.getText().trim().isEmpty()|| c==false){
            System.out.println("3");
            new Alert(Alert.AlertType.ERROR, "Course description is Empty", ButtonType.OK).showAndWait();
        }else if(Cdu.getText().isEmpty() || d==false){
            System.out.println("4");
            new Alert(Alert.AlertType.ERROR, "Course duration is Empty", ButtonType.OK).showAndWait();
        }else if(a && b && c && d ){//save new course
            System.out.println("5"); 
            if(CourseTable.getSelectionModel().isEmpty()){
                ObservableList<courseTB> items = CourseTable.getItems();
                for (courseTB CourseTB : items) {
                    if (CourseTB.getCid().equals(Cid.getText())) {
                        new Alert(Alert.AlertType.ERROR, "Duplicate Course IDs are not allowed").showAndWait();
                        Cid.requestFocus();
                        return;
                    }
                }
                courseTB CourseTB = new courseTB(Cid.getText(), Cname.getText(), Cdis.getText(),Cdu.getText());
                CourseTable.getItems().add(CourseTB);
                sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.courseDTO CourseDTO = new sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.courseDTO(Cid.getText(), Cname.getText(), Cdis.getText(),Cdu.getText());
                boolean result = false;
                try {
                    result = manageCourseBO.createCourse(CourseDTO);
                } catch (Exception e) {
                    Logger.getLogger("").log(Level.SEVERE, null, e);
                }

                if (result) {
                    new Alert(Alert.AlertType.INFORMATION, "Course has been saved successfully", ButtonType.OK).showAndWait();
                    CourseTable.scrollTo(CourseTB);
                } else {
                    new Alert(Alert.AlertType.ERROR, "Failed to save the Course", ButtonType.OK).showAndWait();
                }
            }else{
                courseTB selectedCourse = CourseTable.getSelectionModel().getSelectedItem();
                selectedCourse.setCname(Cname.getText());
                selectedCourse.setCdis(Cdis.getText());
                selectedCourse.setCdura(Cdu.getText());
                CourseTable.refresh();

                String selectedCourseID = CourseTable.getSelectionModel().getSelectedItem().getCid();

                boolean result = false;
                try {
                    result = manageCourseBO.updateCourse(new courseDTO(Cid.getText(),
                            Cname.getText(),
                            Cdis.getText(),
                            Cdu.getText()));
                } catch (Exception e) {
                    Logger.getLogger("").log(Level.SEVERE, null, e);
                } if (result) {
                    new Alert(Alert.AlertType.INFORMATION, "Course has been updated successfully", ButtonType.OK).showAndWait();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Failed to update the Course", ButtonType.OK).showAndWait();
                }
            }
        }
        reset();
    }

    public void DeletedRow(MouseEvent mouseEvent) {
       Alert confirmMsg = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to delete this Course?", ButtonType.YES, ButtonType.NO);
       Optional<ButtonType> buttonType = confirmMsg.showAndWait();

       if (buttonType.get() == ButtonType.YES) {
           String selectedCourse = CourseTable.getSelectionModel().getSelectedItem().getCid();

           CourseTable.getItems().remove(CourseTable.getSelectionModel().getSelectedItem());
           boolean result = false;
           try {
               result = manageCourseBO.deleteCourse(selectedCourse);
           } catch (Exception e) {
                        Logger.getLogger("").log(Level.SEVERE, null, e);
           }
           if (!result){
               new Alert(Alert.AlertType.ERROR, "Failed to delete the Course", ButtonType.OK).showAndWait();
           }else{
               reset();
           }
       }
    }
    public void loginPage(Parent dashRoot){
        Scene se = new Scene(dashRoot);
        Stage primaryStage = (Stage)courseForm.getScene().getWindow();
        primaryStage.setScene(se);
        primaryStage.show();
    }

    public void reset(){
        Cid.clear();
        Cname.clear();
        Cdis.clear();
        Cdu.clear();
    }
}
