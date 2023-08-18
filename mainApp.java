package Exercise;

import java.util.Random;
import java.util.Scanner;

public class mainApp {

	// private array of String for quotes
	private static final String[] quotes = {
			"Health is a state of complete harmony of the body, mind, and spirit. - B.K.S. Iyengar",
			"The greatest wealth is health. - Virgil",
			"To keep the body in good health is a duty... otherwise we shall not be able to keep our mind strong and clear. - Buddha",
			"The first wealth is health. - Ralph Waldo Emerson",
			"A healthy outside starts from the inside. - Robert Urich",
			"Good health and good sense are two of life's greatest blessings. - Publilius Syrus",
			"Take care of your body. It's the only place you have to live. - Jim Rohn",
			"Happiness is the highest form of health. - Dalai Lama",
			"An apple a day keeps the doctor away. - Proverb",
			"Your body hears everything your mind says. - Naomi Judd"
	};

	// function to generate random quotes
	public static String getRandomQuote() {
		Random random = new Random();
		int randomIndex = random.nextInt(quotes.length);
		return quotes[randomIndex];
	}

	// main method
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Welcome to \"KRATIN HEALTH CARE\".");
		System.out.println("Let's Innovate");
		System.out.println("\n*It is an application which is designed for better life of older people.");
		System.out.println("*In this application user can check the proper cure of their diseases.");
		System.out.println("*User can also create their \"TASK LIST\" to follow their day to day routine.");
		System.out.println("\nTo start with it, please enter the following details");
		System.out.println();
		// taking some basic details as input
		System.out.print("Enter your name: ");
		String name = s.nextLine();
		System.out.print("Enter your age: ");
		int age = s.nextInt();
		System.out.print("Enter your height(cm): ");
		int h = s.nextInt();
		System.out.print("Enter your gender (M/F): ");
		String g = s.next();
		System.out.println();
		String randomQuotes = getRandomQuote();
		System.out.println("***********************");
		System.out.println("Quotes: " + randomQuotes);
		System.out.println("***********************");

		// calling the personalData constructor to create an object from the given
		// details
		personalData data = new personalData(name, age, h, g);
		System.out.println();
		int l = 0;
		// main menu section of my application
		System.out.println("Let's explore some MAIN MENU of our application.");
		do {
			System.out.println();
			System.out.println("MAIN MENU");
			System.out.println();

			// called main menu from the personalData constructor
			int x = data.menu();

			// here I listed some common diseases associated with the elderly people along
			// with their proper prescription
			switch (x) {
				case 1: {
					System.out.println();
					System.out.println("PLease mention if you have any of the following issues ?");
					System.out.println("\n(1) Cardiovascular Diseases");
					System.out.println("(2) Thyroid");
					System.out.println("(3) Respiratory Diseases");
					System.out.println("(4) Diabetes");
					System.out.println("(5) Osteoarthritis");
					System.out.println("(6) None");
					int c = 5;
					do {
						System.out.print("\nEnter your choice: ");
						int option = s.nextInt();
						System.out.println();
						switch (option) {
							case 1: {
								System.out.println(
										"(1) Hyper/Hypo: You should focus more on diet, exercise and eat less salt and monitor your BP regularly.");
								c = 6;
								break;
							}
							case 2: {
								System.out.println(
										"(2) Thyroid: Maintain regular thyroid function tests and work closely with your healthcare provider to manage thyroid conditions effectively.");
								c = 6;
								break;
							}
							case 3: {
								System.out.println(
										"(3) Asthma: Diet, Do exercise regularly but avoid vigours exercise and also \"NO SMOKING\".");
								c = 6;
								break;
							}
							case 4: {
								System.out.println(
										"(4) Diabetes: Manage diabetes through a balanced diet, regular exercise, medication adherence, and routine monitoring of blood sugar levels under the guidance of your healthcare provider.");
								c = 6;
								break;
							}
							case 5: {
								System.out.println(
										"(5) Osteoarthritis: Do exericse, manage your weight, apply pain relief strategies and medical guidance to enhance joint function and minimize discomfort.");
								c = 6;
								break;
							}
							case 6: {
								System.out.println("That's great, you maintained yourself very well.");
								System.out.println("Here are some tips for further prevention.");
								System.out.println(
										"Take proper diet and walk for atleast 30 mins. twice a day, also consult your doctor timely.");
								c = 6;
								break;
							}

							// any other option selected apart form the given ones
							default:
								System.out.println("Please enter valid option.");
								return;
						}
					} while (c != 6);
					break;
				}
				// option to check the weight
				case 2: {
					System.out.print("Enter your Weight(kg): ");
					int wt = s.nextInt();
					data.setWeight(wt);
					data.checkWt();
					break;
				}

				// option to monitor the blood pressure
				case 3: {
					System.out.println("BLOOD PRESSURE MONITOR");
					System.out.println();
					System.out.print("Enter your Blood Pressure(in 'mmHg'): ");
					int bp = s.nextInt();
					data.setBP(bp);
					data.checkBP();
					break;
				}

				// option to view the task manager
				case 4: {
					System.out.println("TASK MANAGER");
					System.out.println();
					System.out.println("Create and Schedule your own task and set its time");
					System.out.println();
					int q = 3;
					do {
						System.out.print("Enter your task name: ");
						s.nextLine();
						String tn = s.nextLine();
						System.out.print("Enter the schedule time(HH:MM): ");
						int hr = s.nextInt();
						int min = s.nextInt();
						data.addTask(tn, hr, min);
						System.out.println();
						System.out.println("Press 0 to add another task.");
						System.out.println("Press 1 to explore other options available in TASK LIST.");
						System.out.println("Press 2 to go back to MAIN MENU.");
						System.out.println();
						System.out.print("Enter your choice: ");
						q = s.nextInt();
					} while (q == 0);

					while (q == 1) {
						System.out.println();
						char y;
						System.out.println("Welcome to the TASK LIST.");
						System.out.println("Available options for TASK LIST are: ");
						do {
							System.out.println();
							System.out.println("Press a to view your created TASK LIST.");
							System.out.println("Press b to update the status of completed tasks.");
							System.out.println("Press c to delete particular task from TASK LIST.");
							System.out.println("Press d to clear all tasks from TASK LIST.");
							System.out.println("Press e to go back to the MAIN MENU.");
							System.out.println();
							System.out.print("Enter your choice: ");
							y = s.next().charAt(0);
							switch (y) {
								case 'a': {
									System.out.println();
									data.myTask();
									break;
								}
								case 'b': {
									System.out.println();
									System.out.print("Enter the task name which you have completed: ");
									s.nextLine();
									String test = s.nextLine();
									data.updateStatus(test);
									break;
								}
								case 'c': {
									System.out.println();
									System.out.print("Enter the task name which you wish to delete: ");
									s.nextLine();
									String t = s.nextLine();
									data.deleteTask(t);
									break;
								}
								case 'd': {
									System.out.println();
									data.clear();
									break;
								}
								case 'e': {
									q = 5;
									break;
								}
								default: {
									System.out.println();
									System.out.print("Please enter valid choice.");
									return;
								}
							}
						} while (y != 'e');
					}
					break;
				}

				case 5: {
					System.out.println(data);
					break;
				}
				case 6: {
					l = 5;
					break;
				}
				default:
					System.out.println("Please enter valid choice.");
			}
		} while (l == 0);
		System.out.println();
		System.out.println(
				"\"To ensure GOOD HEALTH: Eat lightly, breathe deeply, live moderately, mild exercise daily and maintain an interest in life.\" \n");
		System.out.println("THANK YOU!");

		s.close();
	}
}