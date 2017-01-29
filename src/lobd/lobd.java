package lobd;

import java.util.Scanner;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class lobd {
	
	public static ArrayList<PlayerCharacter> characters = new ArrayList<PlayerCharacter>();
	
	public static void main(String[] args) throws IOException, SQLException {
		
		// Database Setup Block
		// create a connection source to our database
        String databaseUrl = "jdbc:sqlite:save/test.db";
        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);
        // Setting up Data Access Objects (Dao's)
        Dao<PlayerCharacter, String> accountDao = DaoManager.createDao(connectionSource, PlayerCharacter.class);
        // Creating Tables if not present
        TableUtils.createTableIfNotExists(connectionSource, PlayerCharacter.class);
        // End of Database Setup Block
        
		String[] cmd;
		String scanned;
		Scanner scan = new Scanner(System.in);
		
		
		outerloop:
		while (true) {
			System.out.print("Befehl eingeben: ");
			scanned = scan.nextLine();
			cmd = scanned.split("\\s+");
			switch (cmd[0]) {
				case "showStats":
					characters.get(Integer.parseInt(cmd[1])).showStats();
					break;
				case "createChar":
					PlayerCharacter nC = new PlayerCharacter(cmd[1]);
					accountDao.create(nC);
					nC.showStats();
					break;
				case "doTick":
					int i = 0;
					while (i < 1000) {
						ATB.doTick();
						i++;
					}
					break;
				case "save":
					break;
				case "load":
					characters.add(accountDao.queryForId(cmd[1]));
					characters.get(characters.size() - 1).showStats();
					break;
				case "stop":
					scan.close();
					connectionSource.close();
					break outerloop;
				default:
					System.out.println("Unbekannter Befehl");
			}
		}
	}

}
