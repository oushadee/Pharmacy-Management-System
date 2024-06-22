
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Controller.*;


public class ModelMedicine {
    public boolean saveMedicine(String supid, String medid, String medname, int quantity, double ppu) {
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "INSERT INTO Medicine(supid,medid,medname,quantity,ppu) VALUES (?, ?, ? ,? ,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, supid);
            preparedStatement.setString(2, medid);
            preparedStatement.setString(3, medname);
            preparedStatement.setInt(4, quantity);
            preparedStatement.setDouble(5, ppu);

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    
     public List<ControlMedicineData> getAllMedicineData() {
        List<ControlMedicineData> SupplierDataList = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection()){
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT supid,medid,medname,quantity,ppu FROM Medicine");
             ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String supid = resultSet.getString("supid");
                String medid = resultSet.getString("medid");
                String medname = resultSet.getString("medname");
                int quantity = resultSet.getInt("quantity");
                double ppu = resultSet.getDouble("ppu");

                ControlMedicineData proData = new ControlMedicineData(supid,medid,medname,quantity,ppu);
                SupplierDataList.add(proData);
            }
        } catch (SQLException ex) {
        }

        return SupplierDataList;
    }
    
    
     public boolean deleteMedicine(String medid) {
        try (Connection connection = DBConnection.getConnection()){
            // Define the SQL query to delete the car
            String sql = "DELETE FROM Medicine WHERE medid = ?";
            
            // Prepare the SQL statement
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, medid);
            
            // Execute the SQL query and get the number of affected rows
            int rowsAffected = preparedStatement.executeUpdate();
            
            return rowsAffected > 0;
        } catch (SQLException ex) {
// Handle any database-related exceptions here
                        return false;
        }
    }
     
     public boolean updateMedicine(String supid, String medid, String medname, double ppu) {
        try {
            // Establish a database connection
           Connection connection = DBConnection.getConnection();

            // Define the SQL query to update the record in the database
            String sql = "UPDATE Medicine SET supid=?, medname=?, ppu=? WHERE medid=?";

            // Prepare the statement
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, supid);
            preparedStatement.setString(2, medname);
            preparedStatement.setDouble(3, ppu);
            preparedStatement.setString(4, medid);

            // Execute the update
            int rowsAffected = preparedStatement.executeUpdate();

            // Close the database    connection.close();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            return false;
        }
     }
}
