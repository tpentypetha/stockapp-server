package gr.mod.mil.stock.services;

import gr.mod.mil.stock.web.dto.ExtendListReport;
import gr.mod.mil.stock.web.dto.ExtendedReport;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class DepReportService {

    public List<ExtendListReport> getDepReport(Date from, Date to,String dep_desc){

        String sql="SELECT DISTINCT D.DESCRIPTION, C.CODE, (SELECT SUM(T2.WITHDRAWAMOUNT) " +
                "                                FROM Consumable_Transaction T2 " +
                "                                WHERE T.CONSUMABLE_ID=T2.CONSUMABLE_ID " +
                "                                AND T.DEPT_DESC=T2.DEPT_DESC) AS Withdrawls, " +
                "                                (SELECT c2.NUMBEROFPAGES " +
                "                                FROM CONSUMABLE c2 " +
                "                                WHERE c2.ID=C.ID) as pages " +
                "FROM Consumable_Transaction T,THL_YMHMA_LIVE D,CONSUMABLE C " +
                "WHERE T.DEPT_DESC=D.DESCRIPTION AND T.CONSUMABLE_ID=C.ID " +
                "AND T.WHEN >= ? AND T.WHEN <= ? AND T.DEPT_DESC=? " +
                "ORDER BY D.DESCRIPTION ";

        List<ExtendedReport> report=new ArrayList<ExtendedReport>();
        List<ExtendListReport> rep= new ArrayList<ExtendListReport>();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {


        }
        Connection connection = null;
        try {

            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "STOCKUSER",
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
            ps.setString(3,dep_desc);

            ResultSet rs = ps.executeQuery();
            while ( rs.next() )
            {
                ExtendedReport as=new ExtendedReport();
                as.setDepname(rs.getString(1));
                as.setConsumable_name(rs.getString(2));
                as.setWithdrawals(rs.getLong(3));
                as.setSumpages(rs.getLong(3)*rs.getLong(4));
                report.add(as);


            }
            rs.close();
            ps.close();



            int depsnum=0;
            if(report.size()>0) {
                ExtendListReport a=new ExtendListReport();
                a.setDepname(report.get(0).getDepname());
                rep.add(a);
                int k=0;
                for (int i = 0; i < rep.size(); i++) {
                    for (int j=k; j < report.size(); j++) {
                        if(!rep.get(i).getDepname().equals(report.get(j).getDepname())){
                            ExtendListReport a1=new ExtendListReport();
                            a1.setDepname(report.get(j).getDepname());
                            rep.add(a1);
                            k=j;
                            break;


                        }
                    }

                }
            }
            int l=0;
            for (int i = 0; i < rep.size(); i++) {
                List<ExtendedReport> temp=new ArrayList<ExtendedReport>();
                for (int j = 0; j < report.size(); j++) {
                    if(rep.get(i).getDepname().equals(report.get(j).getDepname())){
                        temp.add(report.get(j));

                    }


                }
                rep.get(i).setList(temp);


            }




            return rep;




        } catch (SQLException e) {

        }

        try {
            connection.close();
        } catch (SQLException e) {

        }

        return rep;

    }
}
