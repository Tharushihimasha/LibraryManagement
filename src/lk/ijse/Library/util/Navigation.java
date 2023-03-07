package lk.ijse.Library.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;

    public static void navigate(Routes route, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage)Navigation.pane.getScene().getWindow();

        switch (route) {
            case Book:
                window.setTitle("Book Manage");
                initUI("BookForm.fxml");
                break;
            case Employee:
                window.setTitle("Employee Manage");
                initUI("EmployeeForm.fxml");
                break;
            case Member:
                window.setTitle("Member Manage");
                initUI("AddMemberForm.fxml");
                break;
            case DashBoard:
                window.setTitle("Dash Board");
                initUI("DashBoard.fxml");
                break;
            case Donation:
                window.setTitle("Donation");
                initUI("DonestionForm.fxml");
                break;
            case Expenture:
                window.setTitle("Expenture");
                initUI("ExpentureForm.fxml");
                break;

            case Oder:
                window.setTitle("Order");
                initUI("OderForm.fxml");
                break;
            case BookRecord:
                window.setTitle("BookRecord");
                initUI("BookRecord.fxml");
                break;

            case InCome:
                window.setTitle("InCome From");
                initUI("InComeForm.fxml");
                break;

            default:
                new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }
    public static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/lk/ijse/library/view/" + location)));
    }
}
