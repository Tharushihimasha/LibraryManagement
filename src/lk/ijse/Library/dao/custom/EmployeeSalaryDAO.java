package lk.ijse.Library.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.Library.dao.CrudDAO;
import lk.ijse.Library.dto.DonationDTO;
import lk.ijse.Library.dto.EmployeeDTO;
import lk.ijse.Library.dto.EmployeeSalaryDTO;

import java.sql.SQLException;

public interface EmployeeSalaryDAO extends CrudDAO<EmployeeSalaryDTO,String> {
    ObservableList<EmployeeSalaryDTO> getAllEmployeeSlary() throws SQLException, ClassNotFoundException;
    String getNewEmployeeSalary() throws SQLException, ClassNotFoundException;
    String getLastEmployeeId() throws SQLException, ClassNotFoundException;
}
