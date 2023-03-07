package lk.ijse.Library.controller;

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
import lk.ijse.Library.bo.custom.ExpentureBO;
import lk.ijse.Library.bo.custom.impl.ExpentureBOImpl;
import lk.ijse.Library.db.DBConnection;
import lk.ijse.Library.model.ExpentureModel;
import lk.ijse.Library.dto.ExpentureDTO;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpentureFormController {
    
    public TextField txtInvoiceNumber;
    public DatePicker txtExpentureDate;
    public TableView tblExpenture;
    public TableColumn clmInvoiceNumber;
    public TableColumn clmDescription;
    public TableColumn clmDate;
    public TableColumn clmPayment;
    public AnchorPane pane;
    public JFXTextField txtPayment;
    public JFXTextField txtDescription;
    private ExpentureBO expentureBO;

    public void expenAddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String InvoiceNumber= txtInvoiceNumber.getText();
        String Description = txtDescription.getText();
        String Date= String.valueOf(txtExpentureDate.getValue());
        Double Payment =Double.parseDouble(txtPayment.getText());


        ExpentureDTO expentureDTO = new ExpentureDTO(InvoiceNumber,Description,Date,Payment);
        boolean isAdded;

        isAdded = expentureBO.AddExpenture(expentureDTO);
        if (isAdded) {
            new Alert(Alert.AlertType.INFORMATION, "Added Success").show();

        }
        setTableUser();
    }

    public void expenUpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String InvoiceNumber= txtInvoiceNumber.getText();
        String Description = txtDescription.getText();
        String Date= String.valueOf(txtExpentureDate.getValue());
        double Payment =Double.parseDouble(txtPayment.getText());


        ExpentureDTO expentureDTO =new ExpentureDTO(InvoiceNumber,Description,Date,Payment);
        boolean isUpdate=expentureBO.UpdateExpenture(expentureDTO);
        if(isUpdate){
            new Alert(Alert.AlertType.INFORMATION,"Update Success").show();
        }
        setTableUser();
    }

    public void expenDeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        boolean isDeleted= expentureBO.DeleteExpenture(txtInvoiceNumber.getText());
        if(isDeleted){
            new Alert(Alert.AlertType.INFORMATION,"Deleted").show();
        }else{
            new Alert(Alert.AlertType.INFORMATION,"Deleted Fail").show();
        }
        setTableUser();
    }

    public void expenSearchOnAction(ActionEvent actionEvent) {
        try {
            ExpentureDTO expentureDTO = expentureBO.SearchExpenture(txtInvoiceNumber.getText());
            if (expentureDTO == null) {
                new Alert(Alert.AlertType.ERROR, " Not Found").show();
            } else {
                txtDescription.setText(expentureDTO.getDescription());
                txtExpentureDate.setValue(LocalDate.parse(expentureDTO.getDate() + ""));
                txtPayment.setText(expentureDTO.getDate() + "");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ExpentureFormController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ExpentureFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        setTableUser();
    }
    public void initialize() throws SQLException, ClassNotFoundException {
        expentureBO= BOFactory.getInstance().getBo(BOType.EXPENTURE);
        setNewExpentureId();
        setTableUser();
    }
    private void setNewExpentureId() throws SQLException, ClassNotFoundException {
        try{
            txtInvoiceNumber.setText(expentureBO.getNewExpenture());
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void setTableUser(){
        clmInvoiceNumber.setCellValueFactory(new PropertyValueFactory<ExpentureDTO,String>("InVoiceNumber"));
        clmDescription.setCellValueFactory(new PropertyValueFactory<ExpentureDTO,String>("Description"));
        clmDate.setCellValueFactory(new PropertyValueFactory<ExpentureDTO,String>("Date"));
        clmPayment.setCellValueFactory(new PropertyValueFactory<ExpentureDTO,Double>("Payment"));
        try{
            ObservableList<ExpentureDTO> expentureDTO =expentureBO.getAllExpenture();
            tblExpenture.setItems(expentureDTO);
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void txtOnKeyContact(KeyEvent keyEvent) {
        Pattern p1=Pattern.compile("^\\d{0,8}(\\.\\d{1,4})?$");
        Matcher m1=p1.matcher(txtPayment.getText());
        boolean b=m1.find();
        if (b){
            txtPayment.setUnFocusColor(Paint.valueOf("#2ecc71"));
        }else{
            txtPayment.setUnFocusColor(Paint.valueOf("#e74c3c"));
        }
    }
    public void invoiceNumberOnAction(ActionEvent actionEvent) {
        txtDescription.requestFocus();
    }

    public void DescriptionOnAction(ActionEvent actionEvent) {
        txtExpentureDate.requestFocus();
    }

    public void DateOnAction(ActionEvent actionEvent) {
        txtPayment.requestFocus();
    }

    public void PrintRepordOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, JRException {
        JasperDesign jasdi = JRXmlLoader.load("F:\\SE Class\\LibraryMangementSystem\\src\\lk\\ijse\\Library\\report\\ExpentureReport.jrxml");
        String sql = "SELECT * from Expenture where Invoice_Number = '" + txtInvoiceNumber.getText() + "'";
        JRDesignQuery newQuery = new JRDesignQuery();
        newQuery.setText(sql);
        jasdi.setQuery(newQuery);

        JasperReport js = JasperCompileManager.compileReport(jasdi);
        JasperPrint jp = JasperFillManager.fillReport(js, null, DBConnection.getInstance().getConnection());

        //String path =;
        //JasperExportManager.exportReportToPdfFil(jp,path);

        JasperViewer viewer = new JasperViewer(jp, false);
        viewer.show();
    }
}
