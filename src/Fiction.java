
public class Fiction implements Genre {
	private static double genreDiscount;
	private String subGenre;
	private final String GENRE = "Fiction";
	
	public Fiction() {
		genreDiscount = 0.09;
		this.subGenre = "Not set!";
	}
	
	public Fiction(String subG) { 
		this.subGenre=subG;
		genreDiscount=0.09;
	}
	
	public static void setGenreDiscount(double disc) {
		genreDiscount=disc;
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
