package lk.ijse.Library.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFromController {

    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        if(txtUserName.getText().equalsIgnoreCase("Tharu") && txtPassword.getText().equalsIgnoreCase("12345")) {
            Parent parent = FXMLLoader.load(getClass().getResource("/lk/ijse/Library/view/Dashboard.fxml/"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setScene(scene);

            stage.centerOnScreen();
            stage.show();
        } else{
            new Alert(Alert.AlertType.ERROR,"Loging Failed,Invalid User Name or Password").show();
        }
    }

    public void UserOnAction(ActionEvent actionEvent) {
        txtPassword.requestFocus();
    }
}
