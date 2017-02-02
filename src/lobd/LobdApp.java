package lobd;

import java.util.Scanner;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class LobdApp {
	
	private static HashMap<Integer, PlayerCharacter> characters = new HashMap<Integer, PlayerCharacter>();
	private static Database db = null;
	
	public static void main(String[] args) throws IOException, SQLException {
		
		String[] cmd;
		String scanned;
		Scanner scan = new Scanner(System.in);
		LobdApp.setDb(new Database());
		
		outerloop:
		while (true) {
			System.out.print("Befehl eingeben: ");
			scanned = scan.nextLine();
			cmd = scanned.split("\\s+");
			switch (cmd[0]) {
				case "showStats":
					LobdApp.getCharacters().get(Integer.parseInt(cmd[1])).showStats();
					break;
				case "simFight":
					ArrayList<Integer> enemyIds = new ArrayList<Integer>();
					enemyIds.add(1);
					enemyIds.add(2);
					Combat combat = new Combat(enemyIds);
					combat.fight();
					break;
				case "createChar":
					PlayerCharacter nC = new PlayerCharacter(cmd[1]);
					db.getPlayerCharacterDao().create(nC);
					nC.showStats();
					break;
				case "load":
					PlayerCharacter temp = db.getPlayerCharacterDao().queryForId(cmd[1]);
					LobdApp.getCharacters().put(temp.getId(), temp);
					LobdApp.getCharacters().get(1).showStats();
					break;
				case "status":
					Status s = new Status();
					PlayerCharacter p = new PlayerCharacter();
					p = db.getPlayerCharacterDao().queryForId("1");
					p.setStatus(s);
					db.getPlayerCharacterDao().update(p);
					break;
				case "stop":
					scan.close();
					break outerloop;
				default:
					System.out.println("Unbekannter Befehl");
			}
		}
	}

	/**
	 * @return the characters
	 */
	public static HashMap<Integer, PlayerCharacter> getCharacters() {
		return characters;
	}

	/**
	 * @param characters the characters to set
	 */
	public static void setCharacters(HashMap<Integer, PlayerCharacter> characters) {
		LobdApp.characters = characters;
	}

	/**
	 * @return the db
	 */
	public static Database getDb() {
		return db;
	}

	/**
	 * @param db the db to set
	 */
	public static void setDb(Database db) {
		LobdApp.db = db;
	}
}