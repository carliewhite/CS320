/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.TaskService;

/**
 * @author carliewhite
 *
 */

class TaskServiceTest {

	private String name, desc;
	private String badName, badDesc;

	@BeforeEach
	void setUp() {
		name = "The perfect length  ";
		desc = "This is a fifty character description             ";
		badName = "12345678909876543321234567890";
		badDesc = "qwertyuioplkjhgfdsazxcvbnmklkjhgfdsaqwertyuioppppppplkjhgfdsazxcvbnmkloiuytrewsdfgtbhj";
	}

	@Test
	void newTaskTest() {
		TaskService service = new TaskService();
		service.newTask();
		Assertions.assertNotNull(service.getTasks().get(0).getID());
		Assertions.assertNotEquals("", service.getTasks().get(0).getID());
	}
	
	@Test
	void deleteTaskTest() {
		TaskService service = new TaskService();
		service.newTask();
		assertEquals(1, service.getTasks().size());
		service.deleteTask(service.getTasks().get(0).getID());
		assertEquals(0, service.getTasks().size());
	}

	@Test
	void taskNameTest() {
		TaskService service = new TaskService();
		service.newTask(name);
		Assertions.assertNotNull(service.getTasks().get(0).getName());
		Assertions.assertEquals(name, service.getTasks().get(0).getName());
	}

	@Test
	void taskBadNameTest() {
		TaskService service = new TaskService();
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.newTask(badName));
	}
	
	@Test
	void updateNameTest() throws Exception {
		TaskService service = new TaskService();
		service.newTask();
		service.updateName(service.getTasks().get(0).getID(), name);
		assertEquals(name, service.getTasks().get(0).getName());
	}

	@Test
	void taskNameNullTest() {
		TaskService service = new TaskService();
		assertThrows(IllegalArgumentException.class, () -> service.newTask(null));
	}
	
	@Test
	void taskDescriptionTest() {
		TaskService service = new TaskService();
		service.newTask(name, desc);
		Assertions.assertNotNull(service.getTasks().get(0).getDesc());
		Assertions.assertEquals(desc, service.getTasks().get(0).getDesc());
	}
	
	@Test
	void updateDescriptionTest() throws Exception {
		TaskService service = new TaskService();
		service.newTask();
		service.updateDesc(service.getTasks().get(0).getID(), desc);
		assertEquals(desc, service.getTasks().get(0).getDesc());
	}
	
	@Test
	void badDescTest() {
		TaskService service = new TaskService();
		assertThrows(IllegalArgumentException.class, () -> service.newTask(name, badDesc));
	}

	@Test
	void nullDescTest() {
		TaskService service = new TaskService();
		assertThrows(IllegalArgumentException.class, () -> service.newTask(name, null));
	}

}