package lk.ijse.Library.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.Library.dao.CrudDAO;
import lk.ijse.Library.dto.BookDTO;
import lk.ijse.Library.dto.BookRecordDTO;

import java.sql.SQLException;

public interface BookRecordDAO extends CrudDAO<BookRecordDTO,String> {
    ObservableList<BookRecordDTO> getAllBookRecord() throws SQLException, ClassNotFoundException;
    String getIssueBookCount() throws SQLException, ClassNotFoundException;
    String getPendingReturnBooks() throws SQLException, ClassNotFoundException;
    String getNewBookRecord() throws SQLException, ClassNotFoundException;
    String getLastBookRecordId() throws SQLException, ClassNotFoundException;
    boolean isAlreadyIssued(String bId) throws SQLException, ClassNotFoundException;
    String LateDate(String RecordId) throws SQLException, ClassNotFoundException;
}
