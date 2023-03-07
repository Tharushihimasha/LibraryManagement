package lk.ijse.Library.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.Library.bo.SuperBO;
import lk.ijse.Library.dto.DonationDTO;

import java.sql.SQLException;

public interface DonationBO extends SuperBO {
    boolean AddDonation(DonationDTO donationDTO) throws SQLException, ClassNotFoundException;
    DonationDTO SearchDonation(String DonationId) throws SQLException, ClassNotFoundException;
    boolean UpdateDonation(DonationDTO donationDTO) throws SQLException, ClassNotFoundException;
    boolean DeleteDonation(String Id) throws SQLException, ClassNotFoundException;
    ObservableList<DonationDTO> getAllDonation() throws SQLException, ClassNotFoundException;
    String getNewDonation() throws SQLException, ClassNotFoundException;
    String getLastDonationId() throws SQLException, ClassNotFoundException;
}
