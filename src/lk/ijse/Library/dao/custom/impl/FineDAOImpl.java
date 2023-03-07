package lk.ijse.Library.dao.custom.impl;

import lk.ijse.Library.dao.CrudUtil;
import lk.ijse.Library.dao.custom.FineDAO;
import lk.ijse.Library.dto.FineDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class FineDAOImpl implements FineDAO {
    @Override
    public HashMap getIncomeByMonthlyFroChart(int year) throws SQLException, ClassNotFoundException {
        ResultSet rs = CrudUtil.execute("select sum(fine) as total ,Year(Date) as year, Month(Date) as month from fine group " +
                "by month having year = '"+year+"'order by month");

        HashMap hm = new HashMap();
        while (rs.next()){
            hm.put(rs.getInt(3),rs.getDouble(1));
        }
        return hm;
    }

    @Override
    public boolean Add(FineDTO fine) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("insert into fine values(?,?,?,?)",fine.getBookRecordId(),fine.getDateCount(),
                fine.getFine(), fine.getDate());
    }

    @Override
    public FineDTO Search(String obj) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean Update(FineDTO obj) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String obj) throws SQLException, ClassNotFoundException {
        return false;
    }
}
