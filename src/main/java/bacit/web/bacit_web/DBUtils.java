package bacit.web.bacit_web;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    private static final DBUtils INSTANCE = new DBUtils();
    static Connection connection;

    public static DBUtils getINSTANCE() {
        return INSTANCE;
    }

    public Connection getConnection() throws ClassNotFoundException {
        Connection toReturn = null;
        Class.forName("org.mariadb.jdbc.Driver");
        try {
            toReturn = (connection != null) ? connection : DriverManager.getConnection(
                    "jdbc:mariadb://172.17.0.1:3308/MytestDB",
                    "root",
                    "TestTest123");

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return toReturn;
    }
}
