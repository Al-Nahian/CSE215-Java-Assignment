
public class NonFiction implements Genre {
	private static double genreDiscount;
	private String subGenre;
	private final String GENRE = "NonFiction";
	
	public NonFiction() {
		genreDiscount = 0.1;
		this.subGenre = "Not set!";
	}
	
	public NonFiction(String subG) {
		this.subGenre=subG;
		genreDiscount=0.1;
	}

	public static void setGenreDiscount(double genreDisc) {
		genreDiscount=genreDisc;
	}
	
	@Override
	public double getGenreDiscount() {
		return genreDiscount;
	}

	@Override
	public String getSubGenre() {
		return subGenre;
	}

	@Override
	public void setSubGenre(String genre) {
		this.subGenre=genre;
	}

	@Override
	public String getGenre() {
		return GENRE;
	}
	
	
}
