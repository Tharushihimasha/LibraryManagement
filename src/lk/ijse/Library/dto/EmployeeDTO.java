package lk.ijse.Library.dto;

public class EmployeeDTO {
    private String EmployeeId;
    private String Nic;
    private String Name;
    private String Address;
    private int Contact;
    private double Salary;

    public EmployeeDTO(){}
    public EmployeeDTO(String employeeId, String nic, String name, String address, int contact, double salary){
       EmployeeId=employeeId;
       Nic=nic;
       Contact=contact;
       Name=name;
       Address=address;
       Salary=salary;
    }
    public String getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(String employeeId) {
        EmployeeId = employeeId;
    }

    public String getNic() {
        return Nic;
    }

    public void setNic(String nic) {
        Nic = nic;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getContact() {
        return Contact;
    }

    public void setContact(int contact) {
        Contact = contact;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }
}
