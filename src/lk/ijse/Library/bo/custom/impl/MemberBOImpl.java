package lk.ijse.Library.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.Library.bo.custom.MemberBO;
import lk.ijse.Library.dao.DAOFactory;
import lk.ijse.Library.dao.DAOType;
import lk.ijse.Library.dao.custom.MemberDAO;
import lk.ijse.Library.dao.custom.impl.MemberDAOImpl;
import lk.ijse.Library.dto.MemberDTO;

import java.sql.SQLException;

public class MemberBOImpl implements MemberBO {
    MemberDAO memberDAO= DAOFactory.getInstance().getDao(DAOType.MEMBER);
    @Override
    public boolean AddMember(MemberDTO memberDTO) throws SQLException, ClassNotFoundException {
        return memberDAO.Add(memberDTO);
    }

    @Override
    public MemberDTO SearchMember(String MemberId) throws SQLException, ClassNotFoundException {
        return memberDAO.Search(MemberId);
    }

    @Override
    public boolean UpdateMember(MemberDTO memberDTO) throws SQLException, ClassNotFoundException {
        return memberDAO.Update(memberDTO);
    }

    @Override
    public boolean DeleteMember(String Id) throws SQLException, ClassNotFoundException {
        return memberDAO.delete(Id);
    }

    @Override
    public ObservableList<MemberDTO> getAllMember() throws SQLException, ClassNotFoundException {
        return memberDAO.getAllMember();
    }

    @Override
    public String getNewMember() throws SQLException, ClassNotFoundException {
        return memberDAO.getNewMember();
    }

    @Override
    public String getLastMemberId() throws SQLException, ClassNotFoundException {
        return memberDAO.getLastMemberId();
    }
}
