package lk.ijse.Library.dto;

public class OderDTO extends BookDTO {
    private String OderId;
    private String OderType;
    private double OderPrice;
    private String OderDate;

    public OderDTO() {
    }

    public OderDTO(String oderId, String oderType, Double oderPrice, String oderDate){
        OderId=oderId;
        OderType=oderType;
        OderPrice=oderPrice;
        OderDate=oderDate;
    }
    public String getOderId() {
        return OderId;
    }

    public void setOderId(String oderId) {
        OderId = oderId;
    }

    public String getOderType() {
        return OderType;
    }

    public void setOderType(String oderType) {
        OderType = oderType;
    }

    public double getOderPrice() {
        return OderPrice;
    }

    public void setOderPrice(double oderPrice) {
        OderPrice = oderPrice;
    }

    public String getOderDate() {
        return OderDate;
    }

    public void setOderDate(String oderDate) {
        OderDate = oderDate;
    }
}
