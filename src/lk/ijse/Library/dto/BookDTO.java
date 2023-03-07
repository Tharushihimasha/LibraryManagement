package lk.ijse.Library.dto;

public class BookDTO {
    private String BookId;
    private String BookName;
    private String BookCategory;
    private String BookISBM;
    private String Author;
    private Double BookPrice;
    private String BookShelf;
    private String OderId;

    public BookDTO(){

    }
    public BookDTO(String bookId, String bookName, String bookCategory, String bookISBM, String author, Double bookPrice, String bookShelf, String oderId) {
        BookId=bookId;
        BookName=bookName;
        BookCategory=bookCategory;
        BookISBM=bookISBM;
        Author=author;
        BookPrice=bookPrice;
        BookShelf=bookShelf;
        OderId=oderId;
    }
    public String getBookId() {
        return BookId;
    }

    public void setBookId(String bookId) {
        BookId = bookId;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getBookCategory() {
        return BookCategory;
    }

    public void setBookCategory(String bookCategory) {
        BookCategory = bookCategory;
    }

    public String getBookISBM() {
        return BookISBM;
    }

    public void setBookISBM(String bookISBM) {
        BookISBM = bookISBM;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public Double getBookPrice() {
        return BookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        BookPrice = bookPrice;
    }

    public String getBookShelf() {
        return BookShelf;
    }

    public void setBookShelf(String bookShelf) {
        BookShelf = bookShelf;
    }

    public String getOderId() {
        return OderId;
    }

    public void setOderId(String oderId) {
        OderId = oderId;
    }
}
