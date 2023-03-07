package lk.ijse.Library.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.Library.dto.EmployeeDTO;
import lk.ijse.Library.dao.CrudUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeModel {
   /* public static boolean AddEmployee(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException {
        System.out.println(employeeDTO.getContact());

        return CrudUtil.execute("Insert Into Employee Values(?,?,?,?,?,?)", employeeDTO.getEmployeeId(),
                employeeDTO.getNic(), employeeDTO.getName(), employeeDTO.getAddress(), employeeDTO.getContact(), employeeDTO.getSalary());
    }
    public static EmployeeDTO SearchEmployee(String EmployeeId) throws SQLException, ClassNotFoundException {
        Connection connection= db.DBConnection.getInstance().getConnection();
        PreparedStatement stm=connection.prepareStatement("SELECT*FROM Employee where Employee_Id=?");
        stm.setObject(1,EmployeeId);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            EmployeeDTO employeeDTO =new EmployeeDTO(rst.getString(1),rst.getString(2),rst.getString(3),
                    rst.getString(4),rst.getInt(5),rst.getDouble(6));
            return employeeDTO;
        }
        return null;
    }
    public static boolean UpdateEmployee(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("Update Employee set Employee_Nic=?,Employee_Name=?,Employee_Address=?,Employee_Contact=?,Employee_Salary=? where Employee_Id=?",
                employeeDTO.getNic(), employeeDTO.getName(), employeeDTO.getAddress(), employeeDTO.getContact(), employeeDTO.getSalary(), employeeDTO.getEmployeeId());
    }
    public static boolean DeleteEmployee(String Id) throws SQLException, ClassNotFoundException {
        return db.DBConnection.getInstance().getConnection().createStatement().executeUpdate("Delete From employee where Employee_Id='"+Id+"'")>0;

    }
    public static ObservableList<EmployeeDTO> getAllEmployee() throws SQLException, ClassNotFoundException {
        ObservableList<EmployeeDTO> ob = FXCollections.observableArrayList();

        ResultSet rs = CrudUtil.execute("SELECT * FROM Employee");

        while (true) {
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ob.add(new EmployeeDTO(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getInt(5),
                    rs.getDouble(6)));
        }
        return ob;
    }

    public static String getNewEmployee() throws SQLException, ClassNotFoundException {
        String lastEmployeeId=getLastEmployeeId();
        if(lastEmployeeId==null){
            return "Em-0001";
        }else {
            String[] split=lastEmployeeId.split("[Em][-]");
            int lastDigits = Integer.parseInt(split[1]);
            lastDigits++;
            String newEmployeeId=String.format("Em-%04d",lastDigits);
            return newEmployeeId;
        }
    }
    public static String getEmployeeCount() throws SQLException, ClassNotFoundException {
        ResultSet rs=CrudUtil.execute("SELECT count(Employee_Id) from employee");
        if(rs.next()){
            return rs.getString(1);
        }
        return null;
    }

    private static String getLastEmployeeId() throws SQLException, ClassNotFoundException {
        ResultSet rs = CrudUtil.execute("SELECT Employee_Id from Employee order by Employee_Id DESC limit 1");
        if(rs.next()){
            return rs.getString(1);
        }
        return null;
    }*/
}
