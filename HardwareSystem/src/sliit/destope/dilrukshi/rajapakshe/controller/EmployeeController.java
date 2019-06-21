package sliit.destope.dilrukshi.rajapakshe.controller;

import ijse.dep.dilrukshi.rajapakshe.business.BOFactory;
import sliit.destope.dilrukshi.rajapakshe.business.custom.ManageEmployeeBO;
import sliit.destope.dilrukshi.rajapakshe.business.custom.ManageLoginBO;
import ijse.dep.dilrukshi.rajapakshe.dto.employeeDTO;
import ijse.dep.dilrukshi.rajapakshe.dto.loginDTO;
import ijse.dep.dilrukshi.rajapakshe.view.Table.employeeTB;
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
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeController {
    @FXML
    public AnchorPane employee;
    @FXML
    public TextField nic;
    @FXML
    public TextField fname;
    @FXML
    public TextField post;
    @FXML
    public TextField city;
    @FXML
    public TextField address;
    @FXML
    public DatePicker birth;
    @FXML
    public TextField email;
    @FXML
    public TextField password;
    @FXML
    public TextField myel;
    @FXML
    public TextField ltel;
    @FXML
    public TableView<employeeTB> employeeTable;
    @FXML
    public TextField searchT;
    @FXML
    public ComboBox titel;

    private  ObservableList<employeeTB> tblItems = FXCollections.observableArrayList();
    ManageEmployeeBO manageEmployeeBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.MANAGE_EMPLOYEE);
    ManageLoginBO manageLoginBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.MANAGE_LOGIN);

    public void initialize() throws Exception {
        comboList();
            employeeTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("nic"));//
            employeeTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
            employeeTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("title"));
            employeeTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("postCord"));
            employeeTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("address"));//
            employeeTable.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("city"));
            employeeTable.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("birthday"));
            employeeTable.getColumns().get(7).setCellValueFactory(new PropertyValueFactory<>("Mtel"));
            employeeTable.getColumns().get(8).setCellValueFactory(new PropertyValueFactory<>("Ltel"));
            List<employeeDTO> EmployeeDB = null;
            try{
                EmployeeDB =  manageEmployeeBO.getEmployee();
            }catch (Exception e){
                Logger.getLogger("").log(Level.SEVERE, null, e);
            }

            ObservableList<employeeDTO> employeeDTOS = FXCollections.observableArrayList(EmployeeDB);

            for (employeeDTO e : employeeDTOS) {
                tblItems.add(new employeeTB(e.getNic(),e.getName(),e.getTitle(),e.getPostCord(),e.getAddress(),e.getCity(),e.getBirthday(),e.getMtel(),e.getLtel()));
            }
            System.out.println(tblItems);
            employeeTable.setItems(tblItems);

        employeeTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<employeeTB>() {
            @Override
            public void changed(ObservableValue<? extends employeeTB> observable, employeeTB oldValue, employeeTB s) {

                if (s == null) {
                    // Clear Selection
                    return;
                }

                nic.setText(s.getNic());
                fname.setText(s.getName());
                titel.setValue(s.getTitle());
                post.setText(s.getPostCord());
                address.setText(s.getAddress());
                city.setText(s.getCity());
                birth.setValue(LocalDate.parse(s.getBirthday()));
                myel.setText(String.valueOf(s.getMtel()));
                ltel.setText(String.valueOf(s.getLtel()));
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

    public void save(ActionEvent actionEvent) {

        String bod = String.valueOf(birth.getValue());
        String Titalpost = String.valueOf(titel.getValue());

        if(nic.getText().trim().isEmpty() || fname.getText().trim().isEmpty() || post.getText().trim().isEmpty() ||
                city.getText().trim().isEmpty() || address.getText().trim().isEmpty() || email.getText().trim().isEmpty() ||
                password.getText().trim().isEmpty() || myel.getText().trim().isEmpty() || ltel.getText().trim().isEmpty() ||
                bod == null || Titalpost == null){
            System.out.println("Text filed are empty");
            new Alert(Alert.AlertType.INFORMATION, "Text filed are empty", ButtonType.OK).showAndWait();
            return;
        }else{
               ObservableList<employeeTB> emp =employeeTable.getItems();
               for(employeeTB att : emp){
                   if( att.getNic().equals(nic)){
                       System.out.println("NIC is Duplicate");
                       new Alert(Alert.AlertType.ERROR, "Detail is Duplicate", ButtonType.OK).showAndWait();
                       nic.requestFocus();
                       return;
                   }
               }
               employeeTB EmployeeTB = new employeeTB(nic.getText(),fname.getText(),Titalpost,post.getText(),
                       address.getText(),city.getText(),bod,Integer.parseInt(myel.getText()),Integer.parseInt(ltel.getText()));
               employeeTable.getItems().add(EmployeeTB);
               employeeDTO eDTO = new employeeDTO(nic.getText(),fname.getText(),Titalpost,post.getText(),
                       address.getText(),city.getText(),bod,Integer.parseInt(myel.getText()),Integer.parseInt(ltel.getText()));
               loginDTO l =new loginDTO(email.getText(),password.getText(),nic.getText());
               boolean result = false;
               boolean re = false;
               try{
                   result = manageEmployeeBO.createEmployee(eDTO);
                   re = manageLoginBO.createEmployeeLogin(l);
                   //,nic,fname,post,city,address,birth,email,password,myel,ltel,searchT,titel
               }catch (Exception e){
                   Logger.getLogger("").log(Level.SEVERE, null, e);
               }

               if (result) {
                   new Alert(Alert.AlertType.INFORMATION, "Employee details has been saved successfully", ButtonType.OK).showAndWait();

                   employeeTable.scrollTo(EmployeeTB);
               } else {
                   new Alert(Alert.AlertType.ERROR, "Failed to save the Employee details", ButtonType.OK).showAndWait();
               }

            if (re) {
                new Alert(Alert.AlertType.INFORMATION, "Employee Login details has been saved successfully", ButtonType.OK).showAndWait();

                employeeTable.scrollTo(EmployeeTB);
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to save the Employee Login details", ButtonType.OK).showAndWait();
            }
        }


    }

    public void update(ActionEvent actionEvent) {
        String bod = String.valueOf(birth.getValue());
        String Titalpost = String.valueOf(titel.getValue());
        employeeTB select_Emp = employeeTable.getSelectionModel().getSelectedItem();
        select_Emp.setName(fname.getText());
        select_Emp.setTitle(Titalpost);
        select_Emp.setPostCord(post.getText());
        select_Emp.setAddress(address.getText());
        select_Emp.setCity(city.getText());
        select_Emp.setBirthday(bod);
        select_Emp.setMtel(Integer.parseInt(myel.getText()));
        select_Emp.setLtel(Integer.parseInt(ltel.getText()));
        email.setEditable(false);
        password.setEditable(false);
        employeeTable.refresh();
        boolean result = false;
        try{
            result = manageEmployeeBO.updateEmployee(new employeeDTO(nic.getText(),fname.getText(),Titalpost,post.getText(),
                    address.getText(),city.getText(),bod,Integer.parseInt(myel.getText()),Integer.parseInt(ltel.getText())));
        }catch (Exception e){
            Logger.getLogger("").log(Level.SEVERE, null, e);
        }

        if (result) {
            new Alert(Alert.AlertType.INFORMATION, "Employee details has been update successfully", ButtonType.OK).showAndWait();
        } else {
            new Alert(Alert.AlertType.ERROR, "Failed to update the Employee details", ButtonType.OK).showAndWait();
        }
    }

    public void delete(ActionEvent actionEvent) {
        Alert confirmMsg = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this Employee Attended Details?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = confirmMsg.showAndWait();
        if (buttonType.get() == ButtonType.YES) {
            String selectTDate = employeeTable.getSelectionModel().getSelectedItem().getNic();
            employeeTable.getItems().remove(employeeTable.getSelectionModel().getSelectedItem());
            boolean result = false ;
            try{
                manageLoginBO.deleteEmployeeLoginDetail(selectTDate);
                result = manageEmployeeBO.deleteEmployee(selectTDate);

            }catch (Exception e){
                Logger.getLogger("").log(Level.SEVERE, null, e);
            }
            if (!result){
                new Alert(Alert.AlertType.ERROR, "Failed to delete the Employee details", ButtonType.OK).showAndWait();
            }else{
                new Alert(Alert.AlertType.ERROR, "Delete the Employee details", ButtonType.OK).showAndWait();

            }
        }
    }

    public void search(KeyEvent keyEvent) {
        ObservableList<employeeTB> tempList = FXCollections.observableArrayList();
        for (employeeTB emp : tblItems) {
            if (emp.getName().startsWith(searchT.getText())){
                tempList.add(emp);
            }
        }
        employeeTable.setItems(tempList);
    }

    public void loginPage(Parent dashRoot){
        Scene se = new Scene(dashRoot);
        Stage primaryStage = (Stage)employee.getScene().getWindow();
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
