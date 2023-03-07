package lk.ijse.Library.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.Library.dto.DonationDTO;
import lk.ijse.Library.dao.CrudUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DonationModel {
    /*public static boolean AddDonation(DonationDTO donationDTO) throws SQLException, ClassNotFoundException {
        Connection connection = db.DBConnection.getInstance().getConnection();
        return CrudUtil.execute("Insert Into Donetion Values(?,?,?,?)", donationDTO.getDonationId(), donationDTO.getDonaterName(),
                donationDTO.getDonationValue(), donationDTO.getDonationDate());
    }
    public static DonationDTO SearchDonation(String DonationId) throws SQLException, ClassNotFoundException {
        Connection connection= db.DBConnection.getInstance().getConnection();
        PreparedStatement stm=connection.prepareStatement("SELECT*FROM Donetion where Donetion_Id=?");
        stm.setObject(1,DonationId);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            DonationDTO donationDTO =new DonationDTO(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4));
            return donationDTO;
        }
        return null;
    }
    public static boolean UpdateDonation(DonationDTO donationDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("Update donetion set Doneter_Name=?,Donetion_Value=?,Donetion_Date=? where Donetion_Id=?",
                donationDTO.getDonaterName(), donationDTO.getDonationValue(), donationDTO.getDonationDate(), donationDTO.getDonationId());
    }
    public static boolean DeleteDonation(String Id) throws SQLException, ClassNotFoundException {
        return db.DBConnection.getInstance().getConnection().createStatement().executeUpdate("Delete From Donetion where Donetion_Id='" + Id + "'") > 0;

    }
        public static ObservableList<DonationDTO> getAllDonation() throws SQLException, ClassNotFoundException {
        ObservableList<DonationDTO> ob = FXCollections.observableArrayList();

        ResultSet rs = CrudUtil.execute("SELECT * FROM Donetion");

        while (true) {
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ob.add(new DonationDTO(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4)));
        }
        return ob;
    }

    public static String getNewDonation() throws SQLException, ClassNotFoundException {
        String lastDonationId=getLastDonationId();
        if(lastDonationId==null){
            return "D-0001";
        }else {
            String[] split=lastDonationId.split("[D][-]");
            int lastDigits = Integer.parseInt(split[1]);
            lastDigits++;
            String newDonationId=String.format("D-%04d",lastDigits);
            return newDonationId;
        }
    }

    private static String getLastDonationId() throws SQLException, ClassNotFoundException {
        ResultSet rs = CrudUtil.execute("SELECT Donetion_Id from Donetion order by Donetion_Id DESC limit 1");
        if(rs.next()){
            return rs.getString(1);
        }
        return null;
    }*/
}
