package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.controller;

import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.BOFactory;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.custom.ManageQualificationBO;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.view.frametable.qulificationTB;
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
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.qulificationDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegisterQualificationCountroller {
    @FXML
    public AnchorPane EducationFrom;
    @FXML
    public TextField Sid;
    @FXML
    public TextField filed;
    @FXML
    public TextField year;
    @FXML
    public TextField quli;
    @FXML
    public TextField ins;
    @FXML
    public TextField any;
    @FXML
    private TableView<qulificationTB> eductionDetailsTable;
    static ArrayList<qulificationTB> list = new ArrayList<>();
private ManageQualificationBO manageQualificationBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.MANAGE_QUALIFICATION);

    public void initialize() throws SQLException, ClassNotFoundException {

        eductionDetailsTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Sid"));
        eductionDetailsTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Filed"));
        eductionDetailsTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("year"));
        eductionDetailsTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("result"));
        eductionDetailsTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("institiute"));
        eductionDetailsTable.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("any"));
        ObservableList<qulificationTB> items= FXCollections.observableArrayList(list);
        eductionDetailsTable.setItems(items);
        eductionDetailsTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<qulificationTB>() {
            @Override
            public void changed(ObservableValue<? extends qulificationTB> observable, qulificationTB oldValue, qulificationTB selectedBatch) {

                if (selectedBatch == null) {
                    // Clear Selection
                    return;
                }

                Sid.setText(selectedBatch.getSid());
                filed.setText(selectedBatch.getFiled());
                year.setText(selectedBatch.getYear());
                quli.setText(selectedBatch.getResult());
                ins.setText(selectedBatch.getInstitiute());
                any.setText(selectedBatch.getAny());

                Sid.setEditable(false);

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

    public void SaveANDUpdate(MouseEvent mouseEvent) throws IOException {
        if(filed.getText().trim().isEmpty()){
            System.out.println("1");
        }else if(year.getText().trim().isEmpty()){
            System.out.println("2");
        }else if(quli.getText().trim().isEmpty()){
            System.out.println("3");
        }else if(ins.getText().trim().isEmpty()){
            System.out.println("4");
        }else if(any.getText().trim().isEmpty()){
            System.out.println("5");
        }else{
            String sid = Sid.getText();
            String fil = filed.getText();
            String ye = year.getText();
            String qu = quli.getText();
            String an = any.getText();
            String in = ins.getText();
            qulificationTB hq = new qulificationTB(sid,fil,ye,qu,in,an);
            list.add(hq);
            System.out.println(list);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Do you want Exit");
            alert.setContentText("Then press Ok?");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.get() == ButtonType.OK){
                Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/sliit/destope/dilrukshi/rajapakshe/application/architecture/student/system/view/frame/RegisterCourseForm.fxml"));
                loginPage(dashRoot);
            }
            else{
                Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/sliit/destope/dilrukshi/rajapakshe/application/architecture/student/system/view/frame/QualificationForm.fxml"));
                loginPage(dashRoot);
            }
        }

    }

    public void DeletedDetils(MouseEvent mouseEvent) {
        Alert confirmMsg = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to delete this Batch?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = confirmMsg.showAndWait();

        if (buttonType.get() == ButtonType.YES) {
            String selectedBatch = eductionDetailsTable.getSelectionModel().getSelectedItem().getSid();

            eductionDetailsTable.getItems().remove(eductionDetailsTable.getSelectionModel().getSelectedItem());
            boolean result = false;
            try {
                result = manageQualificationBO.deleteQualification(selectedBatch);
            } catch (Exception e) {
                Logger.getLogger("").log(Level.SEVERE, null, e);
            }
            if (!result){
                new Alert(Alert.AlertType.ERROR, "Failed to delete the Batch", ButtonType.OK).showAndWait();
            }else{
                reset();
            }
        }
    }

    public void UpdatedDetailed(MouseEvent mouseEvent) {
        qulificationTB selectedBatch = eductionDetailsTable.getSelectionModel().getSelectedItem();

        selectedBatch.setFiled(filed.getText());//
        selectedBatch.setYear(year.getText());
        selectedBatch.setResult(quli.getText());
        selectedBatch.setInstitiute(ins.getText());
        selectedBatch.setAny(any.getText());
        eductionDetailsTable.refresh();

        String selectedBatchID = eductionDetailsTable.getSelectionModel().getSelectedItem().getSid();

        boolean result = false;
        try {
            result = manageQualificationBO.updateQualification(new qulificationDTO(filed.getText(),
                    year.getText(),
                    quli.getText(),
                    ins.getText(),
                    any.getText(),
                    Sid.getText()
                    ));
        } catch (Exception e) {
            Logger.getLogger("").log(Level.SEVERE, null, e);
        } if (result) {
            new Alert(Alert.AlertType.INFORMATION, "Course has been updated successfully", ButtonType.OK).showAndWait();
        } else {
            new Alert(Alert.AlertType.ERROR, "Failed to update the Course", ButtonType.OK).showAndWait();
        }
    }

    public void loginPage(Parent dashRoot){

        Scene se = new Scene(dashRoot);
        Stage primaryStage = (Stage)EducationFrom.getScene().getWindow();
        primaryStage.setScene(se);
        primaryStage.show();
    }

    public void reset(){

        filed.clear();
        year.clear();
        quli.clear();
        any.clear();
        ins.clear();
    }
}
