package lk.ijse.Library.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.Library.bo.BOFactory;
import lk.ijse.Library.bo.BOType;
import lk.ijse.Library.bo.custom.BookRecordBO;
import lk.ijse.Library.dao.DAOFactory;
import lk.ijse.Library.dao.DAOType;
import lk.ijse.Library.dao.custom.BookRecordDAO;
import lk.ijse.Library.dao.custom.impl.BookRecordDAOImpl;
import lk.ijse.Library.dto.BookRecordDTO;

import java.sql.SQLException;


public class BookRecordBOImpl implements BookRecordBO {

    BookRecordDAO bookRecordDAO= DAOFactory.getInstance().getDao(DAOType.BOOKRECORD);
    @Override
    public boolean AddBookRecord(BookRecordDTO bookRecordDTO) throws SQLException, ClassNotFoundException {
        return bookRecordDAO.Add(bookRecordDTO);
    }

    @Override
    public BookRecordDTO SearchBookRecord(String RecordId) throws SQLException, ClassNotFoundException {
        return bookRecordDAO.Search(RecordId);
    }

    @Override
    public boolean UpdateBookRecord(BookRecordDTO bookRecordDTO) throws SQLException, ClassNotFoundException {
        return bookRecordDAO.Update(bookRecordDTO);
    }

    @Override
    public boolean DeleteBookRecord(String Id) throws SQLException, ClassNotFoundException {
        return bookRecordDAO.delete(Id);
    }

    @Override
    public ObservableList<BookRecordDTO> getAllBookRecord() throws SQLException, ClassNotFoundException {
        return bookRecordDAO.getAllBookRecord();
    }

    @Override
    public String getIssueBookCount() throws SQLException, ClassNotFoundException {
        return bookRecordDAO.getIssueBookCount();
    }

    @Override
    public String getPendingReturnBooks() throws SQLException, ClassNotFoundException {
        return bookRecordDAO.getPendingReturnBooks();
    }

    @Override
    public String getNewBookRecord() throws SQLException, ClassNotFoundException {
        return bookRecordDAO.getNewBookRecord();
    }

    @Override
    public String getLastBookRecordId() throws SQLException, ClassNotFoundException {
        return bookRecordDAO.getLastBookRecordId();
    }

    @Override
    public boolean isAlreadyIssued(String bId) throws SQLException, ClassNotFoundException {
        return bookRecordDAO.isAlreadyIssued(bId);
    }

    @Override
    public String LateDate(String RecordId) throws SQLException, ClassNotFoundException {
        return bookRecordDAO.LateDate(RecordId);
    }
}
