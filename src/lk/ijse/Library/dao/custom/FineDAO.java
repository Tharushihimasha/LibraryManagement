package lk.ijse.Library.dao.custom;

import lk.ijse.Library.dao.CrudDAO;
import lk.ijse.Library.dto.DonationDTO;
import lk.ijse.Library.dto.FineDTO;

import java.sql.SQLException;
import java.util.HashMap;

public interface FineDAO extends CrudDAO<FineDTO,String> {
    HashMap getIncomeByMonthlyFroChart(int year) throws SQLException, ClassNotFoundException;
}
