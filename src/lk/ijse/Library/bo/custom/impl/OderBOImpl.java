package lk.ijse.Library.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.Library.bo.custom.OderBO;
import lk.ijse.Library.dao.DAOFactory;
import lk.ijse.Library.dao.DAOType;
import lk.ijse.Library.dao.custom.OderDAO;
import lk.ijse.Library.dao.custom.impl.OderDAOImpl;
import lk.ijse.Library.dto.OderDTO;

import java.sql.SQLException;

public class OderBOImpl implements OderBO {
    OderDAO oderDAO= DAOFactory.getInstance().getDao(DAOType.ODER);
    @Override
    public boolean AddOder(OderDTO oderDTO) throws SQLException, ClassNotFoundException {
        return oderDAO.Add(oderDTO);
    }

    @Override
    public OderDTO SearchOder(String OderId) throws SQLException, ClassNotFoundException {
        return oderDAO.Search(OderId);
    }

    @Override
    public boolean UpdateOder(OderDTO oderDTO) throws SQLException, ClassNotFoundException {
        return oderDAO.Update(oderDTO);
    }

    @Override
    public boolean DeleteOder(String Id) throws SQLException, ClassNotFoundException {
        return oderDAO.delete(Id);
    }

    @Override
    public ObservableList<OderDTO> getAllOder() throws SQLException, ClassNotFoundException {
        return oderDAO.getAllOder();
    }

    @Override
    public String getNewOder() throws SQLException, ClassNotFoundException {
        return oderDAO.getNewOder();
    }

    @Override
    public String getLastOderId() throws SQLException, ClassNotFoundException {
        return oderDAO.getLastOderId();
    }
}
