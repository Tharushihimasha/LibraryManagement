package lk.ijse.Library.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.Library.dto.EmployeeSalaryDTO;
import lk.ijse.Library.dao.CrudUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeSalaryModel {
  /*  public static boolean AddEmployeeSalary(EmployeeSalaryDTO employeeSalaryDTO) throws SQLException, ClassNotFoundException {
        Connection connection= db.DBConnection.getInstance().getConnection();
        return CrudUtil.execute("Insert Into Employee_Salary Values(?,?,?)", employeeSalaryDTO.getEmployeeId(), employeeSalaryDTO.getDate(),
                employeeSalaryDTO.getSalary());
    }
    public static EmployeeSalaryDTO SearchEmployeeSalary(String EmployeeId) throws SQLException, ClassNotFoundException {
        Connection connection= db.DBConnection.getInstance().getConnection();
        PreparedStatement stm=connection.prepareStatement("SELECT*FROM Employee_salary where Employee_Id=?");
        stm.setObject(1,EmployeeId);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            EmployeeSalaryDTO employeeSalaryDTO =new EmployeeSalaryDTO(rst.getString(1),rst.getDouble(3),rst.getString(2));
            return employeeSalaryDTO;
        }
        return null;
    }
    public static boolean UpdateEmployeeSalary(EmployeeSalaryDTO employeeSalaryDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("Update Employee_Salary set Employee_Amont=?,Employee_Date=? where Employee_Id=?",
                employeeSalaryDTO.getAmount(), employeeSalaryDTO.getDate(), employeeSalaryDTO.getEmployeeId());
    }
    public static boolean DeleteEmployeeSalary(String Id) throws SQLException, ClassNotFoundException {
        return db.DBConnection.getInstance().getConnection().createStatement().executeUpdate("Delete From Employee_Salary where Employee_Id='"+Id+"'")>0;
    }
    public static ObservableList<EmployeeSalaryDTO> getAllEmployeeSlary() throws SQLException, ClassNotFoundException {
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

    public static String getNewEmployeeSalary() throws SQLException, ClassNotFoundException {
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

    private static String getLastEmployeeId() throws SQLException, ClassNotFoundException {
        ResultSet rs = CrudUtil.execute("SELECT Employee_Id from Employee_Salary order by Employee_Id DESC limit 1");
        if(rs.next()){
            return rs.getString(1);
        }
        return null;
    }*/
}
