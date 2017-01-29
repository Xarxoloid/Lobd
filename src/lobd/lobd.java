package lobd;

import java.util.Scanner;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class lobd {
	
	public static ArrayList<PlayerCharacter> characters = new ArrayList<PlayerCharacter>();
	
	public static void main(String[] args) throws IOException, SQLException {
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
				characters.add(new PlayerCharacter());
				characters.get(characters.size() - 1).create(cmd[1]);
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
				break;
			case "stop":
				scan.close();
				break outerloop;
			default:
				System.out.println("Unbekannter Befehl");
			}
		}
	}

}
