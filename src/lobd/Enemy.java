package lobd;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "enemys")
public class Enemy {

	/**
	 * Empty Constructor, needed for ORMLite
	 */
	public Enemy() {
		
	}
	
	public int tickCount = 0;
	
	@DatabaseField(generatedId = true, useGetSet = true)
	private int id;
	
	@DatabaseField(canBeNull = false, useGetSet = true)
	private String name;
	
	@DatabaseField(canBeNull = false, useGetSet = true)
	private int str;
	
	@DatabaseField(canBeNull = false, useGetSet = true)
	private int dex;
	
	@DatabaseField(canBeNull = false, useGetSet = true)
	private int end; 
	
	@DatabaseField(canBeNull = false, useGetSet = true)
	private int mag;
	
	@DatabaseField(canBeNull = false, useGetSet = true)
	private int tick;
	
	@DatabaseField(canBeNull = false, useGetSet = true)
	private double speedMod;
	
	/**
	 * Calculates the current Speed Modifier using Modifies from Buffs/Debuffs. Doesn't change Dex.
	 * Currently only sets it to 1.0
	 * TODO: Actual Buff/Debuff System
	 */
	public void calculateSpeedMod() {
		this.setSpeedMod(1.0);
	}

	
	// Getter/Setter Block
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the str
	 */
	public int getStr() {
		return str;
	}

	/**
	 * @param str the str to set
	 */
	public void setStr(int str) {
		this.str = str;
	}

	/**
	 * @return the dex
	 */
	public int getDex() {
		return dex;
	}

	/**
	 * @param dex the dex to set
	 */
	public void setDex(int dex) {
		this.dex = dex;
	}

	/**
	 * @return the end
	 */
	public int getEnd() {
		return end;
	}

	/**
	 * @param end the end to set
	 */
	public void setEnd(int end) {
		this.end = end;
	}

	/**
	 * @return the mag
	 */
	public int getMag() {
		return mag;
	}

	/**
	 * @param mag the mag to set
	 */
	public void setMag(int mag) {
		this.mag = mag;
	}

	/**
	 * @return the tick
	 */
	public int getTick() {
		return tick;
	}

	/**
	 * @param tick the tick to set
	 */
	public void setTick(int tick) {
		this.tick = tick;
	}

	/**
	 * @return the speedMod
	 */
	public double getSpeedMod() {
		return speedMod;
	}

	/**
	 * @param speedMod the speedMod to set
	 */
	public void setSpeedMod(double speedMod) {
		this.speedMod = speedMod;
	}
}
