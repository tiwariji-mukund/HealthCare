package Exercise;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class personalData {
	private String name;
	private int age;
	private int h;
	private String g;
	private int w;
	private int bp;

	private ArrayList<taskList> taskManager = new ArrayList<>();

	// personal data constructor
	public personalData(String name, int age, int h, String g) {
		super();
		this.name = name;
		this.age = age;
		this.h = h;
		this.g = g;
		System.out.print("\nWelcome! \"" + name);
		System.out.println("\" You are succefully registered to our application.");
		System.out.println(
				"\nYour details are: \nName: " + name + "\nAge: " + age + "\nHeight: " + h + "cm" + "\nGender: " + g);

		System.out.println("Follow these rules to live a ");
	}

	// get the name from user
	public String getName() {
		return name;
	}

	// get the age from user
	public int getAge() {
		return age;
	}

	// get the height from user
	public int getHeight() {
		return this.h;
	}

	// get the gender from user
	public String getGender() {
		return this.g;
	}

	// users can also add their other data's like weight and bp
	// get the weight from user
	public int getWeight() {
		return w;
	}

	// set the weight data
	public void setWeight(int w) {
		if (w > 0) {
			this.w = w;
		}
	}

	// get the bp data from user
	public int getBP() {
		return bp;
	}

	// set the bp data
	public void setBP(int bp) {
		if (bp > 0) {
			this.bp = bp;
		}
	}

	// compare the weight with some standard weight
	void checkWt() {
		int wt = getWeight();
		if (wt >= 35 && wt <= 70) {
			System.out
					.println(wt + "kg: 'Healthy Weight'! Congratulations you are within the defined range of weight.");
		} else {
			System.out.println(wt
					+ "kg: 'Overweight'! Your weight is above the standard weight. It denotes that you are at risk of several diseases and have to adopt remedial measures for weight loss");
		}
	}

	// compare the bp with some standard bp values
	void checkBP() {
		int bp = getBP();
		if (bp >= 70 && bp <= 120) {
			System.out.println(bp + "mmHg: Normal Blood Pressure.");
		} else if (bp > 120) {
			System.out.println(bp + "mmHg: 'High Blood Pressure'! You should consult to your doctor.");
		} else {
			System.out.println(bp + "mmHg: 'Low Blood Pressure'! You should consult to your doctor.");
		}
	}

	// user can add their own tasks
	void addTask(String taskName, int hr, int min) {
		LocalTime time = LocalTime.of(hr, min);
		taskManager.add(new taskList(taskName, time));
		System.out.println("Task named, '" + taskName + "' successfully added to the list.");
	}

	// if task is completed user can mark it as done
	void updateStatus(String taskName) {
		boolean a = false;
		for (taskList task : taskManager) {
			if (task.getName().equalsIgnoreCase(taskName)) {
				task.changeStatus();
				a = true;
			}
		}
		if (a == true) {
			System.out.println("Your status for task name '" + taskName + "' is successfully updated.");
		} else {
			System.out.println("OOPS! Task name '" + taskName + "' is not available in the list.");
		}
	}

	// delete any task
	void deleteTask(String taskName) {
		Iterator<taskList> it = taskManager.iterator();
		boolean x = false;
		while (it.hasNext()) {
			if (it.next().getName().equals(taskName)) {
				it.remove();
				x = true;
			}
		}
		if (x == true) {
			System.out.println("Task name '" + taskName + "' is deleted successfully from the list.");
		} else {
			System.out.println("OOPS! Task name '" + taskName + "' is not available in the list.");
		}
	}

	// if delete all the task or clear the task list
	void clear() {
		taskManager.clear();
		System.out.println("All tasks from the Task Lists are successfully removed.");
		System.out.println("Task List is empty");
	}

	// view my task list
	void myTask() {
		System.out.println("Your Task List: ");
		System.out.println(taskManager);
	}

	// main men
	int menu() {
		int a;
		Scanner s = new Scanner(System.in);
		System.out.println("Press 1 to check your Diseases.");
		System.out.println("Press 2 to check in which category your weight lies.");
		System.out.println("Press 3 to know your Blood Pressure category.");
		System.out.println("Press 4 to create your own Task List.");
		System.out.println("Press 5 to view your profile.");
		System.out.println("Press 6 to exit from Main Menu.");
		System.out.println();
		System.out.print("Enter your choice: ");
		a = s.nextInt();
		System.out.println();
		// s.close();
		return a;

	}

	public String toString() {
		return ("Your Health Profile: " + "\nName: " + name + "\nAge: " + age +
				"\nGender: " + g + "\nHeight: " + h + "cm" + "\nWeight: " + w + "kg" +
				"\nBlood Pressure: " + bp + "mmHg" +
				"\nYour Scheduled Tasks:\n " + taskManager);
	}
}