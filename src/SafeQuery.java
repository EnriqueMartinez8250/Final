import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SafeQuery {
    public static void main(String[] args) throws Exception {
        String username = "user_input";
        String password = "user_password";

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");

        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                // Process the result
                System.out.println("User found: " + resultSet.getString("username"));
            }
        }
    }
}
