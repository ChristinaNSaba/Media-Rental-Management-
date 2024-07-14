package application;

public class Movie extends Media {

	private String rating;

	public Movie() {

	}

	public Movie(String title, int numOfCopies, String rating, String code) {
		super(title, numOfCopies, code);
		this.rating = rating;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public int compareTo(Media o) {
		return super.compareTo(o);
	}

	@Override
	public boolean equals(Object o) {
		return this.rating.equals(((Movie) o).rating);
	}

	@Override
	public String toString() {
		return "Movie [title= " + getTitle() + ", rating= " + rating + ", number Of Copies= " + getNumberOfCopies()
				+ ", code= " + code + "]";
	}

}
