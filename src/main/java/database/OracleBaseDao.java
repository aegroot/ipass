package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleBaseDao {
    static String jdbcUrl="jdbc:oracle:thin:@localhost:1521:orcl";
    static String dbusername="IPASS";
    static String dbpassword="ipass";
    public static Connection getConnection() throws SQLException {
        //connection.close();
        return DriverManager.getConnection(jdbcUrl,dbusername,dbpassword);
    }
    public static void closeConnection() throws SQLException {getConnection().close();}
}

