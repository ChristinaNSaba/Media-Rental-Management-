package application;

import java.util.ArrayList;
import java.util.Collections;

public class MediaRentalManager implements MediaRentalInt { // creating a media rental object which implements the
															// interface MediaRentalInt that was created

	private int limitedPlanLimit; // a private variable to set the limit of the plan
	private ArrayList<Customer> customerDatabase; // an arrayList of the customers
	private ArrayList<Media> mediaDatabase; // an arrayList of the media

	public MediaRentalManager() {

		limitedPlanLimit = 2; // set the limit to 2
		customerDatabase = new ArrayList<Customer>();
		mediaDatabase = new ArrayList<Media>();

	}

	public ArrayList<Customer> getCustomerDatabase() {
		return customerDatabase;
	}

	public void setCustomerDatabase(ArrayList<Customer> customerDatabase) {
		this.customerDatabase = customerDatabase;
	}

	public ArrayList<Media> getMediaDatabase() {
		return mediaDatabase;
	}

	public void setMediaDatabase(ArrayList<Media> mediaDatabase) {
		this.mediaDatabase = mediaDatabase;
	}

	private Media getMedia(String mediaCode, ArrayList<Media> med) { // a media method to get the media available

		for (int i = 0; i < med.size(); i++) { // a for loop to check if the media exists in the media
												// database and return
												// the media
			if (med.get(i).getCode().equals(mediaCode)) {
				return med.get(i);
			}
		}
		return null; // if the media does not exist then return null
	}

	public Customer findCustomer(String id, ArrayList<Customer> c) {

		for (int i = 0; i < c.size(); i++) {
			if (c.get(i).getId().equals(id)) {
				return c.get(i);
			}
		}
		return null;
	}

	public String updateCustomer(String name, String address, String plan, String id, String mobile,
			ArrayList<Customer> c) {

		Customer cust = findCustomer(id, c);
		if (cust != null) {
			cust.setId(id);
			cust.setName(name);
			cust.setAddress(address);
			cust.setPlan(plan);
			cust.setMobile(mobile);
			return cust.toString();
		} else
			return null;
	}

	@Override
	public void addCustomer(String name, String address, String plan, String id, String mobile) {

		Customer c = new Customer(name, address, plan, id, mobile);
		customerDatabase.add(c);
		// System.out.println(customerDatabase);
		System.out.println("Customer is added successfully");
	}

