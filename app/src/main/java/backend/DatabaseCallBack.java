package backend;

import java.sql.ResultSet;

public interface DatabaseCallBack {
    void onQueryResult(ResultSet result);
}
