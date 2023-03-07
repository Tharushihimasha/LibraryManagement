package lk.ijse.Library.dto;

public class MemberDTO {
    private String MemberId;
    private String MemberName;
    private String MemberAddress;
    private int MemberContact;

    public MemberDTO(){

    }

    public MemberDTO(String memberId, String memberName, String memberAddress, int memberContact) {
        MemberId = memberId;
        MemberName=memberName;
        MemberAddress=memberAddress;
        MemberContact=memberContact;
    }

    public String getMemberId() {
        return MemberId;
    }

    public void setMemberId(String memberId) {
        MemberId = memberId;
    }

    public String getMemberName() {
        return MemberName;
    }

    public void setMemberName(String memberName) {
        MemberName = memberName;
    }

    public String getMemberAddress() {
        return MemberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        MemberAddress = memberAddress;
    }

    public int getMemberContact() {
        return MemberContact;
    }

    public void setMemberContact(int memberContact) {
        MemberContact = memberContact;
    }

    public String toString(){
        return "Member{"+
                "id='"+MemberId+'\''+
                ", name+'"+MemberName+'\''+
                ",address+'"+MemberAddress+'\''+
                ",contact+'"+MemberContact+'}';
    }
}
