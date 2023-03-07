package lk.ijse.Library.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.Library.bo.BOFactory;
import lk.ijse.Library.bo.BOType;
import lk.ijse.Library.bo.custom.*;
import lk.ijse.Library.bo.custom.impl.*;
import lk.ijse.Library.model.BookModel;
import lk.ijse.Library.model.BookRecordModel;
import lk.ijse.Library.model.EmployeeModel;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DashboardController {
    public AnchorPane contest;
    public Label lblDate;
    public Label lblTime;
    public AnchorPane DashboardContext;
    public AnchorPane pane;
    public Label lblMemberCount;
    public Label lblBookCount;
    public Label lblEmployeeCount;
    public Label lblIssueBook;
    public Label lblReturnBook;
    private BookRecordBO bookRecordBO;
    private BookBO bookBO;
    private EmployeeBO employeeBO;
    private DonationBO donationBO;
    private EmployeeSalaryBO employeeSalaryBO;
    private ExpentureBO expentureBO;
    private OderBO oderBO;
    private MemberBO memberBO;

    public void initialize() throws SQLException, ClassNotFoundException {
        bookRecordBO = BOFactory.getInstance().getBo(BOType.BOOKRECORD);
        bookBO = BOFactory.getInstance().getBo(BOType.BOOK);
        employeeBO = BOFactory.getInstance().getBo(BOType.EMPLOYEE);
        donationBO=BOFactory.getInstance().getBo(BOType.DONESTION);
        employeeSalaryBO=BOFactory.getInstance().getBo(BOType.EMPLOYEESALARY);
        expentureBO=BOFactory.getInstance().getBo(BOType.EXPENTURE);
        oderBO=BOFactory.getInstance().getBo(BOType.ODER);
        memberBO=BOFactory.getInstance().getBo(BOType.MEMBER);
        setDateAndTime();
        visibleMemberCount();
        visibleIssueBookCount();
        visibleEmployeeCount();
        visiblePendingBooks();
        try {
            lblBookCount.setText(bookBO.getBookCount());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void visibleEmployeeCount() {
        try {
            lblEmployeeCount.setText(employeeBO.getEmployeeCount());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void visiblePendingBooks() throws SQLException, ClassNotFoundException {
        lblReturnBook.setText(bookRecordBO.getPendingReturnBooks());
    }
    private void visibleMemberCount() throws SQLException, ClassNotFoundException {
        lblMemberCount.setText(bookBO.getMemberCount());
    }
    public void visibleIssueBookCount() throws SQLException, ClassNotFoundException {
        lblIssueBook.setText(bookRecordBO.getIssueBookCount());
    }

    public void setDateAndTime(){
        Timeline time=new Timeline(
                new KeyFrame(Duration.ZERO,e->{
                    DateTimeFormatter formatter= DateTimeFormatter.ofPattern("    dd-MM-yyyy    HH:mm:ss");
                    lblDate.setText(LocalDateTime.now().format(formatter));
                }), new KeyFrame(Duration.seconds(1))
        );
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }

    public void BookOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.
                load(getClass().getResource("../view/BookForm.fxml"));
        pane.getChildren().clear();
        pane.getChildren().add(parent);
    }

    public void MemeberOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.
                load(getClass().getResource("../view/MemberForm.fxml"));
        pane.getChildren().clear();
        pane.getChildren().add(parent);
    }

    public void employeeOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.
                load(getClass().getResource("../view/EmployeeForm.fxml"));
        pane.getChildren().clear();
        pane.getChildren().add(parent);
    }

    public void LogOutOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LoginFrom");
    }

    public void DonetionOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.
                load(getClass().getResource("../view/DonestionForm.fxml"));
        pane.getChildren().clear();
        pane.getChildren().add(parent);
    }

    public void ExpentureOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.
                load(getClass().getResource("../view/ExpentureForm.fxml"));
        pane.getChildren().clear();
        pane.getChildren().add(parent);
    }

    public void OderOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.
                load(getClass().getResource("../view/OderForm.fxml"));
        pane.getChildren().clear();
        pane.getChildren().add(parent);
    }

    public void SalaryOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.
                load(getClass().getResource("../view/EmployeeSalary.fxml"));
        pane.getChildren().clear();
        pane.getChildren().add(parent);
    }

    public void BookRecordOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.
                load(getClass().getResource("../view/BookRecordForm.fxml"));
        pane.getChildren().clear();
        pane.getChildren().add(parent);
    }
    private void setUi(String ui) throws IOException {
        Stage stage =(Stage)DashboardContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+ui+".fxml"))));
        stage.centerOnScreen();
    }

    public void DashBoradOnAction(ActionEvent actionEvent) throws IOException {
        setUi("Dashboard");
    }

    public void IncomeOnAction(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.
                load(getClass().getResource("../view/InComeForm.fxml"));
        pane.getChildren().clear();
        pane.getChildren().add(parent);
    }
}
