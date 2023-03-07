package lk.ijse.Library.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import lk.ijse.Library.bo.BOFactory;
import lk.ijse.Library.bo.BOType;
import lk.ijse.Library.bo.custom.OderBO;
import lk.ijse.Library.bo.custom.impl.OderBOImpl;
import lk.ijse.Library.model.OderModel;
import lk.ijse.Library.dto.OderDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OderFormController {
    public TextField txtOderId;
    public JFXComboBox cmbOderType;
    public DatePicker txtOderDate;
    public TableView tblOder;
    public TableColumn clmOderId;
    public TableColumn clmOderType;
    public TableColumn clmOrderPrice;
    public TableColumn clmOrderDate;
    public AnchorPane pane;
    public JFXTextField txtOderPrice;
    private OderBO oderBO;

    public void initialize() throws SQLException, ClassNotFoundException {
        oderBO= BOFactory.getInstance().getBo(BOType.ODER);
        setDate();
        setNewOderId();
        setTableUser();
    }

    public void setDate(){
        cmbOderType.getItems().add("Oder Book");
        cmbOderType.getItems().add("Donation Book");
    }

    public void OderSearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

            OderDTO oderDTO = oderBO.SearchOder(txtOderId.getText());
            if (oderDTO == null) {
                new Alert(Alert.AlertType.ERROR, "Oder Not Found").show();
            } else {
                cmbOderType.setValue(oderDTO.getOderType());
                txtOderPrice.setText(oderDTO.getOderPrice() + "");
                txtOderDate.setValue(LocalDate.parse(oderDTO.getOderDate()));
            }
        setTableUser();
    }

    public void AddOderOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String OderId = txtOderId.getText();
        String OderType = String.valueOf(cmbOderType.getValue());
        if(OderType.equals("Oder Book")){
            OderType = "Order";
        }else{
            OderType = "Donation";
        }
        double OderPrice =Double.parseDouble(txtOderPrice.getText());
        String OderDate = String.valueOf(txtOderDate.getValue());


        OderDTO oderDTO = new OderDTO(OderId,OderType,OderPrice,OderDate);
        boolean isAdded;

        isAdded = oderBO.AddOder(oderDTO);
        if (isAdded) {
            new Alert(Alert.AlertType.INFORMATION, "Added Success").show();

        }
        setTableUser();
    }

    public void OderUpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String OderId = txtOderId.getText();
        String OderType = String.valueOf(cmbOderType.getValue());
        if(OderType.equals("Oder Book")){
            OderType = "Order";
        }else{
            OderType = "Donation";
        }
        double OderPrice = Double.parseDouble(txtOderPrice.getText());
        String OderDate = String.valueOf(txtOderDate.getValue());

        OderDTO oderDTO =new OderDTO(OderId,OderType,OderPrice,OderDate);
        boolean isUpdate=oderBO.UpdateOder(oderDTO);
        if(isUpdate){
            new Alert(Alert.AlertType.INFORMATION,"Update Success").show();
        }else{
            new Alert(Alert.AlertType.INFORMATION,"Update Fail").show();
        }
        setTableUser();
    }

    public void OderDeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        boolean isDeleted= oderBO.DeleteOder(txtOderId.getText());
        if(isDeleted){
            new Alert(Alert.AlertType.INFORMATION,"Deleted").show();
        }else{
            new Alert(Alert.AlertType.INFORMATION,"Deleted Fail").show();
        }
        setTableUser();
    }

    private void setNewOderId() throws SQLException, ClassNotFoundException {
        try{
            txtOderId.setText(oderBO.getNewOder());
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void setTableUser(){
        clmOderId.setCellValueFactory(new PropertyValueFactory<OderDTO,String>("OderId"));
        clmOderType.setCellValueFactory(new PropertyValueFactory<OderDTO,String>("OderType"));
        clmOrderPrice.setCellValueFactory(new PropertyValueFactory<OderDTO,Double>("OderPrice"));
        clmOrderDate.setCellValueFactory(new PropertyValueFactory<OderDTO,String>("OderDate"));
        try{
            ObservableList<OderDTO> oderDTO =oderBO.getAllOder();
            tblOder.setItems(oderDTO);
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void txtOnKeyContact(KeyEvent keyEvent) {
        Pattern p1=Pattern.compile("^\\d{0,8}(\\.\\d{1,4})?$");
        Matcher m1=p1.matcher(txtOderPrice.getText());
        boolean b=m1.find();
        if (b){
            txtOderPrice.setUnFocusColor(Paint.valueOf("#2ecc71"));
        }else{
            txtOderPrice.setUnFocusColor(Paint.valueOf("#e74c3c"));
        }
    }

    public void OrderTypeOnAction(ActionEvent actionEvent) {
        txtOderPrice.requestFocus();
    }

    public void OrderDateOnAction(ActionEvent actionEvent) {

    }

    public void OrderPriceOnAction(ActionEvent actionEvent) {
        txtOderDate.requestFocus();
    }

    public void oderIdOnAction(ActionEvent actionEvent) {
        cmbOderType.requestFocus();
    }
}
