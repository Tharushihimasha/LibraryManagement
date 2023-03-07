package lk.ijse.Library.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import lk.ijse.Library.bo.BOFactory;
import lk.ijse.Library.bo.BOType;
import lk.ijse.Library.bo.custom.EmployeeBO;
import lk.ijse.Library.bo.custom.EmployeeSalaryBO;
import lk.ijse.Library.bo.custom.impl.EmployeeBOImpl;
import lk.ijse.Library.model.EmployeeModel;
import lk.ijse.Library.dto.EmployeeDTO;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeFormController {
    public TextField txtEmployeeId;
    public TextField txtEmployeeNic;
    public TextField txtEmployeeName;
    public TextField txtAddress;
    public TextField txtSalary;
    public TableView tblEmployee;
    public TableColumn clmEmployeeId;
    public TableColumn clmAddress;
    public TableColumn clmContact;
    public TableColumn clmSalary;
    public TableColumn clmEmployeeName;
    public TableColumn clmEmployeeNic;
    public AnchorPane pane;
    public JFXTextField txtContact;
    private EmployeeBO employeeBO;

    public void EmployeeAddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String EmployeeId = txtEmployeeId.getText();
        String Nic = txtEmployeeNic.getText();
        String Name = txtEmployeeName.getText();
        String Address = txtAddress.getText();
        int Contact = Integer.parseInt(txtContact.getText());
        System.out.println(Contact);
        Double Salary= Double.valueOf(txtSalary.getText());

        EmployeeDTO employeeDTO = new EmployeeDTO(EmployeeId,Nic,Name,Address,Contact,Salary);
        boolean isAdded;

        isAdded = employeeBO.AddEmployee(employeeDTO);
        if (isAdded) {
            new Alert(Alert.AlertType.INFORMATION, "Added Success").show();

        }
        clearFields();
        setTableUser();
    }

    public void EmployeeUpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String EmployeeId = txtEmployeeId.getText();
        String Nic = txtEmployeeNic.getText();
        String Name = txtEmployeeName.getText();
        String Address = txtAddress.getText();
        int Contact = Integer.parseInt(txtContact.getText());
        Double Salary= Double.valueOf(txtSalary.getText());

        EmployeeDTO employeeDTO =new EmployeeDTO(EmployeeId,Nic,Name,Address,Contact,Salary);
        boolean isUpdate=employeeBO.UpdateEmployee(employeeDTO);
        if(isUpdate){
            new Alert(Alert.AlertType.INFORMATION,"Update Success").show();

        }
        setTableUser();
    }

    public void EmployeeDeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        boolean isDeleted= employeeBO.DeleteEmployee(txtEmployeeId.getText());
        if(isDeleted){
            new Alert(Alert.AlertType.INFORMATION,"Deleted").show();
        }else{
            new Alert(Alert.AlertType.INFORMATION,"Deleted Fail").show();
        }
        setTableUser();
    }

    public void EmployeeSearchOnAction(ActionEvent actionEvent) {
        try {
            EmployeeDTO employeeDTO = employeeBO.SearchEmployee(txtEmployeeId.getText());
            if (employeeDTO == null) {
                new Alert(Alert.AlertType.ERROR, " Not Found").show();
            } else {
                txtEmployeeNic.setText(employeeDTO.getNic());
                txtEmployeeName.setText(employeeDTO.getName());
                txtAddress.setText(employeeDTO.getAddress());
                txtContact.setText(employeeDTO.getContact() + "");
                txtSalary.setText(employeeDTO.getSalary() + "");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmployeeFormController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        setTableUser();
    }
    public void initialize() throws SQLException, ClassNotFoundException {
        employeeBO= BOFactory.getInstance().getBo(BOType.EMPLOYEE);
        setNewEmployeeId();
        setTableUser();
    }
    private void clearFields() {
        txtEmployeeNic.clear();
        txtEmployeeName.clear();
        txtAddress.clear();
        txtContact.clear();
        txtSalary.clear();

    }
    private void setNewEmployeeId() throws SQLException, ClassNotFoundException {
        try{
            txtEmployeeId.setText(employeeBO.getNewEmployee());
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void setTableUser(){
        clmEmployeeId.setCellValueFactory(new PropertyValueFactory<EmployeeDTO,String>("EmployeeId"));
        clmEmployeeNic.setCellValueFactory(new PropertyValueFactory<EmployeeDTO,String>("Nic"));
        clmEmployeeName.setCellValueFactory(new PropertyValueFactory<EmployeeDTO,String>("Name"));
        clmAddress.setCellValueFactory(new PropertyValueFactory<EmployeeDTO,String>("Address"));
        clmContact.setCellValueFactory(new PropertyValueFactory<EmployeeDTO,Integer>("Contact"));
        clmSalary.setCellValueFactory(new PropertyValueFactory<EmployeeDTO,Double>("Salary"));
        try{
            ObservableList<EmployeeDTO> employeeDTO =employeeBO.getAllEmployee();
            tblEmployee.setItems(employeeDTO);
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void txtOnKeyContact(KeyEvent keyEvent) {
        Pattern p1=Pattern.compile("^(?:0|94|\\+94|0094)?(?:(11|21|23|24|25|26|27|31|32|33|34|35|36|37|38|41|45|47|51|52|54|55|57|63|65|66|67|81|91)(0|2|3|4|5|7|9)|7(0|1|2|4|5|6|7|8)\\d)\\d{6}$");;
        Matcher m1=p1.matcher(txtContact.getText());
        boolean b=m1.find();
        if (b){
            txtContact.setUnFocusColor(Paint.valueOf("#2ecc71"));
        }else{
            txtContact.setUnFocusColor(Paint.valueOf("#e74c3c"));
        }
    }
    public void EmIdOnAction(ActionEvent actionEvent) {
        txtEmployeeNic.requestFocus();
    }

    public void NicOnAction(ActionEvent actionEvent) {
        txtEmployeeName.requestFocus();
    }

    public void AddressOnAction(ActionEvent actionEvent) {
        txtContact.requestFocus();
    }

    public void ContactOnAction(ActionEvent actionEvent) {
        txtSalary.requestFocus();
    }

    public void SalaryOnAction(ActionEvent actionEvent) {
    }

    public void NameOnAction(ActionEvent actionEvent) {
        txtAddress.requestFocus();
    }
}
