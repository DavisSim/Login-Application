package login.service;

import login.model.User;
import org.springframework.stereotype.Service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;


@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = Logger.getLogger(login.service.UserServiceImpl.class.getName());

    private static final String DB_URL = "jdbc:mysql://localhost:3306/accounts";
    private static final String DB_USER = "developer";
    private static final String DB_PASSWORD = "Sql123456";

    @Override
    public User authenticateUser(String userId, String password) {
        logger.info("user:" + userId);
        logger.info("password:" + password);
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM user WHERE username = ? AND password = ?";
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                statement.setString(1, userId);
                statement.setString(2, password);
                try (ResultSet resultSet = statement.executeQuery()) {
                    logger.info(resultSet.toString());
                    if (resultSet.next()) {
                        User user = new User();
                        user.setUserId(resultSet.getString("username"));
                        user.setPassword(resultSet.getString("password"));
                        user.setName(resultSet.getString("name"));
                        user.setRole(resultSet.getString("role"));
                        return user;
                    } else {
                        return null; 
                    }
                }
            }
        } catch (SQLException e) {
            logger.severe("Error accessing database: " + e.getMessage());
            return null;
        }
    }
}
