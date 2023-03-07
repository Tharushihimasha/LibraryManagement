package lk.ijse.Library.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.Library.dto.MemberDTO;
import lk.ijse.Library.dao.CrudUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberModel {

   /* public static boolean AddMember(MemberDTO memberDTO) throws SQLException, ClassNotFoundException {
        Connection connection= db.DBConnection.getInstance().getConnection();
        return CrudUtil.execute("Insert Into Member Values(?,?,?,?)", memberDTO.getMemberId(), memberDTO.getMemberName(), memberDTO.getMemberAddress(), memberDTO.getMemberContact());
    }
    public static MemberDTO SearchMember(String MemberId) throws SQLException, ClassNotFoundException {
        Connection connection= db.DBConnection.getInstance().getConnection();
        PreparedStatement stm=connection.prepareStatement("SELECT*FROM member where Member_Id=?");
        stm.setObject(1,MemberId);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            MemberDTO memberDTO =new MemberDTO(rst.getString(1),rst.getString(2),rst.getString(3),rst.getInt(4));
            return memberDTO;
        }
        return null;
    }
    public static boolean UpdateMember(MemberDTO memberDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("Update member set Member_Name=?,Member_Address=?,Member_Contact=? where Member_Id=?",
                memberDTO.getMemberName(), memberDTO.getMemberAddress(), memberDTO.getMemberContact(), memberDTO.getMemberId());
    }
    public static boolean DeleteMember(String Id) throws SQLException, ClassNotFoundException {
        return db.DBConnection.getInstance().getConnection().createStatement().executeUpdate("Delete From member where Member_Id='"+Id+"'")>0;

    }
    public static ObservableList<MemberDTO> getAllMember() throws SQLException, ClassNotFoundException {
        ObservableList<MemberDTO> ob = FXCollections.observableArrayList();

        ResultSet rs = CrudUtil.execute("SELECT * FROM Member");

        while (true) {
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ob.add(new MemberDTO(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4)));
        }
        return ob;
    }

    public static String getNewMember() throws SQLException, ClassNotFoundException {
        String lastMemberId=getLastMemberId();
        if(lastMemberId==null){
            return "M-0001";
        }else {
            String[] split=lastMemberId.split("[M][-]");
            int lastDigits = Integer.parseInt(split[1]);
            lastDigits++;
            String newMemberId=String.format("M-%04d",lastDigits);
            return newMemberId;
        }
    }

    private static String getLastMemberId() throws SQLException, ClassNotFoundException {
        ResultSet rs = CrudUtil.execute("SELECT Member_Id from member order by Member_Id DESC limit 1");
        if(rs.next()){
            return rs.getString(1);
        }
        return null;
    }*/
}
