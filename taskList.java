package Exercise;

import java.time.LocalTime;

public class taskList {

	private String taskName;
	private String status = "Not Completed";
	private LocalTime time;

	void setTime(int hr, int min) {
		this.time = LocalTime.of(hr, min);
	}

	public taskList(String taskName, LocalTime time) {
		super();
		this.taskName = taskName;
		this.time = time;
	}

	String getName() {
		return this.taskName;
	}

	void changeStatus() {
		status = "Completed";
	}

	public String toString() {
		return "{" + "Task Name: " + taskName + ", Time: " + time + ", Status: " + status + "}";
	}
}