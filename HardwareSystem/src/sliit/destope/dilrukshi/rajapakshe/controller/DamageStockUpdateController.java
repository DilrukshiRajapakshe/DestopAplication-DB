package sliit.destope.dilrukshi.rajapakshe.controller;

import ijse.dep.dilrukshi.rajapakshe.business.BOFactory;
import sliit.destope.dilrukshi.rajapakshe.business.custom.ManageDamageItemBO;
import ijse.dep.dilrukshi.rajapakshe.dto.damageStockDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DamageStockUpdateController {
    @FXML
    public AnchorPane damageStockUpdate;

    private  String ItemID;

    @FXML
    public TextField itemeID;
    @FXML
    public TextField itemName;
    @FXML
    public TextField supplyerID;
    @FXML
    public TextField buyPrice;
    @FXML
    public TextField amount;
    @FXML
    public TextField brand;

    ManageDamageItemBO manageDamageItemBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.MANAGE_DAMAGE);

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


    public void update(ActionEvent actionEvent) {
        //itemeID,itemName,supplyerID,buyPrice,amount,brand
        boolean result = false;
        try{
            result = manageDamageItemBO.updateDamageItem(new damageStockDTO(itemeID.getText(),itemName.getText(),
                    supplyerID.getText(),Double.parseDouble(buyPrice.getText()),Integer.parseInt(amount.getText()),brand.getText()));
        }catch (Exception e){
            Logger.getLogger("").log(Level.SEVERE, null, e);
        }

        if (result) {
            new Alert(Alert.AlertType.INFORMATION, "Damage Item details has been update successfully", ButtonType.OK).showAndWait();

        } else {
            new Alert(Alert.AlertType.ERROR, "Failed to update the Damage Item details", ButtonType.OK).showAndWait();
        }

    }

    public void loginPage(Parent dashRoot){
        Scene se = new Scene(dashRoot);
        Stage primaryStage = (Stage)damageStockUpdate.getScene().getWindow();
        primaryStage.setScene(se);
        primaryStage.show();
    }


    public void setInitData(String iid) {
        this.ItemID=iid;
        find_AND_seData_TextFiled();
    }

    public void find_AND_seData_TextFiled(){
        try {
            damageStockDTO damageItem = manageDamageItemBO.findDamageItem(this.ItemID);
            itemeID.setText(damageItem.getIid());
            itemName.setText(damageItem.getIname());
            supplyerID.setText(damageItem.getSid());
            buyPrice.setText(String.valueOf(damageItem.getBuyPrice()));
            amount.setText(String.valueOf(damageItem.getAmount()));
            brand.setText(damageItem.getBrand());

        } catch (Exception e) {
            Logger.getLogger("").log(Level.SEVERE, null, e);
        }
    }
}
