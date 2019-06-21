package sliit.destope.dilrukshi.rajapakshe.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    public AnchorPane dashBord;

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
    }
    public void loginPage(Parent dashRoot){
        Scene se = new Scene(dashRoot);
        Stage primaryStage = (Stage)dashBord.getScene().getWindow();
        primaryStage.setScene(se);
        primaryStage.show();
    }
}
