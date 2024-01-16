package backendTesting;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserUnitTest {
    @Test
    public void testDatabaseConnection(){
        String connectionURL="jdbc:mysql://localhost:3306/SafeSpace";
        int UID=0;
        try(Connection conn = DriverManager.getConnection(connectionURL,"root", "root")){
            String setUserRequest = "SELECT * FROM User WHERE UID="+UID;

        }catch(SQLException e){
            System.out.println("connection didn't work");
        }
    }
}
