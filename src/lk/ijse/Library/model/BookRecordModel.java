package lk.ijse.Library.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.Library.dto.BookRecordDTO;
import lk.ijse.Library.dao.CrudUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRecordModel {
    /*public static boolean AddBookRecord(BookRecordDTO bookRecordDTO) throws SQLException, ClassNotFoundException {
        Connection connection= db.DBConnection.getInstance().getConnection();
        return CrudUtil.execute("Insert Into Book_Record Values(?,?,?,?,?,?)", bookRecordDTO.getRecordId(), bookRecordDTO.getMemberId(),
                bookRecordDTO.getBookId(), bookRecordDTO.getIssueDate(), bookRecordDTO.getReturnDate(), bookRecordDTO.getRecordStates());
    }
    public static BookRecordDTO SearchBookRecord(String RecordId) throws SQLException, ClassNotFoundException {
        Connection connection= db.DBConnection.getInstance().getConnection();
        PreparedStatement stm=connection.prepareStatement("SELECT*FROM Book_Record where BookRecord_Id=?");
        stm.setObject(1,RecordId);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            BookRecordDTO bookRecordDTO =new BookRecordDTO(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6));
            return bookRecordDTO;
        }
        return null;
    }
    public static boolean UpdateBookRecord(BookRecordDTO bookRecordDTO) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("Update Book_Record set Member_Id=?,Book_Id=?,Issue_Date=?,Return_Date=?,Stutes=? where BookRecord_Id=?",
                bookRecordDTO.getMemberId(), bookRecordDTO.getBookId(), bookRecordDTO.getIssueDate(),
                bookRecordDTO.getReturnDate(), bookRecordDTO.getRecordStates(), bookRecordDTO.getRecordId());
    }
    public static boolean DeleteBookRecord(String Id) throws SQLException, ClassNotFoundException {
        return db.DBConnection.getInstance().getConnection().createStatement().executeUpdate("Delete From Book_Record where BookRecord_Id='"+Id+"'")>0;

    }
    public static ObservableList<BookRecordDTO> getAllBookRecord() throws SQLException, ClassNotFoundException {
        ObservableList<BookRecordDTO> ob = FXCollections.observableArrayList();

        ResultSet rs = CrudUtil.execute("SELECT * FROM Book_Record");

        while (true) {
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ob.add(new BookRecordDTO(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6)));
        }
        return ob;
    }
    public static String getIssueBookCount() throws SQLException, ClassNotFoundException {
        ResultSet rs=CrudUtil.execute("SELECT count(BookRecord_Id) from book_record");
        if(rs.next()){
            return rs.getString(1);
        }
        return null;
    }
    public static String getPendingReturnBooks() throws SQLException, ClassNotFoundException {
        ResultSet rs=CrudUtil.execute("SELECT count(Stutes) from book_record where Stutes = 'Issued'");
        if(rs.next()){
            return rs.getString(1);
        }
        return null;
    }

    public static String getNewBookRecord() throws SQLException, ClassNotFoundException {
        String lastBookRecordId=getLastBookRecordId();
        if(lastBookRecordId==null){
            return "R-0001";
        }else {
            String[] split=lastBookRecordId.split("[R][-]");
            int lastDigits = Integer.parseInt(split[1]);
            lastDigits++;
            String newBookRecordId=String.format("R-%04d",lastDigits);
            return newBookRecordId;
        }
    }

    private static String getLastBookRecordId() throws SQLException, ClassNotFoundException {
        ResultSet rs = CrudUtil.execute("SELECT BookRecord_Id from Book_Record order by BookRecord_Id DESC limit 1");
        if(rs.next()){
            return rs.getString(1);
        }
        return null;
    }
    public static boolean isAlreadyIssued(String bId) throws SQLException, ClassNotFoundException {
        ResultSet rs = CrudUtil.execute("SELECT * from book_record where book_id = ? and Stutes = 'Issued'", bId);
        if(rs.next()){
            return true;
        }
        return false;
    }
    public static String LateDate(String RecordId) throws SQLException, ClassNotFoundException {
        ResultSet rs = CrudUtil.execute("SELECT DATEDIFF(Now(),Return_Date) AS DateDiff from book_record where BookRecord_Id = ?",RecordId);
        if(rs.next()){
            return rs.getString(1);
        }
        return null;
    }
*/

}
