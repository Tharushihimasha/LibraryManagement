package lk.ijse.Library.controller;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.Library.bo.BOFactory;
import lk.ijse.Library.bo.BOType;
import lk.ijse.Library.bo.custom.EmployeeSalaryBO;
import lk.ijse.Library.bo.custom.impl.EmployeeSalaryBOImpl;
import lk.ijse.Library.model.EmployeeSalaryModel;
import lk.ijse.Library.model.MemberModel;
import lk.ijse.Library.dto.EmployeeSalaryDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Double.parseDouble;

public class EmployeeSalaryController {
    public TextField txtEmployeeId;
    public JFXDatePicker txtDate;
    public AnchorPane pane;
    public TableView tblEmployeeSalary;
    public TableColumn clmEmployeeId;
    public TableColumn clmAmont;
    public TableColumn clmDate;
    public JFXTextField txtAmont;
    private EmployeeSalaryBO employeeSalaryBO;


    public void EmployeeSalarySearchOnAction(ActionEvent actionEvent) {
        try {
            EmployeeSalaryDTO employeeSalaryDTO = employeeSalaryBO.SearchEmployeeSalary(txtEmployeeId.getText());
            if (employeeSalaryDTO == null) {
                new Alert(Alert.AlertType.ERROR, " Not Found").show();
            } else {
                txtAmont.setText(employeeSalaryDTO.getAmount() + "");
                txtDate.setValue(LocalDate.parse(employeeSalaryDTO.getDate()));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmployeeSalaryController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeSalaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        setTableUser();
    }

    public void EmployeeSalaryAddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String EmployeeId = txtEmployeeId.getText();
        Double Amount =parseDouble(txtAmont.getText());
        String Date = String.valueOf(txtDate.getValue());

        EmployeeSalaryDTO employeeSalaryDTO = new EmployeeSalaryDTO(EmployeeId,Amount,Date);
        boolean isAdded;

        isAdded = employeeSalaryBO.AddEmployeeSalary(employeeSalaryDTO);
        if (isAdded) {
            new Alert(Alert.AlertType.INFORMATION, "Added Success").show();

        }
        setTableUser();
    }

    public void EmployeeSalaryUpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String EmployeeId = txtEmployeeId.getText();
        Double Amount = Double.valueOf(txtAmont.getText());
        String Date = String.valueOf(txtDate.getValue());

        EmployeeSalaryDTO employeeSalaryDTO =new EmployeeSalaryDTO(EmployeeId,Amount,Date);
        boolean isUpdate=employeeSalaryBO.UpdateEmployeeSalary(employeeSalaryDTO);
        if(isUpdate){
            new Alert(Alert.AlertType.INFORMATION,"Update Success").show();
        }
        setTableUser();
    }

    public void EmployeeSalaryDeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        boolean isDeleted= employeeSalaryBO.DeleteEmployeeSalary(txtEmployeeId.getText());
        if(isDeleted){
            new Alert(Alert.AlertType.INFORMATION,"Deleted").show();
        }else{
            new Alert(Alert.AlertType.INFORMATION,"Deleted Fail").show();
        }
        setTableUser();
    }
    public void initialize() throws SQLException, ClassNotFoundException {
        employeeSalaryBO= BOFactory.getInstance().getBo(BOType.EMPLOYEESALARY);
        setNewEmployeeId();
        setTableUser();
    }
    private void setNewEmployeeId() throws SQLException, ClassNotFoundException {
        try{
            txtEmployeeId.setText(employeeSalaryBO.getNewEmployeeSalary());
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void setTableUser(){
        clmEmployeeId.setCellValueFactory(new PropertyValueFactory<EmployeeSalaryDTO,String>("EmployeeId"));
        clmAmont.setCellValueFactory(new PropertyValueFactory<EmployeeSalaryDTO,Double>("Amount"));
        clmDate.setCellValueFactory(new PropertyValueFactory<EmployeeSalaryDTO,String>("Date"));
        try{
            ObservableList<EmployeeSalaryDTO> employeeSalaryDTO =employeeSalaryBO.getAllEmployeeSlary();
            tblEmployeeSalary.setItems(employeeSalaryDTO);
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void EmployeeIdOnAction(ActionEvent actionEvent) {
        txtAmont.requestFocus();
    }

    public void AmontOnAction(ActionEvent actionEvent) {
        txtDate.requestFocus();
    }
}
