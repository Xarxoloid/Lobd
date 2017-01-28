package lobd;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;

public class Database {

	private Connection c = null;
	
	public Database() {
		try {
			Class.forName("org.sqlite.JDBC");
		    c = DriverManager.getConnection("jdbc:sqlite:save/test.db");
		    c.setAutoCommit(false);
		    
		    if (!checkDatabase("CHARACTERS")) {
		    	List<String> sql = new ArrayList<String>();
		    	sql.add("ID INTEGER PRIMARY KEY AUTOINCREMENT");
		    	sql.add("NAME TEXT NOT NULL");
		    	sql.add("STR INT NOT NULL");
		    	sql.add("DEX INT NOT NULL");
		    	sql.add("END INT NOT NULL");
		    	sql.add("MAG INT NOT NULL");
		    	sql.add("TICK INT NOT NULL");
		    	sql.add("SPEEDMOD DOUBLE NOT NULL");
		    	
		    	create("CHARACTERS", sql);
		    }
	    } catch ( Exception e ) {
	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.exit(0);
	    }
	    System.out.println("Opened database successfully");
	}
	
	public boolean create(String table, List<String> options) {
		
		String sql = "";
		
		for (String i : options) {
			sql += i + ",";
		}
		
		sql = "CREATE TABLE " + table + " (" + sql.substring(0, sql.length() - 1) + ");";
		
		return execute(sql);
	}
	
	public boolean add(String table, HashMap<String, String> data ) {
		
		String key = "", value = "";
		
		for (Entry<String, String> i : data.entrySet()) {
			key += i.getKey() + ",";
			value += "'" + i.getValue() + "',";
		}
		
		String sql = "INSERT INTO " + table + " (" + key.substring(0, key.length() - 1) + ") VALUES (" + value.substring(0, value.length() - 1) + ");";
	
		return execute(sql);
	}
	
	public ResultSet get(String table, Optional<String> condition, Optional<String> fields) {
		
		String sql = "SELECT " + (fields.isPresent() ? "(" + fields + ")": "*") + " FROM " + table + (condition.isPresent() ? "WHERE " + condition:"") + ";";
		
		ResultSet rs = null;
		try {
			Statement stmt = c.createStatement();
			rs = stmt.executeQuery(sql);
			stmt.close();
			c.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
		
	}
	
	public boolean update(String table, String condition, String key, String value) {
		String sql = "UPDATE " + table + " set " + key + " = " + value + " where " + condition;
		
		return execute(sql);
	}
	
	private boolean execute(String sql) {
		try {
			Statement stmt = c.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			c.commit();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean checkDatabase(String db) throws SQLException {
		DatabaseMetaData dbmd = c.getMetaData();
		ResultSet checkTables = dbmd.getTables(null, null, db, null);
		
		if (checkTables.next()) {
			return true;
		} else {
			return false;
		}
	}
}
