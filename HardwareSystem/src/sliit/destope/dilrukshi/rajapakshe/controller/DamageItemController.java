package sliit.destope.dilrukshi.rajapakshe.controller;

import ijse.dep.dilrukshi.rajapakshe.business.BOFactory;
import sliit.destope.dilrukshi.rajapakshe.business.custom.ManageDamageItemBO;
import ijse.dep.dilrukshi.rajapakshe.dto.damageStockDTO;
import ijse.dep.dilrukshi.rajapakshe.view.Table.damageStockTB;
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

public class DamageItemController {
    @FXML
    public AnchorPane damage;
    @FXML
    public TextField searchT;
    @FXML
    public TableView<damageStockTB> DamageTable;

    ManageDamageItemBO manageDamageItemBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.MANAGE_DAMAGE);
    private  ObservableList<damageStockTB> tblItems = FXCollections.observableArrayList();
    public void initialize() throws Exception {


            DamageTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Iid"));//
            DamageTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("Iname"));
            DamageTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("Sid"));
            DamageTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("buyPrice"));
            DamageTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("amount"));
            DamageTable.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("brand"));
            List<damageStockDTO> damageStockDB = null;
            try{
                damageStockDB=  manageDamageItemBO.getDamageItem();
            }catch (Exception e){
                Logger.getLogger("").log(Level.SEVERE, null, e);
            }

            ObservableList<damageStockDTO> damageStockDTOS = FXCollections.observableArrayList(damageStockDB);

            for (damageStockDTO att : damageStockDTOS) {
                tblItems.add(new damageStockTB(att.getIid(), att.getIname(), att.getSid(),att.getBuyPrice(),att.getAmount(),att.getBrand()));
            }
            System.out.println(tblItems);
            DamageTable.setItems(tblItems);
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
                    String selectItemID = DamageTable.getSelectionModel().getSelectedItem().getIid();

                    DamageTable.getItems().remove(DamageTable.getSelectionModel().getSelectedItem());
                    boolean result = false ;
                    try{
                        result = manageDamageItemBO.deleteDamageItem(selectItemID);
                    }catch (Exception e){
                        Logger.getLogger("").log(Level.SEVERE, null, e);
                    }
                    if (!result){
                        new Alert(Alert.AlertType.ERROR, "Failed to delete Damage Item details", ButtonType.OK).showAndWait();
                    }else{
                        new Alert(Alert.AlertType.ERROR, "Delete Damage Item details", ButtonType.OK).showAndWait();

                    }
                }
    }

    public void search(KeyEvent keyEvent) {
        ObservableList<damageStockTB> tempList = FXCollections.observableArrayList();
                        for (damageStockTB olOrder : tblItems) {
                            if (olOrder.getIname().startsWith(searchT.getText())){
                                tempList.add(olOrder);
                            }
                        }
        DamageTable.setItems(tempList);
    }

    public void loginPage(Parent dashRoot){
        Scene se = new Scene(dashRoot);
        Stage primaryStage = (Stage)damage.getScene().getWindow();
        primaryStage.setScene(se);
        primaryStage.show();
    }

    public void getDamageItemInformation(MouseEvent mouseEvent) throws IOException {
        if (mouseEvent.getClickCount() == 2){
            damageStockTB selectedItem = DamageTable.getSelectionModel().getSelectedItem();
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/sliit/destope/dilrukshi/rajapakshe/view/DamageStockUpdate.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            DamageStockUpdateController controller = fxmlLoader.getController();
            controller.setInitData(selectedItem.getIid());
            Scene scene = new Scene(root);
            ((Stage)DamageTable.getScene().getWindow()).setScene(scene);
        }
    }
}
