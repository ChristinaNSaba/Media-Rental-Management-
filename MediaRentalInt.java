package application;

import java.util.ArrayList;

public interface MediaRentalInt {

	public void addCustomer(String name, String address, String plan, String id, String mobile);
	
	public void addMovie(String title, int copiesAvailable, String rating, String code);

	public void addGame(String title, int copiesAvailable, double weight, String code);

	public void addAlbum(String title, int compiesAvailable, String artist, String songs, String code);

	public void setLimitedPlanLimit(int value);

	public String getAllCustomersInfo();

	public String getAllMediaInfo();

	public boolean addToCart(String customerName, String mediaTiltle, ArrayList<Customer>c, ArrayList<Media>med);

	public boolean removeFromCart(String customerName, String mediaTitle);

	public String processRequestsOne(ArrayList<Customer>c, ArrayList<Media>m);

	public ArrayList<String> searchMedia(String code);

}
