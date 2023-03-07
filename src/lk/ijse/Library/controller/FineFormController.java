package lk.ijse.Library.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.Library.bo.custom.FineBO;
import lk.ijse.Library.model.FineModel;
import lk.ijse.Library.dto.FineDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class FineFormController {
    public TextField txtDateLate;
    public JFXTextField txtFineDate;
    public TextField txtTotal;
    public AnchorPane DashboardContext;
    private String RecordId;
    private FineBO fineBO;

    public void btnTotalOnAction(ActionEvent actionEvent) {
        try{
            double total = Double.parseDouble(txtFineDate.getText()) * Integer.parseInt(txtDateLate.getText());
            txtTotal.setText(String.valueOf(total));
        }catch(NumberFormatException ex){
            new Alert(Alert.AlertType.ERROR,"Invalid Amount").show();
        }
    }

    public void btnAddOnAction(ActionEvent actionEvent) {
        FineDTO fine = new FineDTO(RecordId,Integer.parseInt(txtDateLate.getText()),Double.parseDouble(txtTotal.getText()),
                String.valueOf(LocalDate.now()));
        try {
            boolean flag = fineBO.addFine(fine);
            if(flag){
                new Alert(Alert.AlertType.INFORMATION,"Fine Added Success").show();
            }else{
                new Alert(Alert.AlertType.ERROR,"Fine Adding Fail").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,"Fine Adding Fail - Database Error").show();
        } catch (ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR,"Fine Adding Fail - Driver Error").show();
        }
    }
    public void setRecordId(String id){
        RecordId=id;
    }
    public void setLblFine(int count){
        txtDateLate.setText(String.valueOf(count));
    }


    public void btnCancelOnAction(ActionEvent actionEvent) throws IOException {
        setUi("BookRecordForm");

    }
    private void setUi(String ui) throws IOException {
        Stage stage=(Stage) DashboardContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+ui+".fxml"))));
        stage.centerOnScreen();

    }
}
