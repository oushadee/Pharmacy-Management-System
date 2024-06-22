package Model;

import java.sql.*;


public class Login {
    public boolean validateLogin(String username, String password) {
        try (Connection connection = DBConnection.getConnection()){
            String sql = "SELECT * FROM Login WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

          return resultSet.next(); // If there's a match, resultSet will have at least one row
        } catch (SQLException e) {
            return false;
        }
    }
}
