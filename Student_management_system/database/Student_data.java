package Student_management_system.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Student_data {
    public static Connection getcon() {
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata"
                    , "root", "@Anurag2374");
            return con;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return con;

    }
}