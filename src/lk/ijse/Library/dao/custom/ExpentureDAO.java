package lk.ijse.Library.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.Library.dao.CrudDAO;
import lk.ijse.Library.dto.DonationDTO;
import lk.ijse.Library.dto.ExpentureDTO;

import java.sql.SQLException;

public interface ExpentureDAO extends CrudDAO<ExpentureDTO,String> {
    ObservableList<ExpentureDTO> getAllExpenture() throws SQLException, ClassNotFoundException;
    String getNewExpenture() throws SQLException, ClassNotFoundException;
    String getLastExpentureId() throws SQLException, ClassNotFoundException;
}
