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
import lk.ijse.Library.bo.custom.BookBO;
import lk.ijse.Library.bo.custom.impl.BookBOImpl;
import lk.ijse.Library.dao.DAOFactory;
import lk.ijse.Library.dao.DAOType;
import lk.ijse.Library.model.BookModel;
import lk.ijse.Library.dto.BookDTO;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Double.parseDouble;

public class BookFormController {
    public TextField txtBookId;
    public TextField txtBookName;
    public TextField txtBookCategary;
    public TextField txtBookISBM;
    public TextField txtBookAuthor;
    public TextField txtBookShelf;
    public TextField txtOderId;
    public TableView tblBook;
    public TableColumn clmBookId;
    public TableColumn clmBookName;
    public TableColumn clmBookCategory;
    public TableColumn clmBookISBM;
    public TableColumn clmBookAuthor;
    public TableColumn clmBookPrice;
    public TableColumn clmBookShelf;
    public TableColumn clmOrderId;
    public AnchorPane pane;
    public JFXTextField txtBookPrice;
    private BookBO bookBO;


    public void initialize() throws SQLException, ClassNotFoundException {
       BookBO bookBO= BOFactory.getInstance().getBo(BOType.BOOK);
        setNewBookId();
        setTableUser();
    }

    public void BookAddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String BookId = txtBookId.getText();
        String BookName = txtBookName.getText();
        String BookCategory = txtBookCategary.getText();
        String BookISBM=txtBookISBM.getText();
        String Author=txtBookAuthor.getText();
        double BookPrice = parseDouble(txtBookPrice.getText());
        String BookShelf=txtBookShelf.getText();
        String OderId=txtOderId.getText();

        BookDTO bookDTO = new BookDTO(BookId,BookName,BookCategory,BookISBM,Author,BookPrice,BookShelf,OderId);
        boolean isAdded;

        isAdded = bookBO.AddBook(bookDTO);
        if (isAdded) {
            new Alert(Alert.AlertType.INFORMATION, "Added Success").show();
        }
        clearFields();
        setTableUser();
    }

    public void BookUpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String BookId = txtBookId.getText();
        String BookName = txtBookName.getText();
        String BookCategory = txtBookCategary.getText();
        String BookISBM=txtBookISBM.getText();
        String Author=txtBookAuthor.getText();
        double BookPrice =parseDouble(txtBookPrice.getText());
        String BookShelf=txtBookShelf.getText();
        String OderId=txtOderId.getText();

        BookDTO bookDTO =new BookDTO(BookId,BookName,BookCategory,BookISBM,Author,BookPrice,BookShelf,OderId);
        boolean isUpdate= bookBO.UpdateBook(bookDTO);
        if(isUpdate){
            new Alert(Alert.AlertType.INFORMATION,"Update Success").show();
        }else{
            new Alert(Alert.AlertType.INFORMATION,"Update Fail").show();
        }
        setTableUser();
    }

    public void BookDeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        boolean isDeleted= bookBO.DeleteBook(txtBookId.getText());
        if(isDeleted){
            new Alert(Alert.AlertType.INFORMATION,"Deleted").show();
        }else{
            new Alert(Alert.AlertType.INFORMATION,"Deleted Fail").show();
        }
        setTableUser();
    }

    public void BookSearchOnAction(ActionEvent actionEvent) {
        try {
            BookDTO bookDTO = bookBO.SearchBook(txtBookId.getText());
            if (bookDTO == null) {
                new Alert(Alert.AlertType.ERROR, " Not Found").show();
            } else {
                txtBookName.setText(bookDTO.getBookName());
                txtBookCategary.setText(bookDTO.getBookCategory());
                txtBookISBM.setText(bookDTO.getBookISBM());
                txtBookAuthor.setText(bookDTO.getAuthor());
                txtBookPrice.setText(bookDTO.getBookPrice()+"");
                txtBookShelf.setText(bookDTO.getBookShelf());
                txtOderId.setText(bookDTO.getOderId());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookFormController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        setTableUser();
    }

    private void clearFields() {
        txtBookName.clear();
        txtBookCategary.clear();
        txtBookISBM.clear();
        txtBookAuthor.clear();
        txtBookPrice.clear();
        txtBookShelf.clear();
        txtOderId.clear();
    }

    private void setNewBookId() throws SQLException, ClassNotFoundException {
        try{
            txtBookId.setText(bookBO.getNewBook());
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void setTableUser(){
        clmBookId.setCellValueFactory(new PropertyValueFactory<BookDTO,String>("BookId"));
        clmBookName.setCellValueFactory(new PropertyValueFactory<BookDTO,String>("BookName"));
        clmBookCategory.setCellValueFactory(new PropertyValueFactory<BookDTO,String>("BookCategory"));
        clmBookISBM.setCellValueFactory(new PropertyValueFactory<BookDTO,String>("BookISBM"));
        clmBookAuthor.setCellValueFactory(new PropertyValueFactory<BookDTO,String>("Author"));
        clmBookPrice.setCellValueFactory(new PropertyValueFactory<BookDTO,Double>("BookPrice"));
        clmBookShelf.setCellValueFactory(new PropertyValueFactory<BookDTO,String>("BookShelf"));
        clmOrderId.setCellValueFactory(new PropertyValueFactory<BookDTO,String>("OderId"));
        try{
            ObservableList<BookDTO> bookDTO =bookBO.getAllBook();
            tblBook.setItems(bookDTO);
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void txtOnKeyContact(KeyEvent keyEvent) {
        Pattern p1=Pattern.compile("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}");
        Matcher m1=p1.matcher(txtBookPrice.getText());
        boolean b=m1.find();
        if (b){
            txtBookPrice.setUnFocusColor(Paint.valueOf("#2ecc71"));
        }else{
            txtBookPrice.setUnFocusColor(Paint.valueOf("#e74c3c"));
        }
    }
    public void BookIdOnAction(ActionEvent actionEvent) {
        txtBookName.requestFocus();
    }

    public void BookNameOnAction(ActionEvent actionEvent) {
        txtBookCategary.requestFocus();
    }

    public void BookCategoryOnAction(ActionEvent actionEvent) {
        txtBookISBM.requestFocus();
    }

    public void BookISBMOnAction(ActionEvent actionEvent) {
        txtBookAuthor.requestFocus();
    }

    public void BookAuthorOnAction(ActionEvent actionEvent) {
        txtBookPrice.requestFocus();
    }

    public void BookPriceOnAction(ActionEvent actionEvent) {
        txtBookShelf.requestFocus();
    }

    public void BookShelfOnAction(ActionEvent actionEvent) {
        txtOderId.requestFocus();
    }
}
