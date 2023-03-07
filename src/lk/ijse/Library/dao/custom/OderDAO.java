package lk.ijse.Library.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.Library.dao.CrudDAO;
import lk.ijse.Library.dto.DonationDTO;
import lk.ijse.Library.dto.OderDTO;

import java.sql.SQLException;

public interface OderDAO extends CrudDAO<OderDTO,String> {
    ObservableList<OderDTO> getAllOder() throws SQLException, ClassNotFoundException;
    String getNewOder() throws SQLException, ClassNotFoundException;
    String getLastOderId() throws SQLException, ClassNotFoundException;
}
