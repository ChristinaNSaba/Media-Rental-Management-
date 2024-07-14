import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class TestDriver {

	public static void main(String[] args) throws IOException {

		File f = new File("ProjectFile.txt"); // declaring the file to save the data in and keep appending the
												// information every time a new one is added
		FileWriter myWriter = new FileWriter(new File("ProjectFile.txt"), true);
		PrintWriter out = new PrintWriter(myWriter);
		if (!f.exists()) {
			System.out.println("This file does not exist!");
			System.exit(1);
		}

		MediaRentalManager m = new MediaRentalManager(); // creating a media rental manager to add the data to the
															// specific methods created
		ArrayList<Customer> custArray = new ArrayList<>();
		custArray = m.getCustomerDatabase();

		while (true) {
			System.out.println("Welcome to Media Rental System ");
			System.out.println("Check the Menu Choices: ");

			System.out.println("case 1: Add customers: ");
			System.out.println("case 2: Add Media: ");
			System.out.println("case 3: Display Customers' Information: ");
			System.out.println("case 4: Display Media Information: ");
			System.out.println("case 5: Add to Cart: ");
			System.out.println("case 6: Remove from Cart: ");
			System.out.println("case 7: Search in Media: ");
			System.out.println("case 8: Return from Media: ");
			System.out.println("case 9: Process Limited Plan Customers' requests: ");
			System.out.println("case 10: Process Unlimited Plan Customers' requests: ");
			System.out.println("case 11: Set Limited Plan Limit: ");
			System.out.println("case 12: Exit the System: ");

			Scanner o = new Scanner(System.in);
			System.out.println("Enter the case you want to choose: ");
			int c = o.nextInt();
			switch (c) { // a switch case to give the user options to do in the rental system
			case 1:
				System.out.println("Enter the name: ");
				String name = o.next();
				while (true) {

					if (nameRepeated(name, custArray)) { // checking if there is a name repeated and asking the user to
															// enter another name again
						System.out.println("This name already exists try again!");
						name = o.next();
					} else
						break;
				}

				System.out.println("Enter the address: ");
				String address = o.next();
				System.out.println("Enter the plan: ");
				String plan = o.next();
				while (!plan.equalsIgnoreCase("limited") && !plan.equalsIgnoreCase("unlimited")) {
					System.out.println("Invalid input. Enter the customer's plan again: ");
					plan = o.next();
				}
				m.addCustomer(name, address, plan); // adding the customer information to the arrayList in the media
													// rental manager class
				break;
			case 2:
				System.out.println("Which kind do you want to add? Album or Movie or Game? ");
				String ch = o.next();
				if (ch.toLowerCase().contains("album")) {
					System.out.println("Enter the album's name: ");
					String name1 = o.next();
					int numOfCopies = 0;
					try {
						System.out.println(" Enter the number of copies: ");
						numOfCopies = o.nextInt();
					} catch (IllegalArgumentException e) {
						System.out.println("Invalid input!");
					}
					System.out.println(" Enter the artist name: ");
					String artistName = o.next();
					System.out.println(" Enter a song: ");
					String song = o.next();

					m.addAlbum(name1, numOfCopies, artistName, song); // adding the album data to the media arrayList in
																		// the media rental manager class

				} else if (ch.toLowerCase().contains("movie")) {
					System.out.println("Enter the movie's name: ");
					String title = o.next();
					int numOfCopies1 = 0;
					try {
						System.out.println("Enter the number of copies");
						numOfCopies1 = o.nextInt();
					} catch (IllegalArgumentException e) {
						System.out.println("Invalid input!");
					}
					System.out.println(" Enter  the movie's rating (DR or HR or AC): ");
					String rating = o.next();
					while (!rating.equalsIgnoreCase("DR") && !rating.equalsIgnoreCase("HR") && !rating.equals("AC")) {
						System.out.println("Invalid responce. Enter the rating again: ");
						rating = o.next().toLowerCase();
					}
					m.addMovie(title, numOfCopies1, rating); // adding the movie to the media arrayList in the media
																// rental manager class

				} else if (ch.toLowerCase().contains("game")) {
					System.out.println("Enter the game's name: ");
					String name2 = o.next();
					int numOfCopies2 = 0;
					try {
						System.out.println(" Enter the number of copies: ");
						numOfCopies2 = o.nextInt();
					} catch (IllegalArgumentException e) {
						System.out.println("Invalid input!");
					}
					System.out.println(" Enter the game's weight : ");
					double weight = o.nextDouble();

					m.addGame(name2, numOfCopies2, weight); // adding the game to the media arrayList in the media
															// rental manager class

				} else
					System.out.println("Invalid input! Enter an album or movie or game!");
				break;
			case 3:
				System.out.println(m.getAllCustomersInfo());
				out.println(m.getAllCustomersInfo()); // printing the customers' data in the file
				break;
			case 4:
				System.out.println(m.getAllMediaInfo());
				out.println(m.getAllMediaInfo()); // printing the media data in the file
				break;
			case 5:
				System.out.println("Enter a customer name to add media to the cart: ");
				String name3 = o.next();
				System.out.println("Enter the media title to add to the cart: ");
				String mediaTitle = o.next();
				System.out.println(m.addToCart(name3, mediaTitle));
				out.println(m.addToCart(name3, mediaTitle)); // adding an item to the cart of a specific customer and
																// printing in the file
				break;
			case 6:
				System.out.println("Enter a customer name to remove from cart: ");
				String name1 = o.next();
				System.out.println("Enter the media title to remove from the cart: ");
				String mediaTitle1 = o.next();
				System.out.println(m.removeFromCart(name1, mediaTitle1)); // removing an item from the cart of a
																			// specific customer
				out.println(m.removeFromCart(name1, mediaTitle1));
				break;
			case 7:
				System.out.println(" Enter media title: ");
				String mediaTitle2 = o.next();
				System.out.println(" Enter a rating: ");
				String rating = o.next();
				System.out.println(" Enter artist name: ");
				String artist = o.next();
				System.out.println(" Enter a song name");
				String song2 = o.next();

				ArrayList<String> searchMedia = m.searchMedia(mediaTitle2, rating, artist, song2);
				for (int i = 0; i < searchMedia.size(); i++) {
					System.out.println(searchMedia.get(i));
					out.println(searchMedia.get(i)); // printing the media the is searched for in the file
				}
				break;
			case 8:
				System.out.println("Enter customer name to return from cart: ");
				String name2 = o.next();
				System.out.println("Enter the media title to return: ");
				String mediaTitle3 = o.next();
				System.out.println(m.returnMedia(name2, mediaTitle3));
				out.println(m.returnMedia(name2, mediaTitle3)); // returning an item from the media
				out.close();
				break;
			case 9:
				System.out.println(m.processRequestsOne());
				out.println(m.processRequestsOne()); // printing the process request method in the media rental manager
														// in
														// the file for the limited plan customers
				break;
			case 10:
				System.out.println(m.processRequestsTwo());
				out.println(m.processRequestsTwo()); // printing the process request method in the media rental manager
														// in
														// the file for the unlimited plan customers
				break;
			case 11:
				testSettingLimitedPlanLimit(); // setting a specific limit for the plan
				break;
			case 12:
				System.exit(0); // Exiting the program
				out.close();
			}

		}

	}

	public static boolean nameRepeated(String name, ArrayList<Customer> cust) { // a method to check the names repeated
																				// and ask the user to enter again

		if (cust == null)
			return false;
		else {
			for (int i = 0; i < cust.size(); i++) {
				Customer c = cust.get(i);
				if (c.getName().toLowerCase().equals(name.toLowerCase()))
					return true;
			}
			return false;

		}
	}

	public static void testSettingLimitedPlanLimit() throws IllegalArgumentException { // a method to set the limit of a
																						// plan
		MediaRentalManager m = new MediaRentalManager();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the plan limit value: ");
		try {
			int limit = input.nextInt();
			if (limit == 0) {
				limit = 2;
			}
			m.setLimitedPlanLimit(limit);

		} catch (IllegalArgumentException e) {
			System.out.println("Invalid input!");
		}

	}
}
