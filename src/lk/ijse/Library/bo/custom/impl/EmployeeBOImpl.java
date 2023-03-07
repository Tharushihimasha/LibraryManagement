package lk.ijse.Library.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.Library.bo.custom.EmployeeBO;
import lk.ijse.Library.dao.DAOFactory;
import lk.ijse.Library.dao.DAOType;
import lk.ijse.Library.dao.custom.EmployeeDAO;
import lk.ijse.Library.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.Library.dto.EmployeeDTO;

import java.sql.SQLException;

public class EmployeeBOImpl implements EmployeeBO {
    EmployeeDAO employeeDAO= DAOFactory.getInstance().getDao(DAOType.EMPLOYEE);
    @Override
    public boolean AddEmployee(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException {
        return employeeDAO.Add(employeeDTO);
    }

    @Override
    public EmployeeDTO SearchEmployee(String EmployeeId) throws SQLException, ClassNotFoundException {
        return employeeDAO.Search(EmployeeId);
    }

    @Override
    public boolean UpdateEmployee(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException {
        return employeeDAO.Update(employeeDTO);
    }

    @Override
    public boolean DeleteEmployee(String Id) throws SQLException, ClassNotFoundException {
        return employeeDAO.delete(Id);
    }

    @Override
    public ObservableList<EmployeeDTO> getAllEmployee() throws SQLException, ClassNotFoundException {
        return employeeDAO.getAllEmployee();
    }

    @Override
    public String getNewEmployee() throws SQLException, ClassNotFoundException {
        return employeeDAO.getNewEmployee();
    }

    @Override
    public String getEmployeeCount() throws SQLException, ClassNotFoundException {
        return employeeDAO.getEmployeeCount();
    }

    @Override
    public String getLastEmployeeId() throws SQLException, ClassNotFoundException {
        return employeeDAO.getLastEmployeeId();
    }
}
