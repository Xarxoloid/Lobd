package lobd;

import java.util.ArrayList;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@SuppressWarnings("serial")
@DatabaseTable(tableName = "status")
public class Status implements java.io.Serializable {
	
	ArrayList<Status> status = new ArrayList<Status>();

	@DatabaseField(generatedId = true, useGetSet = true)
	private int id;
	
	@DatabaseField(canBeNull = false, useGetSet = true)
	private String name;
	
	@DatabaseField(canBeNull = false, useGetSet = true)
	private int duration;
	
    public void addStatus(Status s){
           status.add(s);
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
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
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
}
