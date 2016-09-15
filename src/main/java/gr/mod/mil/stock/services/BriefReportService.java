package gr.mod.mil.stock.services;

import gr.mod.mil.stock.StockApplication;
import gr.mod.mil.stock.web.dto.BriefReport;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Service
public class BriefReportService {


    public List<BriefReport> getBriefReport(Date from, Date to){

       String sql="SELECT D.DESCRIPTION,SUM(T.WITHDRAWAMOUNT), SUM(C.PRICE) , SUM(C.NUMBEROFPAGES) " +
               "    FROM Consumable_Transaction T, CONSUMABLE C, THL_TMHMA_LIVE D " +
               "    WHERE T.CONSUMABLE_ID=C.ID AND T.WITHDRAWAMOUNT>0 AND T.DEPT_DESC=D.DESCRIPTION " +
               "    AND T.WHEN >= ? AND T.WHEN <= ? " +
               "    GROUP BY D.DESCRIPTION ";

        List<BriefReport> report=new ArrayList<BriefReport>();
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your Oracle JDBC Driver?");

        }
        Connection connection = null;
        try {

            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@10.0.0.28:1521:orcl", "STOCKUSER",
                    "stockpass1");

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");



        }

        try {
            Calendar c = Calendar.getInstance();
            c.setTime(to);
            c.add(Calendar.DATE,1);


            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDate(1,new java.sql.Date(from.getTime()) );
            ps.setDate(2,new java.sql.Date(to.getTime()) );

            ResultSet rs = ps.executeQuery();
            while ( rs.next() ) 
            {
                BriefReport as=new BriefReport();
                as.setName(rs.getString(1));
                as.setWithdrawals(rs.getLong(2));
                as.setPrice(rs.getFloat(3));
                as.setPages(rs.getLong(4));
                report.add(as);


            }
            rs.close();
            ps.close();
            return report;


        } catch (SQLException e) {

        }

        try {
            connection.close();
        } catch (SQLException e) {

        }

        return report;

    }

}
