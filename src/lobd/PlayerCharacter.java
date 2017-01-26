package lobd;

import java.util.Random;

public class PlayerCharacter {

	public String name;
	private int str, dex, end, mag, tick;
	
	public void create (String charName) {
	
		Random rand = new Random();
		setName(charName).setStr(rand.nextInt(255) + 1).setDex(rand.nextInt(255) + 1).setEnd(rand.nextInt(255) + 1).setMag(rand.nextInt(255) + 1);
		
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
}
