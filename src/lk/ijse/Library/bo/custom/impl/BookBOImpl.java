package lk.ijse.Library.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.Library.bo.custom.BookBO;
import lk.ijse.Library.dao.DAOFactory;
import lk.ijse.Library.dao.DAOType;
import lk.ijse.Library.dao.custom.BookDAO;
import lk.ijse.Library.dao.custom.impl.BookDAOImpl;
import lk.ijse.Library.dto.BookDTO;

import java.sql.SQLException;

public class BookBOImpl implements BookBO {
    BookDAO bookDAO= DAOFactory.getInstance().getDao(DAOType.BOOK);
    @Override
    public boolean AddBook(BookDTO bookDTO) throws SQLException, ClassNotFoundException {
        return bookDAO.Add(bookDTO);
    }

    @Override
    public BookDTO SearchBook(String BookId) throws SQLException, ClassNotFoundException {
        return bookDAO.Search(BookId);
    }

    @Override
    public boolean UpdateBook(BookDTO bookDTO) throws SQLException, ClassNotFoundException {
        return bookDAO.Update(bookDTO);
    }

    @Override
    public boolean DeleteBook(String Id) throws SQLException, ClassNotFoundException {
        return bookDAO.delete(Id);
    }

    @Override
    public ObservableList<BookDTO> getAllBook() throws SQLException, ClassNotFoundException {
        return bookDAO.getAllBook();
    }

    @Override
    public String getNewBook() throws SQLException, ClassNotFoundException {
        return bookDAO.getNewBook();
    }

    @Override
    public String getLastBookId() throws SQLException, ClassNotFoundException {
        return bookDAO.getLastBookId();
    }

    @Override
    public String getBookCount() throws SQLException, ClassNotFoundException {
        return bookDAO.getBookCount();
    }

    @Override
    public String getMemberCount() throws SQLException, ClassNotFoundException {
        return bookDAO.getMemberCount();
    }
}
