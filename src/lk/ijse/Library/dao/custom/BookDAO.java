package lk.ijse.Library.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.Library.dao.CrudDAO;
import lk.ijse.Library.dto.BookDTO;

import java.sql.SQLException;

public interface BookDAO extends CrudDAO<BookDTO,String> {
    ObservableList<BookDTO> getAllBook() throws SQLException, ClassNotFoundException;
    String getNewBook() throws SQLException, ClassNotFoundException;
    String getLastBookId() throws SQLException, ClassNotFoundException;
    String getBookCount() throws SQLException, ClassNotFoundException;
    String getMemberCount() throws SQLException, ClassNotFoundException;
}
