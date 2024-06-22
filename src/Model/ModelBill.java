
package Model;

import java.sql.*;
import Controller.ControlBillData;
import java.util.Date;
import java.util.*;

public class ModelBill {
    public boolean saveBill(String invid, String medid, String medname, String cusname, double price, int quantityout, double totalamount, double payment, Date invdate) {
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "INSERT INTO Invoice (invid,medid,medname,cusname,price,quantityout,totalamount,payment,invdate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            java.sql.Date sqlODate = new java.sql.Date(invdate.getTime());
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, invid);
            preparedStatement.setString(2, medid);
            preparedStatement.setString(3, medname);
            preparedStatement.setString(4, cusname);
            preparedStatement.setDouble(5, price);
            preparedStatement.setInt(6, quantityout);
            preparedStatement.setDouble(7, totalamount);
            preparedStatement.setDouble(8, payment);
            preparedStatement.setDate(9, sqlODate);

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public List<ControlBillData> getAllBillData() {
        List<ControlBillData> ProductDataList = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection()){
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT invid,medid,medname,cusname,price,quantityout,totalamount,payment,invdate FROM Invoice");
             ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                
                String invid = resultSet.getString("invid");
                String medid = resultSet.getString("medid");
                String medname = resultSet.getString("medname");
                String cusname = resultSet.getString("cusname");
                double price = resultSet.getDouble("price");
                int quantityout = resultSet.getInt("quantityout");
                double totalamount = resultSet.getDouble("totalamount");
                double payment = resultSet.getDouble("payment");
                Date invdate = resultSet.getDate("invdate");

           
                ControlBillData proData = new ControlBillData(invid,medid,medname,cusname,price,quantityout,totalamount,payment,invdate);
                ProductDataList.add(proData);
            }
        } catch (SQLException ex) {
        }

        return ProductDataList;
    }
    public boolean deleteBill(String invid) {
        try (Connection connection = DBConnection.getConnection()){
            // Define the SQL query to delete the car
            String sql = "DELETE FROM Invoice WHERE invid = ?";
            
            // Prepare the SQL statement
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, invid);
            
            // Execute the SQL query and get the number of affected rows
            int rowsAffected = preparedStatement.executeUpdate();
            
            return rowsAffected > 0;
        } catch (SQLException ex) {
// Handle any database-related exceptions here
                        return false;
        }
    }
}
