package lk.ijse.Library.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.Library.dao.CrudDAO;
import lk.ijse.Library.dto.DonationDTO;
import lk.ijse.Library.dto.EmployeeDTO;

import java.sql.SQLException;

public interface EmployeeDAO extends CrudDAO<EmployeeDTO,String> {
    ObservableList<EmployeeDTO> getAllEmployee() throws SQLException, ClassNotFoundException;
    String getNewEmployee() throws SQLException, ClassNotFoundException;
    String getEmployeeCount() throws SQLException, ClassNotFoundException;
    String getLastEmployeeId() throws SQLException, ClassNotFoundException;
}
