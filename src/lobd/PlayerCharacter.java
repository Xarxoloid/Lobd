package lobd;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * All Playable Characters. Stored in SQLite.
 */
@DatabaseTable(tableName = "characters")
public class PlayerCharacter {
	
	/**
	 * Empty Constructor, needed for ORMLite
	 */
	public PlayerCharacter() {
		
	}
	
	/**
	 * Creates a new Characters with default Values.
	 * @param name Character Name
	 */
	public PlayerCharacter(String name) {
		setName(name);
		setStr(5);
		setDex(5);
		setEnd(5);
		setMag(5);
		setTick(0);
		setSpeedMod(1.0);
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
	
	@DatabaseField(canBeNull = false, useGetSet = true)
	private int currLvl;
	
	@DatabaseField(canBeNull = false, useGetSet = true)
	private int tempo;
	
	@DatabaseField(canBeNull = false, useGetSet = true)
	private int spirit;
	
	@DatabaseField(canBeNull = false, useGetSet = true)
	private int currHp;
	
	@DatabaseField(canBeNull = false, useGetSet = true)
	private int luck;
	
	@DatabaseField(canBeNull = false, useGetSet = true)
	private int armor;
	
	@DatabaseField(canBeNull = false, useGetSet = true)
	private int mArmor;
	
	@DatabaseField(canBeNull = false, useGetSet = true)
	private int currXP;
	
	@DatabaseField(canBeNull = false, useGetSet = true)
	private int job;
	
	@DatabaseField(canBeNull = false, useGetSet = true, dataType = DataType.SERIALIZABLE)
	private Status status;
	

	/**
	 * Prints the Characters Stats into the Console
	 */
	public void showStats() {
		System.out.println("----------------------------------------------");
		System.out.println("Name:\t\t" + getName() + "(" + getId() + ")");
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

	/**
	 * @return the currLvl
	 */
	public int getCurrLvl() {
		return currLvl;
	}

	/**
	 * @param currLvl the currLvl to set
	 */
	public void setCurrLvl(int currLvl) {
		this.currLvl = currLvl;
	}

	/**
	 * @return the tempo
	 */
	public int getTempo() {
		return tempo;
	}

	/**
	 * @param tempo the tempo to set
	 */
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	/**
	 * @return the spirit
	 */
	public int getSpirit() {
		return spirit;
	}

	/**
	 * @param spirit the spirit to set
	 */
	public void setSpirit(int spirit) {
		this.spirit = spirit;
	}

	/**
	 * @return the currHp
	 */
	public int getCurrHp() {
		return currHp;
	}

	/**
	 * @param currHp the currHp to set
	 */
	public void setCurrHp(int currHp) {
		this.currHp = currHp;
	}

	/**
	 * @return the luck
	 */
	public int getLuck() {
		return luck;
	}

	/**
	 * @param luck the luck to set
	 */
	public void setLuck(int luck) {
		this.luck = luck;
	}

	/**
	 * @return the armor
	 */
	public int getArmor() {
		return armor;
	}

	/**
	 * @param armor the armor to set
	 */
	public void setArmor(int armor) {
		this.armor = armor;
	}

	/**
	 * @return the mArmor
	 */
	public int getMArmor() {
		return mArmor;
	}

	/**
	 * @param mArmor the mArmor to set
	 */
	public void setMArmor(int mArmor) {
		this.mArmor = mArmor;
	}

	/**
	 * @return the currXP
	 */
	public int getCurrXP() {
		return currXP;
	}

	/**
	 * @param currXP the currXP to set
	 */
	public void setCurrXP(int currXP) {
		this.currXP = currXP;
	}

	/**
	 * @return the job
	 */
	public int getJob() {
		return job;
	}

	/**
	 * @param job the job to set
	 */
	public void setJob(int job) {
		this.job = job;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
}
