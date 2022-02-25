/**
 * 
 */
package main;

/**
 * @author carliewhite
 *
 */
public class Task {

	private String ID;
	private String name;
	private String desc;

	public Task() {
		ID = "";
		name = "";
		desc = "";
	}

	public Task(String ID) {
		setID(ID);
		name = "";
		desc = "";
	}

	public Task(String ID, String name) {
		setID(ID);
		setName(name);
		desc = "";
	}

	public Task(String ID, String name, String desc) {
		setID(ID);
		setName(name);
		setDesc(desc);
	}

	public final String getID() {
		return ID;
	}

	public final String getName() {
		return name;
	}
	
	public final String getDesc() {
		return desc;
	}

	public void setName(String name) {
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("ERROR: Name must be between 1-20 characters");
		} else {
			this.name = name;
		}
	}

	public void setDesc(String taskDesc) {
		if (taskDesc == null || taskDesc.length() > 50) {
			throw new IllegalArgumentException("ERROR: Description must be between 1-50 characters");
		} else {
			this.desc = taskDesc;
		}
	}

	void setID(String ID) {
		if (ID == null || ID.length() > 10) {
			throw new IllegalArgumentException("ERROR: ID must between 1-10 characters");
		} else {
			this.ID = ID;
		}
	}

}