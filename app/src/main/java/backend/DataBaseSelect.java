package backend;

import android.os.AsyncTask;
import android.util.Log;

import java.sql.*;


public class DataBaseSelect extends AsyncTask<String, Void, String> {
    private String connectionURL="jdbc:mysql://192.168.1.131:3306/safespace?connectTimeout=5000";
    private DatabaseCallBack callback;
    public DataBaseSelect() {
        this.callback = callback;
    }

    @Override
    protected String doInBackground(String... queries) {
        try {
            Log.d("DatabaseSelect", "Connecting to the database");
            Connection conn = DriverManager.getConnection(connectionURL, "read", "123");
            Log.d("DatabaseSelect", conn.getCatalog());
            Log.d("DatabaseSelect", "Connected to the database");
            Statement statement = conn.createStatement();
            System.out.println("test3");
            ResultSet resultSet = statement.executeQuery(queries[0]); // Assuming only one query for simplicity
            System.out.println("test4");
            while (resultSet.next()) {
                // ResultSet indices start from 1
                return resultSet.getString(1);  // Assuming it's a string, adjust accordingly
            }
            conn.close();
        } catch (Exception e) {
            Log.e("DatabaseSelect", "Error in database operation", e);
        }
        return null;
    }
    @Override
    protected void onPostExecute(String result) {
        if (callback != null) {
            callback.onQueryResult(result);
        }
    }
}
