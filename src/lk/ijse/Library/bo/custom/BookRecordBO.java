package lk.ijse.Library.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.Library.bo.SuperBO;
import lk.ijse.Library.dto.BookRecordDTO;

import java.sql.SQLException;

public interface BookRecordBO extends SuperBO {
     boolean AddBookRecord(BookRecordDTO bookRecordDTO) throws SQLException, ClassNotFoundException;
     BookRecordDTO SearchBookRecord(String RecordId) throws SQLException, ClassNotFoundException;
    boolean UpdateBookRecord(BookRecordDTO bookRecordDTO) throws SQLException, ClassNotFoundException;
    boolean DeleteBookRecord(String Id) throws SQLException, ClassNotFoundException;
    ObservableList<BookRecordDTO> getAllBookRecord() throws SQLException, ClassNotFoundException;
    String getIssueBookCount() throws SQLException, ClassNotFoundException;
    String getPendingReturnBooks() throws SQLException, ClassNotFoundException;
    String getNewBookRecord() throws SQLException, ClassNotFoundException;
    String getLastBookRecordId() throws SQLException, ClassNotFoundException;
    boolean isAlreadyIssued(String bId) throws SQLException, ClassNotFoundException;
    String LateDate(String RecordId) throws SQLException, ClassNotFoundException;

}
