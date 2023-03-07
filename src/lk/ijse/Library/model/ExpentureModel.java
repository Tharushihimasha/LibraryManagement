package lk.ijse.Library.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.Library.dto.ExpentureDTO;
import lk.ijse.Library.dao.CrudUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExpentureModel {
  /*  public static boolean AddExpenture(ExpentureDTO expentureDTO) throws SQLException, ClassNotFoundException {
        Connection connection= db.DBConnection.getInstance().getConnection();
        return CrudUtil.execute("Insert Into Expenture Values(?,?,?,?)", expentureDTO.getInVoiceNumber(), expentureDTO.getDescription(), expentureDTO.getDate(),
                expentureDTO.getPayment());
    }
    public static ExpentureDTO SearchExpenture(String InvoiceNumber) throws SQLException, ClassNotFoundException {
        Connection connection= db.DBConnection.getInstance().getConnection();
        PreparedStatement stm=connection.prepareStatement("SELECT*FROM Expenture where Invoice_Number=?");
        stm.setObject(1,InvoiceNumber);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            ExpentureDTO expentureDTO =new ExpentureDTO(rst.getString(1),rst.getString(2),rst.getString(3),rst.getDouble(4));
            return expentureDTO;
        }
        return null;
    }
    public static boolean UpdateExpenture(ExpentureDTO expentureDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("Update Expenture set Expenture_Description=?,Expenture_Date=?,Expenture_Payment=? where Invoice_Number=?",
                expentureDTO.getDescription(), expentureDTO.getDate(), expentureDTO.getPayment(), expentureDTO.getInVoiceNumber());
    }
    public static boolean DeleteExpenture(String Id) throws SQLException, ClassNotFoundException {
        return db.DBConnection.getInstance().getConnection().createStatement().executeUpdate("Delete From Expenture where Invoice_Number='"+Id+"'")>0;

    }
    public static ObservableList<ExpentureDTO> getAllExpenture() throws SQLException, ClassNotFoundException {
        ObservableList<ExpentureDTO> ob = FXCollections.observableArrayList();

        ResultSet rs = CrudUtil.execute("SELECT * FROM Expenture");

        while (true) {
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ob.add(new ExpentureDTO(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getDouble(4)));
        }
        return ob;
    }

    public static String getNewExpenture() throws SQLException, ClassNotFoundException {
        String lastExpentureId=getLastExpentureId();
        if(lastExpentureId==null){
            return "E-0001";
        }else {
            String[] split=lastExpentureId.split("[E][-]");
            int lastDigits = Integer.parseInt(split[1]);
            lastDigits++;
            String newExpentureId=String.format("E-%04d",lastDigits);
            return newExpentureId;
        }
    }

    private static String getLastExpentureId() throws SQLException, ClassNotFoundException {
        ResultSet rs = CrudUtil.execute("SELECT Invoice_Number from expenture order by Invoice_Number DESC limit 1");
        if(rs.next()){
            return rs.getString(1);
        }
        return null;
    }*/
}
