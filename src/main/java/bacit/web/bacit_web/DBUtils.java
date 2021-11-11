package bacit.web.bacit_web;

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

    public Connection getConnection(PrintWriter out) throws SQLException, ClassNotFoundException {
        Connection toReturn = null;
        Class.forName("org.mariadb.jdbc.Driver");
        try {
            toReturn = (connection != null)
                    ? connection
                    : DriverManager.getConnection(
                    "jdbc:mariadb://172.17.0.1:3308/MytestDB",
                    "root",
                    "TestTest123");
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("SQL Exception " + e);
        }
        return toReturn;
    }
}

