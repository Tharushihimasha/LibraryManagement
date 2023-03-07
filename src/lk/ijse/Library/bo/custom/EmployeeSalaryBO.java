package lk.ijse.Library.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.Library.bo.SuperBO;
import lk.ijse.Library.dto.EmployeeSalaryDTO;

import java.sql.SQLException;

public interface EmployeeSalaryBO extends SuperBO {
    boolean AddEmployeeSalary(EmployeeSalaryDTO employeeSalaryDTO) throws SQLException, ClassNotFoundException;
    EmployeeSalaryDTO SearchEmployeeSalary(String EmployeeId) throws SQLException, ClassNotFoundException;
    boolean UpdateEmployeeSalary(EmployeeSalaryDTO employeeSalaryDTO) throws SQLException, ClassNotFoundException;
    boolean DeleteEmployeeSalary(String Id) throws SQLException, ClassNotFoundException;
    ObservableList<EmployeeSalaryDTO> getAllEmployeeSlary() throws SQLException, ClassNotFoundException;
    String getNewEmployeeSalary() throws SQLException, ClassNotFoundException;
    String getLastEmployeeId() throws SQLException, ClassNotFoundException;
}
