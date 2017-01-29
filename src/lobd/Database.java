package lobd;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;

/**
 * Parent Database Class. Handles all the Connection stuff with the SQLite Database
 * @author Xarxas
 */
public class Database {

	private static Connection c = null;
	
	/**
	 * Database Constructor
	 * Establishes the Database Connection, checks for Missing Databases and creates them via subClasses
	 */
	public Database() {
		try {
			Class.forName("org.sqlite.JDBC");
		    c = DriverManager.getConnection("jdbc:sqlite:save/test.db");
		    c.setAutoCommit(false);
		    
		    if (!checkForTable("CHARACTERS")) {
		    	DatabasePlayerCharacter.create();
		    }
	    } catch ( Exception e ) {
	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.exit(0);
	    }
	    System.out.println("Opened database successfully");
	}
	
	/**
	 * Creates a Table inside the Database
	 * @param table Table Name (eg. CHARACTERS)
	 * @param options List<String> of Options (eg. DEX INT NOT NULL)
	 * @return true or false (should throw error)
	 */
	public static boolean createTable(String table, List<String> options) {
		
		String sql = "";
		
		for (String i : options) {
			sql += i + ",";
		}
		
		sql = "CREATE TABLE " + table + " (" + sql.substring(0, sql.length() - 1) + ");";
		
		return execute(sql);
	}
	
	/**
	 * Adds One row of Data into the specified table
	 * @param table Table Name
	 * @param data Data to Insert (format for hash: (field) key, (value) value))
	 * @return true of false (should throw error)
	 */
	public static boolean add(String table, HashMap<String, String> data ) {
		
		String key = "", value = "";
		
		for (Entry<String, String> i : data.entrySet()) {
			key += i.getKey() + ",";
			value += "'" + i.getValue() + "',";
		}
		
		String sql = "INSERT INTO " + table + " (" + key.substring(0, key.length() - 1) + ") VALUES (" + value.substring(0, value.length() - 1) + ");";
	
		return execute(sql);
	}
	
	/**
	 * Gets One ResultSet from the Database
	 * @param table Table to get Data from
	 * @param condition (Optional) Condition that has to be met
	 * @param fields (Optional) Fields to get (defaults to *)
	 * @return ResultSet matching the Query
	 */
	public static ResultSet get(String table, Optional<String> condition, Optional<String> fields) {
		
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
	
	/**
	 * Updates one Key/Value pair, that matches the condition
	 * @param table Table to Update Data in
	 * @param condition Condition that has to be met
	 * @param key Column that will be updated
	 * @param value New Value for specified Column
	 * @return true or false (should throw error)
	 */
	public static boolean update(String table, String condition, String key, String value) {
		String sql = "UPDATE " + table + " set " + key + " = " + value + " where " + condition;
		
		return execute(sql);
	}
	
	/**
	 * Deletes everything that meets the condition. Can not be used to DROP tables
	 * @param table Table to delete Data from
	 * @param condition Condition that has to be met
	 * @return true or false (should throw error)
	 */
	public static boolean del(String table, String condition) {
		String sql = "DELETE from " + table + " where " + condition;
		
		return execute(sql);
	}
	
	/**
	 * Executes given sql String
	 * @param sql String that will be executed inside the Database (NO Statement Object)
	 * @return true or false (should throw error)
	 */
	private static boolean execute(String sql) {
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
	
	/**
	 * Checks if specified table exists
	 * @param db Table to check for
	 * @return true or false
	 * @throws SQLException
	 */
	public static boolean checkForTable(String table) throws SQLException {
		DatabaseMetaData dbmd = c.getMetaData();
		ResultSet checkTables = dbmd.getTables(null, null, table, null);
		
		if (checkTables.next()) {
			return true;
		} else {
			return false;
		}
	}
}
