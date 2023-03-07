package lk.ijse.Library.bo.custom.impl;

import lk.ijse.Library.bo.custom.FineBO;
import lk.ijse.Library.dao.DAOFactory;
import lk.ijse.Library.dao.DAOType;
import lk.ijse.Library.dao.custom.FineDAO;
import lk.ijse.Library.dao.custom.impl.FineDAOImpl;
import lk.ijse.Library.dto.FineDTO;

import java.sql.SQLException;
import java.util.HashMap;

public class FineBOImpl implements FineBO {
    FineDAO fineDAO= DAOFactory.getInstance().getDao(DAOType.FINE);
    @Override
    public boolean addFine(FineDTO fine) throws SQLException, ClassNotFoundException {
        return fineDAO.Add(fine);
    }

    @Override
    public HashMap getIncomeByMonthlyFroChart(int year) throws SQLException, ClassNotFoundException {
        return fineDAO.getIncomeByMonthlyFroChart(year);
    }
}
