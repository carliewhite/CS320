package main;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author carliewhite
 *
 */

public class TaskService {

	private final List<Task> tasks = new ArrayList<>();

	private String newUniqueId() {
		return UUID.randomUUID().toString().substring(0, 10);
	}

	private Task searchForTask(String id) throws Exception {
		int index = 0;
		while (index < tasks.size()) {
			if (id.equals(tasks.get(index).getID())) {
				return tasks.get(index);
			}
			index++;
		}
		throw new Exception("The Task does not exist!");
	}

	public void newTask() {
		Task task = new Task(newUniqueId());
		tasks.add(task);
	}

	public void newTask(String name) {
		Task task = new Task(newUniqueId(), name);
		tasks.add(task);
	}

	public void newTask(String name, String desc) {
		Task task = new Task(newUniqueId(), name, desc);
		tasks.add(task);
	}

	public void deleteTask(String id) {
		try {
			tasks.remove(searchForTask(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateName(String id, String name) {
		try {
			searchForTask(id).setName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateDesc(String id, String desc) {
		try {
			searchForTask(id).setDesc(desc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Task> getTasks() {
		return tasks;
	}
}