package lk.ijse.Library.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.Library.bo.SuperBO;
import lk.ijse.Library.dto.OderDTO;

import java.sql.SQLException;

public interface OderBO extends SuperBO {
    boolean AddOder(OderDTO oderDTO) throws SQLException, ClassNotFoundException;
    OderDTO SearchOder(String OderId) throws SQLException, ClassNotFoundException;
    boolean UpdateOder(OderDTO oderDTO) throws SQLException, ClassNotFoundException;
    boolean DeleteOder(String Id) throws SQLException, ClassNotFoundException;
    ObservableList<OderDTO> getAllOder() throws SQLException, ClassNotFoundException;
    String getNewOder() throws SQLException, ClassNotFoundException;
    String getLastOderId() throws SQLException, ClassNotFoundException;
}
