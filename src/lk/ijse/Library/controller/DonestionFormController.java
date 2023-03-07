package lk.ijse.Library.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.Library.bo.BOFactory;
import lk.ijse.Library.bo.BOType;
import lk.ijse.Library.bo.custom.DonationBO;
import lk.ijse.Library.bo.custom.impl.DonationBOImpl;
import lk.ijse.Library.model.DonationModel;
import lk.ijse.Library.dto.DonationDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DonestionFormController {
    public TextField txtDonationId;
    public TextField txtDonaterName;
    public TextField txtDonationValue;
    public DatePicker txtDonationDate;
    public TableView tblDonation;
    public TableColumn clmDonationId;
    public TableColumn clmDonaterName;
    public TableColumn clmDonation;
    public TableColumn clmDonationDate;
    public AnchorPane pane;
    private DonationBO donationBO;

    public void DonationAddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        String DonationId = txtDonationId.getText();
        String DonaterName = txtDonaterName.getText();
        String DonationValue = txtDonationValue.getText();
        String DonationDate= String.valueOf(txtDonationDate.getValue());

        DonationDTO donationDTO = new DonationDTO(DonationId,DonaterName,DonationValue,DonationDate);
        boolean isAdded;

        isAdded = donationBO.AddDonation(donationDTO);
        if (isAdded) {
            new Alert(Alert.AlertType.INFORMATION, "Added Success").show();

        }
        clearFields();
        setTableUser();
    }

    public void DonationUpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String DonationId = txtDonationId.getText();
        String DonaterName = txtDonaterName.getText();
        String DonationValue = txtDonationValue.getText();
        String DonationDate= String.valueOf(txtDonationDate.getValue());

        DonationDTO donationDTO =new DonationDTO(DonationId,DonaterName,DonationValue,DonationDate);
        boolean isUpdate=donationBO.UpdateDonation(donationDTO);
        if(isUpdate){
            new Alert(Alert.AlertType.INFORMATION,"Update Success").show();
        }
        setTableUser();
    }

    public void DonationDeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        boolean isDeleted= donationBO.DeleteDonation(txtDonationId.getText());
        if(isDeleted){
            new Alert(Alert.AlertType.INFORMATION,"Deleted").show();
        }else{
            new Alert(Alert.AlertType.INFORMATION,"Deleted Fail").show();
        }
        setTableUser();
    }

    public void DonationSearchOnAction(ActionEvent actionEvent) {
        try {
            DonationDTO donationDTO = donationBO.SearchDonation(txtDonationId.getText());
            if (donationDTO == null) {
                new Alert(Alert.AlertType.ERROR, "Not Found").show();
            } else {
                txtDonaterName.setText(donationDTO.getDonaterName());
                txtDonationValue.setText(donationDTO.getDonationValue());
                txtDonationDate.setValue(LocalDate.parse(donationDTO.getDonationDate() + ""));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DonestionFormController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DonestionFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        setTableUser();
    }
    public void initialize() throws SQLException, ClassNotFoundException {
        donationBO = BOFactory.getInstance().getBo(BOType.DONESTION);
        setNewDonationId();
        setTableUser();
    }
    private void clearFields() {
        txtDonationId.clear();
        txtDonaterName.clear();
        txtDonationValue.clear();
        //txtDonationDate.clear(null);
    }
    private void setNewDonationId() throws SQLException, ClassNotFoundException {
        try{
            txtDonationId.setText(donationBO.getNewDonation());
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void setTableUser(){
        clmDonationId.setCellValueFactory(new PropertyValueFactory<DonationDTO,String>("DonationId"));
        clmDonaterName.setCellValueFactory(new PropertyValueFactory<DonationDTO,String>("DonaterName"));
        clmDonation.setCellValueFactory(new PropertyValueFactory<DonationDTO,String>("DonationValue"));
        clmDonationDate.setCellValueFactory(new PropertyValueFactory<DonationDTO,String>("DonationDate"));
        try{
            ObservableList<DonationDTO> donationDTO =donationBO.getAllDonation();
            tblDonation.setItems(donationDTO);
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void DonationIdOnAction(ActionEvent actionEvent) {
        txtDonaterName.requestFocus();
    }

    public void NameOnAtion(ActionEvent actionEvent) {
        txtDonationValue.requestFocus();
    }

    public void ValueOnAction(ActionEvent actionEvent) {
        txtDonationDate.requestFocus();
    }
}
