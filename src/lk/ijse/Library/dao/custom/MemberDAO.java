package lk.ijse.Library.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.Library.dao.CrudDAO;
import lk.ijse.Library.dto.DonationDTO;
import lk.ijse.Library.dto.MemberDTO;

import java.sql.SQLException;

public interface MemberDAO extends CrudDAO<MemberDTO,String> {
    ObservableList<MemberDTO> getAllMember() throws SQLException, ClassNotFoundException;
    String getNewMember() throws SQLException, ClassNotFoundException;
    String getLastMemberId() throws SQLException, ClassNotFoundException;
}
