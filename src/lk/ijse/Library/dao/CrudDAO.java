package lk.ijse.Library.dao;

import lk.ijse.Library.dto.BookDTO;

import java.sql.SQLException;

public interface CrudDAO <T,ID> extends SuperDAO{
    boolean Add(T obj) throws SQLException, ClassNotFoundException;
     T Search(ID obj) throws SQLException, ClassNotFoundException;
    boolean Update(T obj) throws SQLException, ClassNotFoundException;
    boolean delete(ID obj) throws SQLException, ClassNotFoundException;
}
