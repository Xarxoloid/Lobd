package lobd;

import java.sql.SQLException;
import java.util.HashMap;

public class PlayerCharacter {

	private String name;
	private int str, dex, end, mag, tick, id;
	private double speedMod;
	public int tickCount;
	
	public void create (String charName) throws SQLException {
	
		if (Database.checkForTable("CHARACTERS")) {
			HashMap<String, String> sql = new HashMap<String, String>();;
			
			sql.put("NAME", charName);
			sql.put("STR", "5");
			sql.put("DEX", "5");
			sql.put("END", "5");
			sql.put("MAG", "5");
			sql.put("TICK", "0");
			sql.put("SPEEDMOD", "1.0");
			
			if (Database.add("CHARACTERS", sql)) {
				System.out.println("Character " + charName + " was created.");
			} else {
				System.out.println("Character Creation failed.");
			}
		} else {
			System.out.println("Character Creation failed.");
		}
			
	}
	
	public void load(int id) throws SQLException {
		HashMap<String, String> data = DatabasePlayerCharacter.getById(id);
		System.out.println(data.toString());
//		setName(data.get("NAME"));
//		setStr(Integer.parseInt(data.get("STR")));
//		setDex(Integer.parseInt(data.get("DEX")));
//		setEnd(Integer.parseInt(data.get("END")));
//		setMag(Integer.parseInt(data.get("MAG")));
//		setTick(Integer.parseInt(data.get("TICK")));
//		setSpeedMod(Double.parseDouble(data.get("SPEEDMOD")));
		showStats();
	}

	public void showStats() {
		System.out.println("----------------------------------------------");
		System.out.println("Name:\t\t" + getName());
		System.out.println("Stärke:\t\t" + getStr());
		System.out.println("Magie:\t\t" + getMag());
		System.out.println("Geschick:\t" + getDex());
		System.out.println("Gesundheit:\t" + getEnd());
		System.out.println("----------------------------------------------");
	}

	/**
	 * Calculates the current Speed Modifier using Modifies from Buffs/Debuffs. Doesn't change Dex.
	 * Currently only sets it to 1.0
	 * TODO: Actual Buff/Debuff System
	 */
	public void calculateSpeedMod() {
		this.setSpeedMod(1.0);
	}
	
	
	// Getter/Setter Block
	public String getName() {
		return name;
	}

	public PlayerCharacter setName(String name) {
		this.name = name;
		return this;
	}

	public int getEnd() {
		return end;
	}

	public PlayerCharacter setEnd(int end) {
		this.end = end;
		return this;
	}

	public int getMag() {
		return mag;
	}

	public PlayerCharacter setMag(int mag) {
		this.mag = mag;
		return this;
	}
	
	public int getStr() {
		return str;
	}
	public PlayerCharacter setStr(int str) {
		this.str = str;
		return this;
	}
	
	public int getDex() {
		return dex;
	}
	public PlayerCharacter setDex(int dex) {
		this.dex = dex;
		return this;
	}
	
	public int getTick() {
		return tick;
	}
	public PlayerCharacter setTick(int tick) {
		this.tick = tick;
		return this;
	}

	public double getSpeedMod() {
		return speedMod;
	}

	public PlayerCharacter setSpeedMod(double speedMod) {
		this.speedMod = speedMod;
		return this;
	}
	
	public int getId() {
		return id;
	}
	
	public PlayerCharacter setId(int id) {
		this.id = id;
		return this;
	}
}
