package ir.maktab58.homework9.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Taban Soleymani
 */
public class DataBaseAccess {
    protected static Connection connection = null;

    public DataBaseAccess() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/office_database",
                    "root", "61378");
        } catch (SQLException | ClassNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
