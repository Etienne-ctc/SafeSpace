package backend;

import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DataBaseDelete extends AsyncTask<String, Void, Boolean> {
    private String connectionURL="jdbc:postgresql://kandula.db.elephantsql.com/ktmsitiw";
    public DataBaseDelete(){}
    @Override
    protected Boolean doInBackground(String... queries) {
        try {
            Connection conn = DriverManager.getConnection(connectionURL, "ktmsitiw", "jjWJDuvTMgzTlocK0eGsxMkFfaouE0Ri");
            String insertQuery = queries[0];
            PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
            int affectedRows = preparedStatement.executeUpdate();
            conn.close();
            // Return true if at least one row is affected, indicating a successful insert
            return affectedRows > 0;
        } catch (Exception e) {
            Log.e("DatabaseDelete", "Error in database operation", e);
        }
        return false;
    }
}