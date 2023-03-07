package lk.ijse.Library.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.Library.bo.SuperBO;
import lk.ijse.Library.dto.MemberDTO;

import java.sql.SQLException;

public interface MemberBO extends SuperBO {
    boolean AddMember(MemberDTO memberDTO) throws SQLException, ClassNotFoundException;
    MemberDTO SearchMember(String MemberId) throws SQLException, ClassNotFoundException;
    boolean UpdateMember(MemberDTO memberDTO) throws SQLException, ClassNotFoundException;
    boolean DeleteMember(String Id) throws SQLException, ClassNotFoundException;
    ObservableList<MemberDTO> getAllMember() throws SQLException, ClassNotFoundException;
    String getNewMember() throws SQLException, ClassNotFoundException;
    String getLastMemberId() throws SQLException, ClassNotFoundException;
}