	public boolean deleteCustomer(String id, ArrayList<Customer> c) {

		for (int i = 0; i < c.size(); i++) {
			if (c.get(i).getId().equals(id)) {
				c.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public void addMovie(String title, int copiesAvailable, String rating, String code) {

		Movie mov = new Movie(title, copiesAvailable, rating, code);
		mediaDatabase.add(mov);
		// System.out.println(mediaDatabase);
		System.out.println("Movie is added successfully");
	}

	@Override
	public void addAlbum(String title, int copiesAvailable, String artist, String songs, String code) {

		Album alb = new Album(title, copiesAvailable, artist, songs, code);
		mediaDatabase.add(alb);
		System.out.println("Album is added successfully");
	}

	@Override
	public void addGame(String title, int copiesAvailable, double weight, String code) {

		Game gm = new Game(title, copiesAvailable, weight, code);
		mediaDatabase.add(gm);
		System.out.println("Game is added successfully");

	}

	public boolean removeAlbum(String code, ArrayList<Media> med) {

		for (int i = 0; i < med.size(); i++) {
			if (med.get(i).getCode().equals(code)) {
				med.remove(i);
				return true;
			}
		}
		return false;
	}

	public boolean removeGame(String code, ArrayList<Media> med) {

		for (int i = 0; i < med.size(); i++) {
			if (med.get(i).getCode().equals(code)) {
				med.remove(i);
				return true;
			}
		}
		return false;
	}

	public boolean removeMovie(String code, ArrayList<Media> med) {

		for (int i = 0; i < med.size(); i++) {
			if (med.get(i).getCode().equals(code)) {
				med.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public void setLimitedPlanLimit(int value) {

		this.limitedPlanLimit = value;
	}

	@Override
	public String getAllCustomersInfo() { // a method to return information of all customers in the database and sorted
											// by customer name

		Collections.sort(customerDatabase); // sort the arrayList of the students available
		String d = "All customer's info: " + "\n";

		for (int i = 0; i < customerDatabase.size(); i++) {
			d = d + customerDatabase.get(i).toString() + "\n";
		}

		return d;
	}

	@Override
	public String getAllMediaInfo() { // a method to return information of all media (album, movie, game) that are in
										// the database and the info is return sorted by media title

		String d = "Media Information: " + "\n";

		Collections.sort(mediaDatabase); // sort the arrayList of media available

		for (int i = 0; i < mediaDatabase.size(); i++) {
			d = d + mediaDatabase.get(i).toString() + "\n";
		}

		return d;
	}

	@Override
	public boolean addToCart(String id, String code, ArrayList<Customer> c, ArrayList<Media> med) {

		for (int i = 0; i < med.size(); i++) { // add to the cart if the customer exists return false else if
												// not add it to the requests arrayList
			if (c.get(i).getId().equals(id)) {

				return c.get(i).requests.add(code); // add the media title to the requests
			}
		}

		return false; // if the customer's media already exists do not add to the cart
	}

	@Override
	public boolean removeFromCart(String customerName, String mediaTitle) { // a method to remove the the specified
																			// media title from the customer's cart

		for (int i = 0; i < customerDatabase.size(); i++) {
			if (customerDatabase.get(i).getName().equals(customerName)) {

				return customerDatabase.get(i).requests.remove(mediaTitle); // remove this media title from the requests
			}
		}

		return false; // returns false if the removal failed for example when the customer name does
						// not exist in the database
	}

	public String processRequestsOne(ArrayList<Customer> c, ArrayList<Media> m) {// a method to process the customers in
																					// alphabetical order
		// and check the
		// requests cart and add media to the rented cart if there is a copy of the
		// media available

		String s = "";
		Collections.sort(c);
		for (int i = 0; i < c.size(); i++) {
			Customer cust = c.get(i);
			for (int j = 0; j < cust.requests.size(); j++) {
				String media = cust.requests.get(j);
				Media me = getMedia(media, m);

				if (cust.plan.equalsIgnoreCase("limited") && cust.rented.size() < limitedPlanLimit) { // for the limited
																										// plan, remove
																										// the entries
																										// to the rented
																										// cart when the
																										// copies are
																										// available
					if (me.numberOfCopies > 0 && me != null) {
						s = s + "Sending " + me.getTitle() + " to " + cust.getName() + "\n";
						cust.rented.add(me.getTitle());
						me.numberOfCopies--;

					}
				} else if (cust.plan.equalsIgnoreCase("unlimited")) { // for unlimited plans the media is added to the
																		// rented
					// cart as long as there are copies available

					if (me.numberOfCopies > 0 && me != null) {
						s = s + "Sending " + me.getTitle() + " to " + cust.getName() + "\n";
						cust.rented.add(me.getTitle());
						me.numberOfCopies--;
					}
				}
			}
		}
		return s;

	}

	@Override
	public ArrayList<String> searchMedia(String code) { // a method that
														// returns a
														// sorted
														// arrayList
														// with media
														// titles
		Collections.sort(mediaDatabase); // sorting the arrayList
		ArrayList<String> mediaTitle = new ArrayList<String>(); // an array list of the titles of the media

		for (int i = 0; i < mediaDatabase.size(); i++) { // checking each item and returning the existing ones that
															// match the values
			Media med = mediaDatabase.get(i);

			if (med instanceof Movie) {
				if (code != null) {
					if (((Movie) med).getCode().equals(code)) {
						mediaTitle.add(med.getTitle());
					}
				}
			}
			if (med instanceof Album) {
				if (code != null) {
					if (((Album) med).getCode().equals(code)) {
						mediaTitle.add(med.getTitle());
					}
				}
			}
			if (med instanceof Game) {
				if (code != null) {
					if (((Game) med).getCode().equals(code)) {
						mediaTitle.add(med.getTitle());
					}

				}
			}
		}
		return mediaTitle;

	}

	public Media findMedia(String code, ArrayList<Media> med) {

		for (int i = 0; i < med.size(); i++) {
			if (med.get(i).getCode().equals(code)) {
				return med.get(i);
			}
		}
		return null;

	}

}
