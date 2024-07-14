package application;

public class Album extends Media { // making an album object that inherits the media

	private String artistName;
	private String songs;

	public Album() {

	}

	public Album(String title, int numberOfCopies, String artistName, String songs, String code) { // an argument
																									// constructor which
		// extends the fields from the
		// super class
		super(title, numberOfCopies, code);
		this.artistName = artistName;
		this.songs = songs;

	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getSongs() {
		return songs;
	}

	public void setSongs(String songs) {
		this.songs = songs;
	}

	@Override
	public int compareTo(Media o) {
		return super.compareTo(o);
	}

	@Override
	public boolean equals(Object o) {
		return this.artistName.equals(((Album) o).artistName) && this.songs.equals(((Album) o).songs);

	}

	@Override
	public String toString() {
		return "Album [title= " + getTitle() + ", artist= " + artistName + ", songs= " + songs + ", number Of Copies= "
				+ getNumberOfCopies() + ", code= " + code + "]";
	}

}
