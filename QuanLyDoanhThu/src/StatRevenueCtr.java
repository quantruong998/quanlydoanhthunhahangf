
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StatRevenueCtr {
    
    private String dbURL = "jdbc:mysql://localhost:3306/nhahang_db";
    private String user = "root";
    private String pass = ""; 

    public StatRevenueCtr() { }

    public List<Dish> getDishStat(String startDate, String endDate) {
        List<Dish> listResult = new ArrayList<>();
        Connection conn = null;
        
        try {
         
            conn = DriverManager.getConnection(dbURL, user, pass);
           
            String sql = "SELECT d.id, d.name, SUM(od.quantity) AS totalSold, SUM(od.lineTotal) AS totalRevenue " +
                         "FROM tbldish d " +
                         "JOIN tblorderdetail od ON d.id = od.dishID " +
                         "JOIN tblbill b ON od.billID = b.id " +
                         "WHERE STR_TO_DATE(b.paymentDate, '%d/%m/%Y') >= STR_TO_DATE(?, '%d/%m/%Y') " +
                         "AND STR_TO_DATE(b.paymentDate, '%d/%m/%Y') <= STR_TO_DATE(?, '%d/%m/%Y') " +
                         "GROUP BY d.id, d.name " +
                         "ORDER BY totalRevenue DESC";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, startDate);
            ps.setString(2, endDate);
            
            ResultSet rs = ps.executeQuery();

           
            while (rs.next()) {
                Dish d = new Dish();
                d.setId(rs.getInt("id"));
                d.setName(rs.getString("name"));
                d.setTotalSold(rs.getInt("totalSold"));
                d.setTotalRevenue(rs.getFloat("totalRevenue"));
                listResult.add(d);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
          
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listResult;
    }
    
public List<Bill> getBillDetails(int dishId, String startDate, String endDate) {
    List<Bill> listBills = new ArrayList<>();
    Connection conn = null;
    try {
        conn = DriverManager.getConnection(dbURL, user, pass);
        
        String sql = "SELECT b.id, c.name AS customerName, b.paymentDate, b.totalAmount, od.quantity " +
                     "FROM tblbill b " +
                     "JOIN tblcustomer c ON b.customerID = c.id " +
                     "JOIN tblorderdetail od ON b.id = od.billID " +
                     "WHERE od.dishID = ? " +
                     "AND STR_TO_DATE(b.paymentDate, '%d/%m/%Y') >= STR_TO_DATE(?, '%d/%m/%Y') " +
                     "AND STR_TO_DATE(b.paymentDate, '%d/%m/%Y') <= STR_TO_DATE(?, '%d/%m/%Y') " +
                     "GROUP BY b.id";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, dishId);
        ps.setString(2, startDate);
        ps.setString(3, endDate);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Bill b = new Bill();
            b.setId(rs.getInt("id"));
            b.setPaymentDate(rs.getString("paymentDate"));
            b.setTotalAmount(rs.getFloat("totalAmount"));
            b.setQuantity(rs.getInt("quantity"));
            b.setNote(rs.getString("customerName")); 
            listBills.add(b);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try { if (conn != null) conn.close(); } catch (SQLException e) {}
    }
    return listBills;
}
}