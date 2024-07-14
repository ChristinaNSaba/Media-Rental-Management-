package application;

public abstract class Media implements Comparable<Media> { // an abstract media object in
															// which is the super class for
															// album, movie, and game

	String title;
	int numberOfCopies;	
	String code;

	public Media() {

	}

	public Media(String title, int numberOfCopies, String code) {
		this.title = title;
		this.numberOfCopies = numberOfCopies;
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNumberOfCopies() {
		return numberOfCopies;
	}

	public void setNumberOfCopies(int numberOfCopies) {
		this.numberOfCopies = numberOfCopies;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public abstract String toString(); // an abstract method to get the information of the media depending on the kind
										// available

	@Override
	public boolean equals(Object o) {
		{
			return this.title.equals(((Media) o).title) && this.numberOfCopies == ((Media) o).numberOfCopies;
		}
	}

	public int compareTo(Media o) {
		
		return this.getTitle().compareToIgnoreCase(o.getTitle());
	}

}
