package lk.ijse.Library.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.Library.bo.custom.ExpentureBO;
import lk.ijse.Library.dao.DAOFactory;
import lk.ijse.Library.dao.DAOType;
import lk.ijse.Library.dao.custom.ExpentureDAO;
import lk.ijse.Library.dao.custom.impl.ExpentureDAOImpl;
import lk.ijse.Library.dto.ExpentureDTO;

import java.sql.SQLException;

public class ExpentureBOImpl implements ExpentureBO {
    ExpentureDAO expentureDAO= DAOFactory.getInstance().getDao(DAOType.EXPENTURE);
    @Override
    public boolean AddExpenture(ExpentureDTO expentureDTO) throws SQLException, ClassNotFoundException {
        return expentureDAO.Add(expentureDTO);
    }

    @Override
    public ExpentureDTO SearchExpenture(String InvoiceNumber) throws SQLException, ClassNotFoundException {
        return expentureDAO.Search(InvoiceNumber);
    }

    @Override
    public boolean UpdateExpenture(ExpentureDTO expentureDTO) throws SQLException, ClassNotFoundException {
        return expentureDAO.Update(expentureDTO);
    }

    @Override
    public boolean DeleteExpenture(String Id) throws SQLException, ClassNotFoundException {
        return expentureDAO.delete(Id);
    }

    @Override
    public ObservableList<ExpentureDTO> getAllExpenture() throws SQLException, ClassNotFoundException {
        return expentureDAO.getAllExpenture();
    }

    @Override
    public String getNewExpenture() throws SQLException, ClassNotFoundException {
        return expentureDAO.getNewExpenture();
    }

    @Override
    public String getLastExpentureId() throws SQLException, ClassNotFoundException {
        return expentureDAO.getLastExpentureId();
    }
}
