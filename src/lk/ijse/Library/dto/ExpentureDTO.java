package lk.ijse.Library.dto;

public class ExpentureDTO {
    private String InVoiceNumber;
    private String Description;
    private String Date;
    private Double Payment;

    public ExpentureDTO(){

    }
    public ExpentureDTO(String inVoiceNumber, String description, String date, Double payment){
        InVoiceNumber=inVoiceNumber;
        Description=description;
        Date=date;
        Payment=payment;
    }
    public String getInVoiceNumber() {
        return InVoiceNumber;
    }

    public void setInVoiceNumber(String inVoiceNumber) {
        InVoiceNumber = inVoiceNumber;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public Double getPayment() {
        return Payment;
    }

    public void setPayment(Double payment) {
        Payment = payment;
    }
}
