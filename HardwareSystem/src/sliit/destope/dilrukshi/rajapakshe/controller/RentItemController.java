package sliit.destope.dilrukshi.rajapakshe.controller;

import ijse.dep.dilrukshi.rajapakshe.business.BOFactory;
import sliit.destope.dilrukshi.rajapakshe.business.custom.ManageRentItemBO;
import ijse.dep.dilrukshi.rajapakshe.dto.rentStockDTO;
import ijse.dep.dilrukshi.rajapakshe.view.Table.rentStockTB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RentItemController {
    @FXML
    public AnchorPane RentItem;
    @FXML
    public TextField searchT;
    @FXML
    public TableView<rentStockTB> rentTable;

    private  ObservableList<rentStockTB> tblItems = FXCollections.observableArrayList();

    ManageRentItemBO manageRentItemBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.MANAGE_RENT_ITEM);

    public void initialize() throws Exception {


        rentTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Iid"));//
        rentTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Iname"));
        rentTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Sid"));
        rentTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("buyPrice"));
        rentTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("discount"));
        rentTable.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("amount"));
        rentTable.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("brand"));
        rentTable.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("rentPrice"));
        List<rentStockDTO> damageStockDB = null;
        try{
            damageStockDB=  manageRentItemBO.getRentItem();
        }catch (Exception e){
            Logger.getLogger("").log(Level.SEVERE, null, e);
        }

        ObservableList<rentStockDTO> damageStockDTOS = FXCollections.observableArrayList(damageStockDB);

        for (rentStockDTO p : damageStockDTOS) {
            tblItems.add(new rentStockTB(p.getIid(), p.getIname(),p.getSid(),p.getBuyPrice(),p.getDiscount(), p.getAmount(),p.getBrand() ,p.getRentPrice()));
        }
        System.out.println(tblItems);
        rentTable.setItems(tblItems);
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

    public void delete(ActionEvent actionEvent) {
        Alert confirmMsg = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this Damage Item Details?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = confirmMsg.showAndWait();
        if (buttonType.get() == ButtonType.YES) {
            String selectItemID = rentTable.getSelectionModel().getSelectedItem().getIid();

            rentTable.getItems().remove(rentTable.getSelectionModel().getSelectedItem());
            boolean result = false ;
            try{
                result = manageRentItemBO.deleteRentItem(selectItemID);
            }catch (Exception e){
                Logger.getLogger("").log(Level.SEVERE, null, e);
            }
            if (!result){
                new Alert(Alert.AlertType.ERROR, "Failed to delete Rent Item details", ButtonType.OK).showAndWait();
            }else{
                new Alert(Alert.AlertType.ERROR, "Delete Rent Item details", ButtonType.OK).showAndWait();

            }
        }
    }

    public void search(KeyEvent keyEvent) {
        ObservableList<rentStockTB> tempList = FXCollections.observableArrayList();
        for (rentStockTB olOrder : tblItems) {
            if (olOrder.getIname().startsWith(searchT.getText())){
                tempList.add(olOrder);
            }
        }
        rentTable.setItems(tempList);
    }
    public void loginPage(Parent dashRoot){
        Scene se = new Scene(dashRoot);
        Stage primaryStage = (Stage)RentItem.getScene().getWindow();
        primaryStage.setScene(se);
        primaryStage.show();
    }

    public void getRentItemInformation(MouseEvent mouseEvent) throws IOException {

        if (mouseEvent.getClickCount() == 2){
            rentStockTB selectedItem = rentTable.getSelectionModel().getSelectedItem();
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/sliit/destope/dilrukshi/rajapakshe/view/RentItemUpdate.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            RentItemUpdateController controller = fxmlLoader.getController();
            controller.setInitData(selectedItem.getIid());
            Scene scene = new Scene(root);
            ((Stage)rentTable.getScene().getWindow()).setScene(scene);
        }

    }
}
