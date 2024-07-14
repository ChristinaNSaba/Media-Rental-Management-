package application;

public class Game extends Media {

	private double weight;

	public Game() {

	}

	public Game(String title, int numberOfCopies, double weight, String code) {
		super(title, numberOfCopies, code);
		this.weight = weight;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public int compareTo(Media o) {
		return super.compareTo(o);
	}

	public boolean equals(Object o) {
		return this.weight == ((Game) o).weight;
	}

	@Override
	public String toString() {
		return "Game [title= " + getTitle() + ", weight= " + weight + ", number Of Copies= " + getNumberOfCopies()
				+ ", code= " + code + "]";

	}

}
