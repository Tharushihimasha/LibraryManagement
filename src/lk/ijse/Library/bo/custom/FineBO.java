package lk.ijse.Library.bo.custom;

import lk.ijse.Library.bo.SuperBO;
import lk.ijse.Library.dto.FineDTO;

import java.sql.SQLException;
import java.util.HashMap;

public interface FineBO extends SuperBO {
    boolean addFine(FineDTO fine) throws SQLException, ClassNotFoundException;
    HashMap getIncomeByMonthlyFroChart(int year) throws SQLException, ClassNotFoundException;
}
