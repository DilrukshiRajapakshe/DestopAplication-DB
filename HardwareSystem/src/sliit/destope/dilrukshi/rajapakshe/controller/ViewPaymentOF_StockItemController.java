package sliit.destope.dilrukshi.rajapakshe.controller;

import ijse.dep.dilrukshi.rajapakshe.business.BOFactory;
import ijse.dep.dilrukshi.rajapakshe.business.custom.*;
import ijse.dep.dilrukshi.rajapakshe.dto.paymentRentDTO;
import ijse.dep.dilrukshi.rajapakshe.dto.paymentStockDTO;
import ijse.dep.dilrukshi.rajapakshe.dto.rentPaymentDTO;
import ijse.dep.dilrukshi.rajapakshe.dto.stockPaymentDTO;
import sliit.destope.dilrukshi.rajapakshe.business.custom.ManageRentOrderBO;
import sliit.destope.dilrukshi.rajapakshe.view.Table.paymentRentStockTB;
import sliit.destope.dilrukshi.rajapakshe.view.Table.paymentStockTB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewPaymentOF_StockItemController {
    @FXML
    public TextField oderID;
    @FXML
    public TextField date;
    @FXML
    public TextField address;
    @FXML
    public TextField type;
    @FXML
    public TextField cuName;
    @FXML
    public AnchorPane ViewOder;
    @FXML
    public TextField cutel;
    @FXML
    public TableView<paymentStockTB> paymenttable;
    @FXML
    public TableView<paymentRentStockTB> paymenttable1;


    public void initialize() throws Exception {
                    paymenttable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Iid"));//
                    paymenttable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Iname"));
                    paymenttable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));
                    paymenttable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("discount"));
                    paymenttable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("sellQty"));
                    paymenttable.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("brand"));
                    paymenttable.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("total"));

                    paymenttable1.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Iid"));//
                    paymenttable1.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Iname"));
                    paymenttable1.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("rentPrice"));
                    paymenttable1.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("discount"));
                    paymenttable1.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("sellQty"));
                    paymenttable1.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("rentDate"));
                    paymenttable1.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("total"));


        }

    ManagePaymentBO managePaymentBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.MANAGE_PAYMENT);
    ManageRentOrderBO manageRentOrderBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.MANAGE_RENR_ODER);
    ManageStockOrderBO manageStockOrderBO=BOFactory.getInstance().getBO(BOFactory.BOTypes.MANAGE_STOCK_ODER);



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

    public void loginPage(Parent dashRoot){
        Scene se = new Scene(dashRoot);
        Stage primaryStage = (Stage)ViewOder.getScene().getWindow();
        primaryStage.setScene(se);
        primaryStage.show();
    }

    public void setInitData(String billID, String type) {
        if(type == "Rent-Payment"){
            getStockItemData( billID);
        }if(type == "Stock-Payment"){
            getRentItemData( billID);
        }

    }
    //billID,date,address,type,cuName,cutel
    public void getRentItemData(String billID){
        try {
            rentPaymentDTO order = manageRentOrderBO.findOrder(billID);
            oderID.setText(order.getBillID());
            date.setText(order.getDate());
            address.setText(order.getCuAddress());
            type.setText(order.getType());
            cuName.setText(order.getCuName());
            cutel.setText(String.valueOf(order.getCuTel()));
            List<paymentRentDTO> pdto = order.getPaymentRentDTO();
            ObservableList<paymentRentStockTB> details = FXCollections.observableArrayList();
            for (paymentRentDTO p : pdto) {
                            details.add(new paymentRentStockTB(
                                    p.getIid(),
                                    p.getIname(),
                                    p.getRentPrice(),
                                    p.getDiscount(),
                                    p.getSellQty() ,
                                    p.getRentDate(),
                                    (p.getRentPrice()*p.getSellQty()*p.getRentDate())-p.getDiscount()
                                    ));
                        }
                        paymenttable1.setItems(details);
        } catch (Exception e) {
            Logger.getLogger("").log(Level.SEVERE, null, e);
        }

    }

    public void getStockItemData(String billID){
        try {
            stockPaymentDTO o = manageStockOrderBO.findOrder(billID);
            oderID.setText(o.getBillID());
            date.setText(o.getDate());
            address.setText(o.getCuAddress());
            type.setText(o.getType());
            cuName.setText(o.getCuName());
            cutel.setText(String.valueOf(o.getCuTel()));
            List<paymentStockDTO> pdto = o.getPaymentStockDTO();
            ObservableList<paymentStockTB> details = FXCollections.observableArrayList();
            for (paymentStockDTO p : pdto) {
                details.add(new paymentStockTB(
                        p.getIid(),
                        p.getIname(),
                        p.getSellingPrice(),
                        p.getDiscount(),
                        p.getSellingQty() ,
                        p.getBrand(),
                        (p.getSellingPrice()*p.getSellingQty())-p.getDiscount()
                ));
            }
            paymenttable.setItems(details);
        } catch (Exception e) {
            Logger.getLogger("").log(Level.SEVERE, null, e);
        }
    }
}
