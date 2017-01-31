package lobd;

import java.util.Scanner;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class lobd {
	
	private static ArrayList<PlayerCharacter> characters = new ArrayList<PlayerCharacter>();
	private static Database db = null;
	
	public static void main(String[] args) throws IOException, SQLException {
		
		String[] cmd;
		String scanned;
		Scanner scan = new Scanner(System.in);
		lobd.setDb(new Database());
		
		outerloop:
		while (true) {
			System.out.print("Befehl eingeben: ");
			scanned = scan.nextLine();
			cmd = scanned.split("\\s+");
			switch (cmd[0]) {
				case "showStats":
					lobd.getCharacters().get(Integer.parseInt(cmd[1])).showStats();
					break;
				case "showEnemys":
					ArrayList<Integer> enemyIds = new ArrayList<Integer>();
					enemyIds.add(1);
					Combat combat = new Combat(enemyIds);
					combat.prepare();
					break;
				case "createChar":
					PlayerCharacter nC = new PlayerCharacter(cmd[1]);
					db.getPlayerCharacterDao().create(nC);
					nC.showStats();
					break;
				case "doTick":
					int i = 0;
					long start = System.currentTimeMillis();
					while (i < 1000000) {
						ATB.doTick();
						i++;
					}
					long end = System.currentTimeMillis();
					System.out.println("Verstrichene Zeit: " + (end - start) + "ms");
					break;
				case "save":
					break;
				case "load":
					lobd.getCharacters().add(db.getPlayerCharacterDao().queryForId(cmd[1]));
					lobd.getCharacters().get(getCharacters().size() - 1).showStats();
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
	public static ArrayList<PlayerCharacter> getCharacters() {
		return characters;
	}

	/**
	 * @param characters the characters to set
	 */
	public static void setCharacters(ArrayList<PlayerCharacter> characters) {
		lobd.characters = characters;
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
		lobd.db = db;
	}
}