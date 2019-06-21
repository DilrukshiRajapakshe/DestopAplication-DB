package sliit.destope.dilrukshi.rajapakshe.controller;

import ijse.dep.dilrukshi.rajapakshe.business.BOFactory;
import ijse.dep.dilrukshi.rajapakshe.business.custom.ManagePaymentBO;
import ijse.dep.dilrukshi.rajapakshe.dto.paymentDTO;
import ijse.dep.dilrukshi.rajapakshe.view.Table.paymentTB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OderDetailController {
    @FXML
    public AnchorPane oderDetail;
    @FXML
    public TableView<paymentTB> oderDetailTable;
    @FXML
    public TextField searchT;

    private  ObservableList<paymentTB> tblItems = FXCollections.observableArrayList();
    ManagePaymentBO managePaymentBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.MANAGE_PAYMENT);

    public void initialize() throws Exception {

        oderDetailTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("billID"));//
        oderDetailTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("date"));
        oderDetailTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("cuName"));
        oderDetailTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("cuTel"));
        oderDetailTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("cuAddress"));
        oderDetailTable.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("type"));
        oderDetailTable.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("tot"));
        List<paymentDTO> paymentDTODB = null;
        try{
            paymentDTODB=  managePaymentBO.getPayment();
        }catch (Exception e){
            Logger.getLogger("").log(Level.SEVERE, null, e);
        }

        ObservableList<paymentDTO> attendedDTOS = FXCollections.observableArrayList(paymentDTODB);

        for (paymentDTO att : attendedDTOS) {
            tblItems.add(new paymentTB(att.getBillID(), att.getDate(), att.getCuName(),att.getCuTel(),att.getCuAddress(),att.getType(),att.getTot()));
        }
        System.out.println(tblItems);
        oderDetailTable.setItems(tblItems);
    }



    public void DashBord(MouseEvent mouseEvent) throws IOException {
        Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/sliit/destope/dilrukshi/rajapakshe/view/Main.fxml"));
        loginPage(dashRoot);
    }

    public void StockManagement(MouseEvent mouseEvent)throws IOException {
        Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/sliit/destope/dilrukshi/rajapakshe/view/InsertStockItem.fxml"));
        loginPage(dashRoot);
    }

    public void Employee(MouseEvent mouseEvent)throws IOException {
        Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/sliit/destope/dilrukshi/rajapakshe/view/Employe.fxml"));
        loginPage(dashRoot);
    }

    public void Suppler(MouseEvent mouseEvent) throws IOException{
        Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/sliit/destope/dilrukshi/rajapakshe/view/Suppler.fxml"));
        loginPage(dashRoot);
    }

    public void Attended(MouseEvent mouseEvent)throws IOException {
        Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/sliit/destope/dilrukshi/rajapakshe/view/Attended.fxml"));
        loginPage(dashRoot);
    }

    public void OderDetails(MouseEvent mouseEvent)throws IOException {
        Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/sliit/destope/dilrukshi/rajapakshe/view/OderDetail.fxml"));
        loginPage(dashRoot);
    }

    public void Payment(MouseEvent mouseEvent)throws IOException {
        Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/sliit/destope/dilrukshi/rajapakshe/view/Payment.fxml"));
        loginPage(dashRoot);
    }

    public void Help(MouseEvent mouseEvent)throws IOException {
        Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/sliit/destope/dilrukshi/rajapakshe/view/Main.fxml"));
        loginPage(dashRoot);
    }

    public void About(MouseEvent mouseEvent) throws IOException{
        Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/sliit/destope/dilrukshi/rajapakshe/view/Main.fxml"));
        loginPage(dashRoot);
    }

    public void LogOut(MouseEvent mouseEvent)throws IOException {
        Parent dashRoot = FXMLLoader.load(this.getClass().getResource("/sliit/destope/dilrukshi/rajapakshe/view/Main.fxml"));
        loginPage(dashRoot);
    }

    public void search(KeyEvent keyEvent) {
                ObservableList<paymentTB> tempList = FXCollections.observableArrayList();
        for (paymentTB olOrder : tblItems) {
            if (olOrder.getBillID().startsWith(searchT.getText())){
                tempList.add(olOrder);
            }
        }
        oderDetailTable.setItems(tempList);
    }
    public void loginPage(Parent dashRoot){
        Scene se = new Scene(dashRoot);
        Stage primaryStage = (Stage)oderDetail.getScene().getWindow();
        primaryStage.setScene(se);
        primaryStage.show();
    }

    public void getOderDetailInformation(MouseEvent mouseEvent) throws IOException {
        if (mouseEvent.getClickCount() == 2){

            paymentTB selectedItem = oderDetailTable.getSelectionModel().getSelectedItem();
            if(selectedItem.getType()== "Stock-Payment"){
                FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/sliit/destope/dilrukshi/rajapakshe/view/ViewPaymentOF_StockItem.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                ViewPaymentOF_StockItemController controller = fxmlLoader.getController();
                controller.setInitData(selectedItem.getBillID(),selectedItem.getType());
                Scene scene = new Scene(root);
                ((Stage)oderDetailTable.getScene().getWindow()).setScene(scene);
            }else if(selectedItem.getType()== "Rent-Payment"){
                FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/sliit/destope/dilrukshi/rajapakshe/view/ViewPaymentOF_RentItem.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                ViewPaymentOF_StockItemController controller = fxmlLoader.getController();
                controller.setInitData(selectedItem.getBillID(),selectedItem.getType());
                Scene scene = new Scene(root);
                ((Stage)oderDetailTable.getScene().getWindow()).setScene(scene);
            }



        }
    }



}
