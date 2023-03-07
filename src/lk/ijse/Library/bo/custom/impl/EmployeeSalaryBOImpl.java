package lk.ijse.Library.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.Library.bo.custom.EmployeeSalaryBO;
import lk.ijse.Library.dao.DAOFactory;
import lk.ijse.Library.dao.DAOType;
import lk.ijse.Library.dao.custom.EmployeeSalaryDAO;
import lk.ijse.Library.dao.custom.impl.EmployeeSalaryDAOImpl;
import lk.ijse.Library.dto.EmployeeSalaryDTO;

import java.sql.SQLException;

public class EmployeeSalaryBOImpl implements EmployeeSalaryBO {
    EmployeeSalaryDAO employeeSalaryDAO= DAOFactory.getInstance().getDao(DAOType.EMPLOYEESALARY);
    @Override
    public boolean AddEmployeeSalary(EmployeeSalaryDTO employeeSalaryDTO) throws SQLException, ClassNotFoundException {
        return employeeSalaryDAO.Add(employeeSalaryDTO);
    }

    @Override
    public EmployeeSalaryDTO SearchEmployeeSalary(String EmployeeId) throws SQLException, ClassNotFoundException {
        return employeeSalaryDAO.Search(EmployeeId);
    }

    @Override
    public boolean UpdateEmployeeSalary(EmployeeSalaryDTO employeeSalaryDTO) throws SQLException, ClassNotFoundException {
        return employeeSalaryDAO.Update(employeeSalaryDTO);
    }

    @Override
    public boolean DeleteEmployeeSalary(String Id) throws SQLException, ClassNotFoundException {
        return employeeSalaryDAO.delete(Id);
    }

    @Override
    public ObservableList<EmployeeSalaryDTO> getAllEmployeeSlary() throws SQLException, ClassNotFoundException {
        return employeeSalaryDAO.getAllEmployeeSlary();
    }

    @Override
    public String getNewEmployeeSalary() throws SQLException, ClassNotFoundException {
        return employeeSalaryDAO.getNewEmployeeSalary();
    }

    @Override
    public String getLastEmployeeId() throws SQLException, ClassNotFoundException {
        return employeeSalaryDAO.getLastEmployeeId();
    }
}
