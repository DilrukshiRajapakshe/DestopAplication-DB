package sliit.destope.dilrukshi.rajapakshe.controller;

import ijse.dep.dilrukshi.rajapakshe.business.BOFactory;
import sliit.destope.dilrukshi.rajapakshe.business.custom.ManageSupplerBO;
import sliit.destope.dilrukshi.rajapakshe.dto.supplerDTO;
import ijse.dep.dilrukshi.rajapakshe.view.Table.supplerTB;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SupplerController {
    @FXML
    public TextField supplerID;
    @FXML
    public AnchorPane suppler;
    @FXML
    public TextField fname;
    @FXML
    public TextField post;
    @FXML
    public TextField city;
    @FXML
    public TextField address;
    @FXML
    public TextField Semail;
    @FXML
    public TextField Mtel;
    @FXML
    public TextField Cname;
    @FXML
    public TextField Cemail;
    @FXML
    public TextField Ctel;
    @FXML
    public TableView<supplerTB> supplerTable;
    @FXML
    public TextField searchT;
    @FXML
    public ComboBox titel;
    private  ObservableList<supplerTB> tblItems = FXCollections.observableArrayList();
    ManageSupplerBO manageSupplerBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.MANAGE_SUPPLER);

    public void initialize() throws Exception {
        comboList();
        supplerTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("Sid"));//
        supplerTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("fullName"));
        supplerTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("position"));
        supplerTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("postCord"));
        supplerTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("address"));//
        supplerTable.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("city"));
        supplerTable.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("email"));
        supplerTable.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("Mtel"));
        supplerTable.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("Cname"));
        supplerTable.getColumns().get(9).setCellValueFactory(new PropertyValueFactory<>("cEmail"));
        supplerTable.getColumns().get(10).setCellValueFactory(new PropertyValueFactory<>("cTel"));
        List<supplerDTO> EmployeeDB = null;
        try{
            EmployeeDB =  manageSupplerBO.getSuppler();
        }catch (Exception e){
            Logger.getLogger("").log(Level.SEVERE, null, e);
        }

        ObservableList<supplerDTO> employeeDTOS = FXCollections.observableArrayList(EmployeeDB);

        for (supplerDTO e : employeeDTOS) {
            tblItems.add(new supplerTB(e.getSid(),e.getFullName(),e.getPosition(),e.getPostCord(),e.getAddress(),
                    e.getCity(),e.getEmail(),e.getMtel(),e.getCname(),e.getCEmail(),e.getCTel()));
        }
        System.out.println(tblItems);
        supplerTable.setItems(tblItems);

        supplerTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<supplerTB>() {
            @Override
            public void changed(ObservableValue<? extends supplerTB> observable, supplerTB oldValue, supplerTB s) {

                if (s == null) {
                    // Clear Selection
                    return;
                }

                supplerID.setText(s.getSid());
                fname.setText(s.getFullName());
                titel.setValue(s.getPosition());
                post.setText(s.getPostCord());
                address.setText(s.getAddress());
                city.setText(s.getCity());
                Semail.setText(s.getEmail());
                Mtel.setText(String.valueOf(s.getMtel()));
                Cname.setText(s.getCname());
                Cemail.setText(s.getCEmail());
                Ctel.setText(String.valueOf(s.getCTel()));
            }
        });
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
    //supplerID,
    public void save(ActionEvent actionEvent) {
        if(supplerID.getText().trim().isEmpty() || fname.getText().trim().isEmpty() ||post.getText().trim().isEmpty() ||address.getText().trim().isEmpty() ||
                city.getText().trim().isEmpty() ||Semail.getText().trim().isEmpty() ||Mtel.getText().trim().isEmpty() ||Cname.getText().trim().isEmpty() ||
                Cemail.getText().trim().isEmpty() ||Ctel.getText().trim().isEmpty() ){
            new Alert(Alert.AlertType.INFORMATION, "Text filed are empty", ButtonType.OK).showAndWait();
            return;
        }else{

               ObservableList<supplerTB> emp =supplerTable.getItems();
               for(supplerTB att : emp){
                   if( att.getSid().equals(supplerID)){
                       System.out.println("NIC is Duplicate");
                       new Alert(Alert.AlertType.ERROR, "Detail is Duplicate", ButtonType.OK).showAndWait();
                       supplerID.requestFocus();
                       return;
                   }
               }


               supplerTB sup = new supplerTB(supplerID.getText(),fname.getText(),String.valueOf(titel.getValue()),post.getText(),
                       address.getText(),city.getText(),Semail.getText(),Integer.parseInt(Mtel.getText()),Cname.getText(),
                       Cemail.getText(),Integer.parseInt(Ctel.getText()));
               supplerTable.getItems().add(sup);
               supplerDTO eDTO = new supplerDTO(supplerID.getText(),fname.getText(),String.valueOf(titel.getValue()),post.getText(),
                       address.getText(),city.getText(),Semail.getText(),Integer.parseInt(Mtel.getText()),Cname.getText(),
                       Cemail.getText(),Integer.parseInt(Ctel.getText()));

               boolean result = false;

               try{
                   result = manageSupplerBO.createSuppler(eDTO);


               }catch (Exception e){
                   Logger.getLogger("").log(Level.SEVERE, null, e);
               }

               if (result) {
                   new Alert(Alert.AlertType.INFORMATION, "Suppler details has been saved successfully", ButtonType.OK).showAndWait();

                   supplerTable.scrollTo(sup);
               } else {
                   new Alert(Alert.AlertType.ERROR, "Failed to save the Suppler details", ButtonType.OK).showAndWait();
               }
        }
    }

    public void update(ActionEvent actionEvent) {
        supplerTB select_Emp = supplerTable.getSelectionModel().getSelectedItem();
                select_Emp.setFullName(fname.getText());
                select_Emp.setPosition(String.valueOf(titel.getValue()));
                select_Emp.setPostCord(post.getText());
                select_Emp.setAddress(address.getText());
                select_Emp.setCity(city.getText());
                select_Emp.setEmail(Cemail.getText());
                select_Emp.setMtel(Integer.parseInt(Mtel.getText()));
                select_Emp.setCname(Cname.getText());
                select_Emp.setMtel(Integer.parseInt(Mtel.getText()));
                select_Emp.setCname(Cemail.getText());
                select_Emp.setCname(Ctel.getText());
                boolean result = false;
                try{
                    result = manageSupplerBO.updateSuppler(new supplerDTO(supplerID.getText(),fname.getText(),String.valueOf(titel.getValue()),post.getText(),
                            address.getText(),city.getText(),Semail.getText(),Integer.parseInt(Mtel.getText()),Cname.getText(),
                            Cemail.getText(),Integer.parseInt(Ctel.getText())));
                }catch (Exception e){
                    Logger.getLogger("").log(Level.SEVERE, null, e);
                }

                if (result) {
                    new Alert(Alert.AlertType.INFORMATION, "Suppler details has been update successfully", ButtonType.OK).showAndWait();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Failed to update the Suppler details", ButtonType.OK).showAndWait();
                }
    }

    public void delete(ActionEvent actionEvent) {
        Alert confirmMsg = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this Employee Attended Details?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = confirmMsg.showAndWait();
        if (buttonType.get() == ButtonType.YES) {
            String selectTDate = supplerTable.getSelectionModel().getSelectedItem().getSid();
            supplerTable.getItems().remove(supplerTable.getSelectionModel().getSelectedItem());
            boolean result = false ;
            try{
                manageSupplerBO.deleteSuppler(selectTDate);

            }catch (Exception e){
                Logger.getLogger("").log(Level.SEVERE, null, e);
            }
            if (!result){
                new Alert(Alert.AlertType.ERROR, "Failed to delete the suppler details", ButtonType.OK).showAndWait();
            }else{
                new Alert(Alert.AlertType.ERROR, "Delete the suppler details", ButtonType.OK).showAndWait();

            }
        }
    }

    public void search(KeyEvent keyEvent) {
        ObservableList<supplerTB> tempList = FXCollections.observableArrayList();
        for (supplerTB emp : tblItems) {
            if (emp.getFullName().startsWith(searchT.getText())){
                tempList.add(emp);
            }
        }
        supplerTable.setItems(tempList);
    }
    public void loginPage(Parent dashRoot){
        Scene se = new Scene(dashRoot);
        Stage primaryStage = (Stage)suppler.getScene().getWindow();
        primaryStage.setScene(se);
        primaryStage.show();
    }

    public void comboList(){
        titel.getItems().add("Manager");
        titel.getItems().add("Employee");
        titel.getItems().add("Owner");
        titel.getItems().add("Secretary");
    }
}
