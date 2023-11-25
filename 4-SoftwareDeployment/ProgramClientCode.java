import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        // JDBC URL, username, and password of PostgreSQL server
        String url = "jdbc:postgresql://localhost:5455/horchynskyi-db";
        String user = "postgres";
        String password = "2004";

        // Initialize the connection
        Connection connection = null;

        try {
            // Connect to the database
            connection = DriverManager.getConnection(url, user, password);

            // Fetch data from the database (replace "your_table" and "your_column" with your actual table and column names)
            String query = "SELECT * FROM users";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Process the result set
            System.out.println("Users:");
            while (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                String username = resultSet.getString("username");
                String userPassword = resultSet.getString("user_password");

                System.out.println("User ID: " + userId + ", Username: " + username + ", Password: " + userPassword);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
