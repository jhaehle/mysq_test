/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqlcheck;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author Will Shackleford {@literal <wshackle@gmail.com> }
 */
public class MysqlCheck {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn
                    = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?"
                            + "user=somebody&password=mypwd");
            ResultSet rs = conn.createStatement().executeQuery("select * from Untitled;");
            ResultSetMetaData meta = rs.getMetaData();
            for (int i = 0; i < meta.getColumnCount(); i++) {
                System.out.println("i = " + i);
                System.out.println("columnName=" + meta.getColumnName(i + 1));
                rs.first();
                do {
                    System.out.println("colunmString=" + rs.getString(i + 1));
                } while (rs.next());
            }
            //            try (BufferedReader br = new BufferedReader(new InputStreamReader(rs.getAsciiStream("*")))) {
            //                br.lines().forEach(System.out::println);
            //            }
//            rs.
            // Do something with the Connection
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (Exception ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
        }
    }
}
