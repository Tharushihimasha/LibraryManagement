package lk.ijse.Library.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.Library.dao.CrudDAO;
import lk.ijse.Library.dto.BookRecordDTO;
import lk.ijse.Library.dto.DonationDTO;

import java.sql.SQLException;

public interface DonationDAO extends CrudDAO<DonationDTO,String> {
    ObservableList<DonationDTO> getAllDonation() throws SQLException, ClassNotFoundException;
    String getNewDonation() throws SQLException, ClassNotFoundException;
    String getLastDonationId() throws SQLException, ClassNotFoundException;
}
