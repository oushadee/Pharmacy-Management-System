
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Controller.ControlSupplierData;

public class ModelSupplier {
    public boolean saveSupplier(String supid, String supname, String supaddress, int suptp) {
        try (Connection connection = DBConnection.getConnection()) {
            String sql = "INSERT INTO Supplier(supid,supname,supaddress,suptp) VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, supid);
            preparedStatement.setString(2, supname);
            preparedStatement.setString(3, supaddress);
            preparedStatement.setInt(4, suptp);
       

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            return false;
        }
    }
    public List<ControlSupplierData> getAllSupplierData() {
        List<ControlSupplierData> SupplierDataList = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection()){
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT supid,supname,supaddress,suptp FROM Supplier");
             ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String supid = resultSet.getString("supid");
                String supname = resultSet.getString("supname");
                String supaddress = resultSet.getString("supaddress");
                int suptp = resultSet.getInt("suptp");
       

                ControlSupplierData proData = new ControlSupplierData(supid,supname,supaddress,suptp);
                SupplierDataList.add(proData);
            }
        } catch (SQLException ex) {
        }

        return SupplierDataList;
    }
    public boolean deleteSupplier(String supid) {
        try (Connection connection = DBConnection.getConnection()){
            // Define the SQL query to delete the car
            String sql = "DELETE FROM Supplier WHERE supid = ?";
            
            // Prepare the SQL statement
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, supid);
            
            // Execute the SQL query and get the number of affected rows
            int rowsAffected = preparedStatement.executeUpdate();
            
            return rowsAffected > 0;
        } catch (SQLException ex) {
// Handle any database-related exceptions here
                        return false;
        }
    }
    public boolean updateSupplier(String supid, String supname, String supaddress, int suptp) {
        try {
            // Establish a database connection
           Connection connection = DBConnection.getConnection();

            // Define the SQL query to update the record in the database
            String sql = "UPDATE Supplier SET supname=?, supaddress=?, suptp=? WHERE supid=?";

            // Prepare the statement
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, supname);
            preparedStatement.setString(2, supaddress);
            preparedStatement.setInt(3, suptp);
            preparedStatement.setString(4, supid);

            // Execute the update
            int rowsAffected = preparedStatement.executeUpdate();

            // Close the database    connection.close();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            return false;
        }
     }
}
