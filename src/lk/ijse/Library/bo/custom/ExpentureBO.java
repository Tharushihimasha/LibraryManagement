package lk.ijse.Library.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.Library.bo.SuperBO;
import lk.ijse.Library.dto.ExpentureDTO;

import java.sql.SQLException;

public interface ExpentureBO extends SuperBO {
    boolean AddExpenture(ExpentureDTO expentureDTO) throws SQLException, ClassNotFoundException;
    ExpentureDTO SearchExpenture(String InvoiceNumber) throws SQLException, ClassNotFoundException;
    boolean UpdateExpenture(ExpentureDTO expentureDTO) throws SQLException, ClassNotFoundException;
    boolean DeleteExpenture(String Id) throws SQLException, ClassNotFoundException;
    ObservableList<ExpentureDTO> getAllExpenture() throws SQLException, ClassNotFoundException;
    String getNewExpenture() throws SQLException, ClassNotFoundException;
    String getLastExpentureId() throws SQLException, ClassNotFoundException;
}
