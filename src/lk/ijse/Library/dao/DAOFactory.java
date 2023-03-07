package lk.ijse.Library.dao;

import lk.ijse.Library.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){}

    public static DAOFactory getInstance(){
        if(daoFactory==null)daoFactory=new DAOFactory();
        return daoFactory;
    }
    public <T extends SuperDAO>T getDao(DAOType daoType){
        switch (daoType){
            case BOOK:return (T)new BookDAOImpl();
            case BOOKRECORD:return (T)new BookRecordDAOImpl();
            case DONATION:return (T)new DonationDAOImpl();
            case EMPLOYEE:return (T)new EmployeeDAOImpl();
            case EMPLOYEESALARY:return (T)new EmployeeSalaryDAOImpl();
            case EXPENTURE:return (T)new ExpentureDAOImpl();
            case FINE:return (T)new FineDAOImpl();
            case MEMBER:return (T)new MemberDAOImpl();
            case ODER:return (T)new OderDAOImpl();
        }
        return null;
    }
}
