package lk.ijse.Library.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.Library.dao.CrudUtil;
import lk.ijse.Library.dao.custom.BookDAO;
import lk.ijse.Library.db.DBConnection;
import lk.ijse.Library.dto.BookDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAOImpl implements BookDAO {
    public boolean Add(BookDTO bookDTO) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        return CrudUtil.execute("Insert Into Book Values(?,?,?,?,?,?,?,?)", bookDTO.getBookId(), bookDTO.getBookName(),
                bookDTO.getBookCategory(), bookDTO.getBookISBM(), bookDTO.getAuthor(), bookDTO.getBookPrice(),
                bookDTO.getBookShelf(), bookDTO.getOderId());
    }

    @Override
    public BookDTO Search(String BookId) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        PreparedStatement stm=connection.prepareStatement("SELECT*FROM book where Book_Id=?");
        stm.setObject(1,BookId);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            BookDTO bookDTO =new BookDTO(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),
                    rst.getString(5),rst.getDouble(6),rst.getString(7),rst.getString(8) );
            return bookDTO;
        }
        return null;
    }

    @Override
    public boolean Update(BookDTO bookDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("Update Book set Book_Name=?,Book_Category=?,Book_ISBM=?,Book_Author=?,Book_Price=?,Book_Shelf=?,OrderID=? where Book_Id=?",
                bookDTO.getBookName(), bookDTO.getBookCategory(), bookDTO.getBookISBM(), bookDTO.getAuthor(), bookDTO.getBookPrice(),
                bookDTO.getBookShelf(), bookDTO.getOderId(), bookDTO.getBookId());
    }

    @Override
    public boolean delete(String Id) throws SQLException, ClassNotFoundException {
        return DBConnection.getInstance().getConnection().createStatement().executeUpdate("Delete From book where Book_Id='"+Id+"'")>0;
    }

    @Override
    public ObservableList<BookDTO> getAllBook() throws SQLException, ClassNotFoundException {
        ObservableList<BookDTO> ob = FXCollections.observableArrayList();

        ResultSet rs = CrudUtil.execute("SELECT * FROM Book");

        while (true) {
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ob.add(new BookDTO(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getDouble(6),
                    rs.getString(7),
                    rs.getString(8)
            ));
        }
        return ob;
    }

    @Override
    public String getNewBook() throws SQLException, ClassNotFoundException {
        String lastBookId=getLastBookId();
        if(lastBookId==null){
            return "B-0001";
        }else {
            String[] split=lastBookId.split("[B][-]");
            int lastDigits = Integer.parseInt(split[1]);
            lastDigits++;
            String newBookId=String.format("B-%04d",lastDigits);
            return newBookId;
        }
    }

    @Override
    public String getLastBookId() throws SQLException, ClassNotFoundException {
        ResultSet rs = CrudUtil.execute("SELECT Book_Id from book order by Book_Id DESC limit 1");
        if(rs.next()){
            return rs.getString(1);
        }
        return null;
    }

    @Override
    public String getBookCount() throws SQLException, ClassNotFoundException {
        ResultSet rs = CrudUtil.execute("SELECT count(Book_Id) from book");
        if(rs.next()){
            return rs.getString(1);
        }
        return null;

    }

    @Override
    public String getMemberCount() throws SQLException, ClassNotFoundException {
        ResultSet rs=CrudUtil.execute("SELECT count(Member_Id) from member");
        if(rs.next()){
            return rs.getString(1);
        }
        return null;
    }
}
