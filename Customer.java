package application;

import java.util.ArrayList;

public class Customer implements Comparable<Customer> { // creating a customer object which
														// implements comparable interface

	String name;
	String address;
	String plan;
	String id;
	String mobile;
	ArrayList<String> requests;
	ArrayList<String> rented;

	public Customer() {
	}

	public Customer(String name, String address, String plan, String id, String mobile) {
		this.name = name;
		this.address = address;
		this.plan = plan;
		this.id = id;
		this.mobile = mobile;
		requests = new ArrayList<String>();
		rented = new ArrayList<String>();

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public ArrayList<String> getRequests() {
		return requests;
	}

	public void setRequests(ArrayList<String> requests) {
		this.requests = requests;
	}

	public ArrayList<String> getRented() {
		return rented;
	}

	public void setRented(ArrayList<String> rented) {
		this.rented = rented;
	}

	@Override
	public String toString() {
		return "Customer [name= " + name + ", address= " + address + ", mobile= " + mobile + ", id= " + id + ", plan= "
				+ plan + "]";
	}

	public boolean equals(Object o) {
		Customer c = (Customer) o;
		return this.name.equals(c.name) && this.address.equals(c.address) && this.plan.equals(c.plan);

	}

	public int compareTo(Customer o) {

		return this.getName().compareToIgnoreCase(o.getName());
	}

}
