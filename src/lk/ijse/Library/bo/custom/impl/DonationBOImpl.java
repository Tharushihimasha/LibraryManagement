package lk.ijse.Library.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.Library.bo.custom.DonationBO;
import lk.ijse.Library.dao.DAOFactory;
import lk.ijse.Library.dao.DAOType;
import lk.ijse.Library.dao.custom.DonationDAO;
import lk.ijse.Library.dao.custom.impl.DonationDAOImpl;
import lk.ijse.Library.dto.DonationDTO;

import java.sql.SQLException;

public class DonationBOImpl implements DonationBO {
    DonationDAO donationDAO= DAOFactory.getInstance().getDao(DAOType.DONATION);
    @Override
    public boolean AddDonation(DonationDTO donationDTO) throws SQLException, ClassNotFoundException {
        return donationDAO.Add(donationDTO);
    }

    @Override
    public DonationDTO SearchDonation(String DonationId) throws SQLException, ClassNotFoundException {
        return donationDAO.Search(DonationId);
    }

    @Override
    public boolean UpdateDonation(DonationDTO donationDTO) throws SQLException, ClassNotFoundException {
        return donationDAO.Update(donationDTO);
    }

    @Override
    public boolean DeleteDonation(String Id) throws SQLException, ClassNotFoundException {
        return donationDAO.delete(Id);
    }

    @Override
    public ObservableList<DonationDTO> getAllDonation() throws SQLException, ClassNotFoundException {
        return donationDAO.getAllDonation();
    }

    @Override
    public String getNewDonation() throws SQLException, ClassNotFoundException {
        return donationDAO.getNewDonation();
    }

    @Override
    public String getLastDonationId() throws SQLException, ClassNotFoundException {
        return donationDAO.getLastDonationId();
    }
}
