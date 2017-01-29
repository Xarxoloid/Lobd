package lobd;

import java.util.ArrayList;
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

}
