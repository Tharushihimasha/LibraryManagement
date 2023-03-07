package lk.ijse.Library.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.Library.bo.SuperBO;
import lk.ijse.Library.dto.BookDTO;

import java.sql.SQLException;

public interface BookBO extends SuperBO {
    boolean AddBook(BookDTO bookDTO) throws SQLException, ClassNotFoundException;
    BookDTO SearchBook(String BookId) throws SQLException, ClassNotFoundException;
    boolean UpdateBook(BookDTO bookDTO) throws SQLException, ClassNotFoundException;
    boolean DeleteBook(String Id) throws SQLException, ClassNotFoundException;
    ObservableList<BookDTO> getAllBook() throws SQLException, ClassNotFoundException;
    String getNewBook() throws SQLException, ClassNotFoundException;
    String getLastBookId() throws SQLException, ClassNotFoundException;
    String getBookCount() throws SQLException, ClassNotFoundException;
    String getMemberCount() throws SQLException, ClassNotFoundException;
}
