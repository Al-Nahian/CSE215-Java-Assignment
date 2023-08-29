import java.lang.reflect.Array;
import java.util.Arrays;

public class Book implements Comparable<Book> {
	private String name;
	private double price;
	private Author writer;
	private Genre genre;
	private double percentageDiscount;
	private String isbn;
	private int yearOfPublish;
	
	public Book() {
		this.name="Not set!";
		this.price=0;
		writer=new Author();
		
		this.percentageDiscount=0;
		this.isbn="Not given!";
		this.yearOfPublish=0;
	}
	
	public Book(String name,double price,Author a,double percentageDisc,Genre genre,String isbn,int yearofpub) {
		this.name=name;
		this.price=price;
		writer=a;
		this.genre=genre;
		this.percentageDiscount=percentageDisc;
		this.isbn=isbn;
		this.yearOfPublish=yearofpub;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public Author getAuthor() {
		return writer;
	}
	
	public String getSubGenre() {
		return genre.getSubGenre();
	}
	
	public String getGenre() {
		return genre.getGenre();
	}
	
	
	public double getPercentageDiscount() {
		return percentageDiscount;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public int getYearOfPublish() {
		return yearOfPublish;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setPrice(double price) {
		this.price=price;
	}
	
	public void setPercentageDiscount(double dis) {
		this.percentageDiscount=dis;
	}
	
	public void getIsbn(String isbn) {
		this.isbn=isbn;
	}
	
	public void setYearOfPublish(int year) {
		this.yearOfPublish=year;
	}
	
	public int compareTo(Book b) {
		return this.isbn.compareTo(b.isbn);
	}
	
	public String toString() {
		return "\nBook Name : " + getName() + ";\nISBN number : " + getIsbn()+";\nPrice : " + getPrice() + ";\nYear Of Publish : " + getYearOfPublish() + "\nAuthor Info : \n" + Arrays.asList(writer);
	}
}
