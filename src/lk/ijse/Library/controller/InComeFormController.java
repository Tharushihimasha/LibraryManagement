package lk.ijse.Library.controller;


import javafx.event.ActionEvent;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import lk.ijse.Library.bo.BOFactory;
import lk.ijse.Library.bo.BOType;
import lk.ijse.Library.bo.custom.FineBO;
import lk.ijse.Library.bo.custom.impl.FineBOImpl;
import lk.ijse.Library.db.DBConnection;
import lk.ijse.Library.model.FineModel;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;

public class InComeFormController {
    public StackedBarChart stackedBarChart;
    public AnchorPane pane;
    private FineBO fineBO;

    public void PrintOnAction(ActionEvent actionEvent) throws JRException, SQLException, ClassNotFoundException {
        JasperDesign jasdi = JRXmlLoader.load("F:\\SE Class\\LibraryMangementSystem\\src\\lk\\ijse\\Library\\report\\FineReport.jrxml");
        String sql = "select m.Member_Name as memberName ,sum(f.Fine) as total,Year(f.date) as year , Month(f.date) as month from fine f inner join book_record br on f.BookRecord_Id = br.BookRecord_Id inner join member m on br.Member_Id = m.Member_Id group by m.member_Name,month,year having year = 2022 and month = 10'"+LocalDate.now().getMonthValue()+" and year = '"+
                LocalDate.now().getYear()+"'";
        JRDesignQuery newQuery = new JRDesignQuery();
        newQuery.setText(sql);
        jasdi.setQuery(newQuery);

        JasperReport js = JasperCompileManager.compileReport(jasdi);
        JasperPrint jp = JasperFillManager.fillReport(js, null, DBConnection.getInstance().getConnection());

        //String path =;
        //JasperExportManager.exportReportToPdfFil(jp,path);

        JasperViewer viewer = new JasperViewer(jp, false);
        viewer.show();
    }
    public void initialize(){
        fineBO = BOFactory.getInstance().getBo(BOType.FINE);
        setChart();
    }
    public void setChart(){
        try {
            HashMap hm = fineBO.getIncomeByMonthlyFroChart(LocalDate.now().getYear());
            XYChart.Series series = new XYChart.Series();
            series.setName(String.valueOf(LocalDate.now().getYear()));
            for(int i = 1 ; i <=12 ; i++){
                if(hm.get(i)==null){
                    series.getData().add(new XYChart.Data<>(Month.of(i).toString(),0));
                }else{
                    series.getData().add(new XYChart.Data<>(Month.of(i).toString(),Double.parseDouble
                            (String.valueOf(hm.get(i)))));
                }
            }

            stackedBarChart.getData().add(series);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
