package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Task;

class TaskTest {

	private String id, name, desc;
	private String badID, badName, badDesc;

	@BeforeEach
	void setUp() {
		id = "1234567890";
		name = "1-2-3-4-5-6-7-8-9-0-";
		desc = "This is the task description";
		badID = "abcdefghijklmnopqrstuvwxyz";
		badName = "1234567890abcdeghijklmnopqrstuvwxyz";
		badDesc = "this description needs to be over 50 characters in order to unsatisfy test condition.";
	}

	@Test
	void getTaskIdTest() {
		Task task = new Task(id);
		Assertions.assertEquals(id, task.getID());
	}

	@Test
	void taskIdNullTest() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Task(null));
	}

	@Test
	void badIDTest() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Task(badID));
	}

	@Test
	void getNameTest() {
		Task task = new Task(id, name);
		Assertions.assertEquals(name, task.getName());
	}

	@Test
	void setNameTest() {
		Task task = new Task();
		task.setName(name);
		Assertions.assertEquals(name, task.getName());
	}

	@Test
	void nameNullTest() {
		Task task = new Task();
		Assertions.assertThrows(IllegalArgumentException.class, () -> task.setName(null));
	}

	@Test
	void badNameTest() {
		Task task = new Task();
		Assertions.assertThrows(IllegalArgumentException.class, () -> task.setName(badName));
	}

	@Test
	void setDescriptionTest() {
		Task task = new Task();
		task.setDesc(desc);
		Assertions.assertEquals(desc, task.getDesc());
	}
	
	@Test
	void getDescriptionTest() {
		Task task = new Task(id, name, desc);
		Assertions.assertEquals(desc, task.getDesc());
	}

	@Test
	void setBadDescriptionTest() {
		Task task = new Task();
		Assertions.assertThrows(IllegalArgumentException.class, () -> task.setDesc(badDesc));
	}

	@Test
	void taskDescriptionNullTest() {
		Task task = new Task();
		Assertions.assertThrows(IllegalArgumentException.class, () -> task.setDesc(null));
	}
}