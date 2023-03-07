package lk.ijse.Library.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.Library.dto.OderDTO;
import lk.ijse.Library.dao.CrudUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OderModel {
   /* public static boolean AddOder(OderDTO oderDTO) throws SQLException, ClassNotFoundException {
        Connection connection= db.DBConnection.getInstance().getConnection();
        return CrudUtil.execute("Insert into Oder values(?,?,?,?)", oderDTO.getOderId(), oderDTO.getOderType(), oderDTO.getOderPrice(),
                oderDTO.getOderDate());
    }
    public static OderDTO SearchOder(String OderId) throws SQLException, ClassNotFoundException {
        Connection connection= db.DBConnection.getInstance().getConnection();
        PreparedStatement stm=connection.prepareStatement("SELECT*FROM oder where Oder_Id=?");
        stm.setObject(1,OderId);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            OderDTO oderDTO =new OderDTO(rst.getString(1),rst.getString(2),rst.getDouble(3),rst.getString(4));
            return oderDTO;
        }
        return null;
    }
    public static boolean UpdateOder(OderDTO oderDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("Update oder set Order_Type=?,Oder_Price=?,Oder_Date=? where Oder_Id=?",
                oderDTO.getOderType(), oderDTO.getOderPrice(), oderDTO.getOderDate(), oderDTO.getOderId());
    }
    public static boolean DeleteOder(String Id) throws SQLException, ClassNotFoundException {
        return db.DBConnection.getInstance().getConnection().createStatement().executeUpdate("Delete From oder where Oder_Id='"+Id+"'")>0;

    }

    public static ObservableList<OderDTO> getAllOder() throws SQLException, ClassNotFoundException {
        ObservableList<OderDTO> ob = FXCollections.observableArrayList();

        ResultSet rs = CrudUtil.execute("SELECT * FROM Oder");

        while (true) {
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ob.add(new OderDTO(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getDouble(3),
                    rs.getString(4)));
        }
        return ob;
    }

    public static String getNewOder() throws SQLException, ClassNotFoundException {
        String lastOderId=getLastOderId();
        if(lastOderId==null){
            return "O-0001";
        }else {
            String[] split=lastOderId.split("[O][-]");
            int lastDigits = Integer.parseInt(split[1]);
            lastDigits++;
            String newOderId=String.format("O-%04d",lastDigits);
            return newOderId;
        }
    }

    private static String getLastOderId() throws SQLException, ClassNotFoundException {
        ResultSet rs = CrudUtil.execute("SELECT Oder_Id from oder order by Oder_Id DESC limit 1");
        if(rs.next()){
            return rs.getString(1);
        }
        return null;
    }*/
}
