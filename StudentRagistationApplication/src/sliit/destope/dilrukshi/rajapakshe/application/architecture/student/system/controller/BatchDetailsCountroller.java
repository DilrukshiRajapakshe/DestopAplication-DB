package sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.controller;

import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.BOFactory;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.validation.MyForm;
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
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.business.custom.ManageBatchBO;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.batchDTO;
import sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.view.frametable.batchTB;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BatchDetailsCountroller {

    @FXML
    public AnchorPane BatchForm;
    @FXML
    public TextField Cid;
    @FXML
    public TextField Cname;
    @FXML
    public TextField Cdis;
    @FXML
    public TextField Sdate;
    @FXML
    public TextField amount;
    @FXML
    public TableView<sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.view.frametable.batchTB> BatchTable;

    private ManageBatchBO manageBatchBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.MANAGE_BATCH);


    public void initialize() {
            BatchTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Bid"));
            BatchTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Cid"));
            BatchTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Sdate"));
            BatchTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Bdisc"));
            BatchTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("Samount"));

            List<sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.batchDTO> BatchDB = null;
            try {
                BatchDB = manageBatchBO.getBatch();
            } catch (Exception e) {
               Logger.getLogger("").log(Level.SEVERE,null,e);
            }
            ObservableList<sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.batchDTO> BatchDTOS = FXCollections.observableArrayList(BatchDB);
            ObservableList<sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.view.frametable.batchTB> tblItems = FXCollections.observableArrayList();
            for (sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.batchDTO BatchDTO : BatchDTOS) {
                tblItems.add(new sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.view.frametable.batchTB(BatchDTO.getBid(), BatchDTO.getCid(), BatchDTO.getSdate(),BatchDTO.getBdisc(),BatchDTO.getSamount()));
            }
            BatchTable.setItems(tblItems);

            BatchTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.view.frametable.batchTB>() {
                @Override
                public void changed(ObservableValue<? extends sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.view.frametable.batchTB> observable, sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.view.frametable.batchTB oldValue, sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.view.frametable.batchTB selectedBatch) {

                    if (selectedBatch == null) {
                        // Clear Selection
                        return;
                    }

                    Cid.setText(selectedBatch.getBid());
                    Cname.setText(selectedBatch.getCid());
                    Sdate.setText(selectedBatch.getSdate());
                    Cdis.setText(selectedBatch.getBdisc());
                    amount.setText(String.valueOf(selectedBatch.getSamount()));

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
        MyForm f = new MyForm();
        boolean a =f.ID_Validatio(Cid.getText());
        boolean b = f.ID_Validatio(Cname.getText());
        boolean d = f.NAME_Validation(Cdis.getText());
        boolean g = f.Amount_Validation(amount.getText());
        System.out.println(a);
        if(Cid.getText().trim().isEmpty() || a==false){
            System.out.println("1");
            new Alert(Alert.AlertType.ERROR, "Batch ID is Empty or validation error", ButtonType.OK).showAndWait();
        }else if(Cname.getText().trim().isEmpty()|| b==false){
            System.out.println("2");
            new Alert(Alert.AlertType.ERROR, "Course ID is Empty", ButtonType.OK).showAndWait();
        }else if(Cdis.getText().trim().isEmpty() || d==false){
            System.out.println("3");
            new Alert(Alert.AlertType.ERROR, "Batch description is Empty", ButtonType.OK).showAndWait();
        }else if(Sdate.getText().isEmpty()){
            System.out.println("4");
            new Alert(Alert.AlertType.ERROR, "Start date is empty", ButtonType.OK).showAndWait();
        }else if(amount.getText().isEmpty() || g==false){
            System.out.println("5");
            new Alert(Alert.AlertType.ERROR, "Capacity of Batch is Empty", ButtonType.OK).showAndWait();
        }else if(a && b  && d && g){//save new course
            System.out.println("6");
            if(BatchTable.getSelectionModel().isEmpty()){
                ObservableList<sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.view.frametable.batchTB> items = BatchTable.getItems();
                for (sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.view.frametable.batchTB BatchTB : items) {
                    if (BatchTB.getBid().equals(Cid.getText())) {
                        new Alert(Alert.AlertType.ERROR, "Duplicate Batch IDs are not allowed").showAndWait();
                        Cid.requestFocus();
                        return;
                    }
                }
                sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.view.frametable.batchTB BatchTB = new sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.view.frametable.batchTB(Cid.getText(), Cname.getText(),Sdate.getText(),Cdis.getText(),Integer.parseInt(amount.getText()));
                BatchTable.getItems().add(BatchTB);
                sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.batchDTO BatchDTO = new sliit.destope.dilrukshi.rajapakshe.application.architecture.student.system.dto.batchDTO(Cid.getText(), Cname.getText(), Sdate.getText(),Cdis.getText(),Integer.parseInt(amount.getText()));
                boolean result = false;
                try {
                    result = manageBatchBO.createBatch(BatchDTO);
                } catch (Exception e) {
                    Logger.getLogger("").log(Level.SEVERE, null, e);
                }

                if (result) {
                    new Alert(Alert.AlertType.INFORMATION, "Batch has been saved successfully", ButtonType.OK).showAndWait();
                    BatchTable.scrollTo(BatchTB);
                } else {
                    new Alert(Alert.AlertType.ERROR, "Failed to save the Batch", ButtonType.OK).showAndWait();
                }
            }else{
                batchTB selectedBatch = BatchTable.getSelectionModel().getSelectedItem();
                selectedBatch.setCid(Cname.getText());
                selectedBatch.setSdate(Sdate.getText());//
                selectedBatch.setBdisc(Cdis.getText());
                selectedBatch.setSamount(Integer.parseInt(amount.getText()));
                BatchTable.refresh();

                String selectedBatchID = BatchTable.getSelectionModel().getSelectedItem().getCid();

                boolean result = false;
                try {
                    result = manageBatchBO.updateBatch(new batchDTO(Cid.getText(),
                            Cname.getText(),
                            Sdate.getText(),
                            Cdis.getText(),
                            Integer.parseInt(amount.getText())));
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
        Alert confirmMsg = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to delete this Batch?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = confirmMsg.showAndWait();

        if (buttonType.get() == ButtonType.YES) {
            String selectedBatch = BatchTable.getSelectionModel().getSelectedItem().getBid();

            BatchTable.getItems().remove(BatchTable.getSelectionModel().getSelectedItem());
            boolean result = false;
            try {
                result = manageBatchBO.deleteBatch(selectedBatch);
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

    public void loginPage(Parent dashRoot){
        Scene se = new Scene(dashRoot);
        Stage primaryStage = (Stage)BatchForm.getScene().getWindow();
        primaryStage.setScene(se);
        primaryStage.show();
    }

    public void reset(){
        Cid.clear();
        Cname.clear();
        Cdis.clear();
        Sdate.clear();
        amount.clear();
    }
}
