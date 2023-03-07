package lk.ijse.Library.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.Library.dao.CrudUtil;
import lk.ijse.Library.dao.custom.EmployeeSalaryDAO;
import lk.ijse.Library.db.DBConnection;
import lk.ijse.Library.dto.EmployeeDTO;
import lk.ijse.Library.dto.EmployeeSalaryDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeSalaryDAOImpl implements EmployeeSalaryDAO {

    @Override
    public boolean Add(EmployeeSalaryDTO employeeSalaryDTO) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        return CrudUtil.execute("Insert Into Employee_Salary Values(?,?,?)", employeeSalaryDTO.getEmployeeId(), employeeSalaryDTO.getDate(),
                employeeSalaryDTO.getSalary());
    }

    @Override
    public EmployeeSalaryDTO Search(String EmployeeId) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        PreparedStatement stm=connection.prepareStatement("SELECT*FROM Employee_salary where Employee_Id=?");
        stm.setObject(1,EmployeeId);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            EmployeeSalaryDTO employeeSalaryDTO =new EmployeeSalaryDTO(rst.getString(1),rst.getDouble(3),rst.getString(2));
            return employeeSalaryDTO;
        }
        return null;
    }

    @Override
    public boolean Update(EmployeeSalaryDTO employeeSalaryDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("Update Employee_Salary set Employee_Amont=?,Employee_Date=? where Employee_Id=?",
                employeeSalaryDTO.getAmount(), employeeSalaryDTO.getDate(), employeeSalaryDTO.getEmployeeId());
    }

    @Override
    public boolean delete(String Id) throws SQLException, ClassNotFoundException {
        return DBConnection.getInstance().getConnection().createStatement().executeUpdate("Delete From Employee_Salary where Employee_Id='"+Id+"'")>0;
    }

    @Override
    public ObservableList<EmployeeSalaryDTO> getAllEmployeeSlary() throws SQLException, ClassNotFoundException {
        ObservableList<EmployeeSalaryDTO> ob = FXCollections.observableArrayList();

        ResultSet rs = CrudUtil.execute("SELECT * FROM Employee_Salary");

        while (true) {
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ob.add(new EmployeeSalaryDTO(
                    rs.getString(1),
                    rs.getDouble(3),
                    rs.getString(2)));
        }
        return ob;
    }

    @Override
    public String getNewEmployeeSalary() throws SQLException, ClassNotFoundException {
        String lastEmployeeId=getLastEmployeeId();
        if(lastEmployeeId==null){
            return "E-0001";
        }else {
            String[] split=lastEmployeeId.split("[E][-]");
            int lastDigits = Integer.parseInt(split[1]);
            lastDigits++;
            String newEmployeeId=String.format("E-%04d",lastDigits);
            return newEmployeeId;
        }
    }

    @Override
    public String getLastEmployeeId() throws SQLException, ClassNotFoundException {
        ResultSet rs = CrudUtil.execute("SELECT Employee_Id from Employee_Salary order by Employee_Id DESC limit 1");
        if(rs.next()){
            return rs.getString(1);
        }
        return null;
    }
}
