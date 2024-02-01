package backend;

import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DataBaseUpdate extends AsyncTask<String, Void, Boolean> {
    private String connectionURL="jdbc:mysql://192.168.1.131:3306/safespace?connectTimeout=5000";
    public DataBaseUpdate(){}
    @Override
    protected Boolean doInBackground(String... queries) {
        try {
            Connection conn = DriverManager.getConnection(connectionURL, "read", "123");
            String insertQuery = queries[0];
            PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
            int affectedRows = preparedStatement.executeUpdate();

            // Return true if at least one row is affected, indicating a successful insert
            return affectedRows > 0;
        } catch (Exception e) {
            Log.e("DatabaseUpdate", "Error in database operation", e);
        }
        return false;
    }
}
