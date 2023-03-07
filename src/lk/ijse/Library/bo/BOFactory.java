package lk.ijse.Library.bo;

import lk.ijse.Library.bo.custom.impl.*;

public class BOFactory{
    private static BOFactory boFactory;
    private BOFactory(){}

    public static BOFactory getInstance(){
        if(boFactory==null)boFactory=new BOFactory();
        return boFactory;
    }
    public <T extends SuperBO>T getBo(BOType boType){
        switch (boType){
            case BOOK:return (T)new BookBOImpl();
            case BOOKRECORD:return (T)new BookRecordBOImpl();
            case DONESTION:return (T)new DonationBOImpl();
            case EMPLOYEE:return (T)new EmployeeBOImpl();
            case EMPLOYEESALARY:return (T)new EmployeeSalaryBOImpl();
            case EXPENTURE:return (T)new ExpentureBOImpl();
            case FINE:return (T)new FineBOImpl();
            case MEMBER:return (T)new MemberBOImpl();
            case ODER:return (T)new OderBOImpl();
        }
        return null;
    }
}
