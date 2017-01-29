package lobd;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DatabasePlayerCharacter extends Database {
	
	public static void create() {
		List<String> sql = new ArrayList<String>();
    	sql.add("ID INTEGER PRIMARY KEY AUTOINCREMENT");
    	sql.add("NAME TEXT NOT NULL");
    	sql.add("STR INT NOT NULL");
    	sql.add("DEX INT NOT NULL");
    	sql.add("END INT NOT NULL");
    	sql.add("MAG INT NOT NULL");
    	sql.add("TICK INT NOT NULL");
    	sql.add("SPEEDMOD DOUBLE NOT NULL");
    	
    	createTable("CHARACTERS", sql);
	}
	
	public static HashMap<String, String> getById(int id) throws SQLException {
		String ID = "ID='" + id + "'";
		ResultSet rs = get("CHARACTERS", ID, null);
		HashMap<String, String> result = new HashMap<String, String>();

		ResultSetMetaData meta = rs.getMetaData();
		if (rs.next()) {
			System.out.println("RS NEXT");
			for (int i = 1; i <= meta.getColumnCount(); i++) {
	            String key = meta.getColumnName(i);
	            String value = rs.getString(key);
	            System.out.println(key + ":" + value);
	            
	            result.put(key, value);
	        }
		}
		
		rs.close();
		return result;
	}

}
