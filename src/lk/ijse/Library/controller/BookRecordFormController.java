package lk.ijse.Library.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lk.ijse.Library.bo.BOFactory;
import lk.ijse.Library.bo.BOType;
import lk.ijse.Library.bo.custom.BookRecordBO;
import lk.ijse.Library.bo.custom.impl.BookRecordBOImpl;
import lk.ijse.Library.model.BookRecordModel;
import lk.ijse.Library.dto.BookRecordDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class BookRecordFormController {
    public TextField txtBookRecordId;
    public TextField txtMemberId;
    public TextField txtBookId;
    public DatePicker txtIssueDate;
    public DatePicker txtReturnDate;
    public JFXComboBox cmbStutes;
    public AnchorPane pane;
    public TableView tblBookRecord;
    public TableColumn clmBookRecordId;
    public TableColumn clmMemberId;
    public TableColumn clmBookId;
    public TableColumn clmIssuedDate;
    public TableColumn clmReturnDate;
    public TableColumn clmStatus;
    private BookRecordBO bookRecordBO;

    public void RecordSearchOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        BookRecordDTO bookRecordDTO = bookRecordBO.SearchBookRecord(txtBookRecordId.getText());
        if (bookRecordDTO == null) {
            new Alert(Alert.AlertType.ERROR, "Not Found").show();
        } else {
            txtMemberId.setText(bookRecordDTO.getMemberId());
            txtBookId.setText(bookRecordDTO.getBookId());
            txtIssueDate.setValue(LocalDate.parse(bookRecordDTO.getIssueDate()));
            txtReturnDate.setValue(LocalDate.parse(bookRecordDTO.getReturnDate()));
            cmbStutes.setValue(bookRecordDTO.getRecordStates());
        }
        setTableUser();
    }

    public void AddRecordOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String RecordId = txtBookRecordId.getText();
        String MemberId = txtMemberId.getText();
        String BookId = txtBookId.getText();
        String IssueDate = String.valueOf(txtIssueDate.getValue());
        String ReturnDate = String.valueOf(txtReturnDate.getValue());
        String RecordStatus = String.valueOf(cmbStutes.getValue());



        BookRecordDTO bookRecordDTO = new BookRecordDTO(RecordId,MemberId,BookId,IssueDate,ReturnDate,RecordStatus);
        boolean isAdded;

        isAdded = bookRecordBO.AddBookRecord(bookRecordDTO);
        if (isAdded) {
            new Alert(Alert.AlertType.INFORMATION, "Added Success").show();

        }
        setTableUser();
    }

    public void RecordUpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
        String RecordId = txtBookRecordId.getText();

        String dateCount = bookRecordBO.LateDate( RecordId);
        System.out.println(dateCount);
        if(dateCount!=null){
            int dc = Integer.parseInt(dateCount);
            if(dc>0){
                Stage st = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/FineForm.fxml"));
                Parent load = loader.load();
                FineFormController controller = loader.getController();
                controller.setLblFine(dc);
                controller.setRecordId(txtBookRecordId.getText());
                st.setScene(new Scene(load));
                st.initModality(Modality.APPLICATION_MODAL);
                st.initOwner(pane.getScene().getWindow());
                st.showAndWait();

            }
        }
        String MemberId = txtMemberId.getText();
        String BookId = txtBookId.getText();
        String IssueDate = String.valueOf(txtIssueDate.getValue());
        String ReturnDate = String.valueOf(txtReturnDate.getValue());
        String RecordStatus = String.valueOf(cmbStutes.getValue());

        BookRecordDTO bookRecordDTO =new BookRecordDTO(RecordId,MemberId,BookId,IssueDate,ReturnDate,RecordStatus);
        boolean isUpdate= bookRecordBO.UpdateBookRecord(bookRecordDTO);
        if(isUpdate){
            new Alert(Alert.AlertType.INFORMATION,"Update Success").show();
        }
        setTableUser();
    }

    public void RecordDeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        boolean isDeleted= bookRecordBO.DeleteBookRecord(txtBookRecordId.getText());
        if(isDeleted){
            new Alert(Alert.AlertType.INFORMATION,"Deleted").show();
        }else{
            new Alert(Alert.AlertType.INFORMATION,"Deleted Fail").show();
        }
        setTableUser();
    }


    public void initialize() throws SQLException, ClassNotFoundException {
        bookRecordBO= BOFactory.getInstance().getBo(BOType.BOOKRECORD);
        setDate();
        setNewBookRecordId();
        setTableUser();
    }

    public void setDate(){
        cmbStutes.getItems().add("Issued");
        cmbStutes.getItems().add("Returned");
    }
    private void setNewBookRecordId() throws SQLException, ClassNotFoundException {
        try{
            txtBookRecordId.setText(bookRecordBO.getNewBookRecord());
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void setTableUser(){
        clmBookRecordId.setCellValueFactory(new PropertyValueFactory<BookRecordDTO,String>("RecordId"));
        clmMemberId.setCellValueFactory(new PropertyValueFactory<BookRecordDTO,String>("MemberId"));
        clmBookId.setCellValueFactory(new PropertyValueFactory<BookRecordDTO,String>("BookId"));
        clmIssuedDate.setCellValueFactory(new PropertyValueFactory<BookRecordDTO,String>("IssueDate"));
        clmReturnDate.setCellValueFactory(new PropertyValueFactory<BookRecordDTO,String>("ReturnDate"));
        clmStatus.setCellValueFactory(new PropertyValueFactory<BookRecordDTO,String>("RecordStatus"));
        try{
            ObservableList<BookRecordDTO> bookRecordDTO =bookRecordBO.getAllBookRecord();
            tblBookRecord.setItems(bookRecordDTO);
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void RecordIdOnAction(ActionEvent actionEvent) {
        txtMemberId.requestFocus();
    }

    public void MemberIdOnAction(ActionEvent actionEvent) {
        txtBookId.requestFocus();
    }

    public void BookIdOnAction(ActionEvent actionEvent) {
        txtIssueDate.requestFocus();
    }

    public void IssueDateOnAction(ActionEvent actionEvent) {
        txtReturnDate.requestFocus();
    }

    public void ReturnDateOnAction(ActionEvent actionEvent) {
        cmbStutes.requestFocus();
    }
}
