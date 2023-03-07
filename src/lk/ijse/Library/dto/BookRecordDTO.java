package lk.ijse.Library.dto;

public class BookRecordDTO {
    private String RecordId;
    private String MemberId;
    private String BookId;
    private String IssueDate;
    private String ReturnDate;
    private String RecordStatus;

    public BookRecordDTO(){

    }
    public BookRecordDTO(String recordId, String memberId, String bookId, String issueDate, String returnDate, String recordStates){
        RecordId=recordId;
        MemberId=memberId;
        BookId=bookId;
        IssueDate=issueDate;
        ReturnDate=returnDate;
        RecordStatus=recordStates;
    }
    public String getRecordId() {
        return RecordId;
    }

    public void setRecordId(String recordId) {
        RecordId = recordId;
    }

    public String getMemberId() {
        return MemberId;
    }

    public void setMemberId(String memberId) {
        MemberId = memberId;
    }

    public String getBookId() {
        return BookId;
    }

    public void setBookId(String bookId) {
        BookId = bookId;
    }

    public String getIssueDate() {
        return IssueDate;
    }

    public void setIssueDate(String issueDate) {
        IssueDate = issueDate;
    }

    public String getReturnDate() {
        return ReturnDate;
    }

    public void setReturnDate(String returnDate) {
        ReturnDate = returnDate;
    }

    public String getRecordStates() {
        return RecordStatus;
    }

    public void setRecordStates(String recordStates) {
        RecordStatus = recordStates;
    }
}
