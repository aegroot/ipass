package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleBaseDao {
    static String jdbcUrl="jdbc:postgresql://localhost:5432/ipass";
    static String dbusername="postgres";
    static String dbpassword="vj6ncz";
    public static Connection getConnection() throws SQLException {
        //connection.close();
        return DriverManager.getConnection(jdbcUrl,dbusername,dbpassword);
    }
    public static void closeConnection() throws SQLException {getConnection().close();}
}

