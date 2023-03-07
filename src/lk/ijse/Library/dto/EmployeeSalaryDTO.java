package lk.ijse.Library.dto;

public class EmployeeSalaryDTO extends EmployeeDTO {
   private String EmployeeId;
   private Double Amount;
   private String Date;

    public EmployeeSalaryDTO(){}
    public EmployeeSalaryDTO(String employeeId, Double amount, String date){
        EmployeeId=employeeId;
        Amount=amount;
        Date=date;

    }
    public String getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(String employeeId) {
        EmployeeId = employeeId;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
