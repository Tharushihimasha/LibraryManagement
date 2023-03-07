package lk.ijse.Library.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.Library.bo.SuperBO;
import lk.ijse.Library.dto.EmployeeDTO;

import java.sql.SQLException;

public interface EmployeeBO extends SuperBO {
    boolean AddEmployee(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException;
    EmployeeDTO SearchEmployee(String EmployeeId) throws SQLException, ClassNotFoundException;
    boolean UpdateEmployee(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException;
    boolean DeleteEmployee(String Id) throws SQLException, ClassNotFoundException;
    ObservableList<EmployeeDTO> getAllEmployee() throws SQLException, ClassNotFoundException;
    String getNewEmployee() throws SQLException, ClassNotFoundException;
    String getEmployeeCount() throws SQLException, ClassNotFoundException;
    String getLastEmployeeId() throws SQLException, ClassNotFoundException;
}
