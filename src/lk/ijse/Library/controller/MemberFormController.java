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
import lk.ijse.Library.bo.custom.MemberBO;
import lk.ijse.Library.bo.custom.impl.MemberBOImpl;
import lk.ijse.Library.model.MemberModel;
import lk.ijse.Library.dto.MemberDTO;


import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MemberFormController {
    public TextField txtMemberName;
    public TextField txtMemberAddress;

    public TableView tblAddMember;
    public TableColumn clmMemberId;
    public TableColumn clmMemberName;
    public TableColumn clmMemberAddress;
    public TableColumn clmContact;
    public AnchorPane pane;
    public JFXTextField txtMemberContact;
    public TextField txtMemberId;
    private MemberBO memberBO;


    public void AddMemberOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String MemberId = txtMemberId.getText();
        String MemberName = txtMemberName.getText();
        String MemberAddress = txtMemberAddress.getText();
        int MemberContact = Integer.parseInt(txtMemberContact.getText());

        MemberDTO memberDTO = new MemberDTO(MemberId, MemberName, MemberAddress, MemberContact);
        boolean isAdded;

        isAdded = memberBO.AddMember(memberDTO);
        if (isAdded) {
            new Alert(Alert.AlertType.INFORMATION, "Added Success").show();

        }
        clearFields();
        setTableUser();
    }

    public void MemberSearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            MemberDTO memberDTO = memberBO.SearchMember(txtMemberId.getText());
            if (memberDTO == null) {
                new Alert(Alert.AlertType.ERROR, "Member Not Found").show();
            } else {
                txtMemberName.setText(memberDTO.getMemberName());
                txtMemberAddress.setText(memberDTO.getMemberAddress());
                txtMemberContact.setText(memberDTO.getMemberContact() + "");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MemberFormController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MemberFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        setTableUser();
    }

    public void MemberUpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String MemberId=txtMemberId.getText();
        String MemberName=txtMemberName.getText();
        String MemberAddress=txtMemberAddress.getText();
        int MemberContact=Integer.parseInt(txtMemberContact.getText());

        MemberDTO memberDTO =new MemberDTO(MemberId,MemberName,MemberAddress,MemberContact);
        boolean isUpdate=memberBO.UpdateMember(memberDTO);
        if(isUpdate){
            new Alert(Alert.AlertType.INFORMATION,"Update Success").show();
        }
        setTableUser();
    }

    public void MemberDeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        boolean isDeleted= memberBO.DeleteMember(txtMemberId.getText());
        if(isDeleted){
            new Alert(Alert.AlertType.INFORMATION,"Delete This Member").show();
        }else{
            new Alert(Alert.AlertType.INFORMATION,"Deleted Fail").show();
        }
        setTableUser();
    }
    private void clearFields() {
        txtMemberAddress.clear();
        txtMemberContact.clear();
        txtMemberName.clear();
    }

    public void initialize() throws SQLException, ClassNotFoundException {
        memberBO= BOFactory.getInstance().getBo(BOType.MEMBER);
        setNewMemberId();
        setTableUser();
        clearFields();

    }

    private void setNewMemberId() throws SQLException, ClassNotFoundException {
        try{
            txtMemberId.setText(memberBO.getNewMember());
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void setTableUser(){
        clmMemberId.setCellValueFactory(new PropertyValueFactory<MemberDTO,String>("MemberId"));
        clmMemberName.setCellValueFactory(new PropertyValueFactory<MemberDTO,String>("MemberName"));
        clmMemberAddress.setCellValueFactory(new PropertyValueFactory<MemberDTO,String>("MemberAddress"));
        clmContact.setCellValueFactory(new PropertyValueFactory<MemberDTO,String>("MemberContact"));
        try{
            ObservableList<MemberDTO> memberDTOS =memberBO.getAllMember();
            tblAddMember.setItems(memberDTOS);
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void txtMemberIdOnAction(ActionEvent actionEvent) {
        txtMemberName.requestFocus();
    }

    public void txtMemberNameOnAction(ActionEvent actionEvent) {
        txtMemberAddress.requestFocus();
    }

    public void txtMemberAddressOnAction(ActionEvent actionEvent) {
        txtMemberContact.requestFocus();
    }

    public void txtMemberContactOnAction(ActionEvent actionEvent) {
    }

    public void textKeyReleased(KeyEvent keyEvent) {

    }


    public void txtOnKeyContact(KeyEvent keyEvent) {
        Pattern p1=Pattern.compile("^(?:0|94|\\+94|0094)?(?:(11|21|23|24|25|26|27|31|32|33|34|35|36|37|38|41|45|47|51|52|54|55|57|63|65|66|67|81|91)(0|2|3|4|5|7|9)|7(0|1|2|4|5|6|7|8)\\d)\\d{6}$");;
        Matcher m1=p1.matcher(txtMemberContact.getText());
        boolean b=m1.find();
        if (b){
            txtMemberContact.setUnFocusColor(Paint.valueOf("#2ecc71"));
        }else{
            txtMemberContact.setUnFocusColor(Paint.valueOf("#e74c3c"));
        }
    }
}

