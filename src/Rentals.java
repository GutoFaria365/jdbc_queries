import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Rentals {

    public static void createRentalsTable() {
        Connection connection = null;
        Statement statement = null;
        try {
            // Open a connection
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(Connection_DB.DB_URL, Connection_DB.USER, Connection_DB.PASS);

            // Execute a query to create a table
            System.out.println("Creating table in given database...");
            statement = connection.createStatement();
            String sql = "CREATE TABLE Rentals " +
                    "(id INT NOT NULL AUTO_INCREMENT, " +
                    "client_id INT, NOT NULL " +
                    "car_id INT NOT NULL," +
                    "start_date TIMESTAMP NOT NULL," +
                    "end_date TIMESTAMP NOT NULL," +
                    "PRIMARY KEY (id)" +
                    "FOREIGN KEY (client_id) REFERENCES Customers(id)" +
                    "FOREIGN KEY (car_id) REFERENCES Cars(id))";

            statement.executeUpdate(sql);
            System.out.println("Table created successfully...");
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            closeConnections(connection, statement);
        }
        System.out.println("Goodbye!");
    }

    private static void closeConnections(Connection connection, Statement statement) {
        try {
            if (statement != null)
                connection.close();
        } catch (SQLException se) {
        }
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
