package lobd;

import java.util.Random;

public class PlayerCharacter {

	private String name;
	private int str, dex, end, mag, tick;
	private double speedMod;
	public int tickCount;
	
	public void create (String charName) {
	
		Random rand = new Random();
		this.setName(charName).setStr(rand.nextInt(255) + 1).setDex(rand.nextInt(255) + 1).setEnd(rand.nextInt(255) + 1).setMag(rand.nextInt(255) + 1);
		
		this.showStats();
			
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
}
