package lk.ijse.Library.dto;

public class DonationDTO {
    private String DonationId;
    private String DonaterName;
    private String DonationValue;
    private String DonationDate;

    public DonationDTO(){}
    public DonationDTO(String donationId, String donaterName, String donationValue, String donationDate){
        DonationId=donationId;
        DonaterName=donaterName;
        DonationValue=donationValue;
        DonationDate=donationDate;
    }
    public String getDonationId() {
        return DonationId;
    }

    public void setDonationId(String donationId) {
        DonationId = donationId;
    }

    public String getDonaterName() {
        return DonaterName;
    }

    public void setDonaterName(String donaterName) {
        DonaterName = donaterName;
    }

    public String getDonationValue() {
        return DonationValue;
    }

    public void setDonationValue(String donationValue) {
        DonationValue = donationValue;
    }

    public String getDonationDate() {
        return DonationDate;
    }

    public void setDonationDate(String donationDate) {
        DonationDate = donationDate;
    }
}
