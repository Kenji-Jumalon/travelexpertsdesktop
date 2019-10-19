package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    public DBConnection(){

    }

    public Connection createConnection() {
        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Properties userInfo = new Properties();
            userInfo.put("user", "Sabiha");
            userInfo.put("password", "P@ssw0rd");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", userInfo);
        } catch (SQLException | ClassNotFoundException var3) {
            var3.printStackTrace();
        }

        return conn;
    }
}
