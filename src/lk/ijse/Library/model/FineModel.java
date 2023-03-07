package lk.ijse.Library.model;

import lk.ijse.Library.dto.FineDTO;
import lk.ijse.Library.dao.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class FineModel {
   /* public static boolean addFine(FineDTO fine) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("insert into fine values(?,?,?,?)",fine.getBookRecordId(),fine.getDateCount(),
                fine.getFine(), fine.getDate());
    }

    public static HashMap getIncomeByMonthlyFroChart(int year) throws SQLException, ClassNotFoundException {
        ResultSet rs = CrudUtil.execute("select sum(fine) as total ,Year(Date) as year, Month(Date) as month from fine group " +
                "by month having year = '"+year+"'order by month");

        HashMap hm = new HashMap();
        while (rs.next()){
            hm.put(rs.getInt(3),rs.getDouble(1));
        }
        return hm;
    }*/
}
