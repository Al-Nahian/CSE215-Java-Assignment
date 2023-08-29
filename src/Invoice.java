import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Invoice {
	private Book[] book;
	private LocalDateTime date;
	private int numberOfBooks=0;
	
	public Invoice() {
		book = new Book[numberOfBooks+1];
	}
	
	
	public void addBook(Book b) {
		if(numberOfBooks==book.length) {
			Book[] temp = new Book[numberOfBooks+1];
			System.arraycopy(book, 0, temp, 0, book.length);
			book=temp;
		}
		book[numberOfBooks++]=b;
	}

	private String getDateTime() {
		date = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formatDateTime=date.format(format);
		return formatDateTime;
	}
	
	public double getFinalPrice() {
		double price=0;
		double p=calculateBookDiscountPrice();
		double finalbookPrice=calculateAuthorDiscountPrice();
		double finalgenreprice=calculateGenreDiscountPrice();
			if(p<finalbookPrice && p<finalgenreprice)
				price = p;
			else if(finalbookPrice<p && finalbookPrice<finalgenreprice)
				price = finalbookPrice;
			else if(finalgenreprice<finalbookPrice && finalgenreprice<p)
				price = finalgenreprice;
		return price;
		}
		
	
	
	private double calculateGenreDiscountPrice() {
		double price=calculatePrice(),sum1=0,sum2=0,fictionPrice=0,nonfictionPrice=0;
		for(int i=0;i<numberOfBooks;i++) {
			if(book[i].getGenre().equals("Fiction")) {
				fictionPrice=(book[i].getPrice()*0.09);
				sum1+= fictionPrice;
			}
			else if(book[i].getGenre().equals("NonFiction")){
				nonfictionPrice=(book[i].getPrice()*0.1);
				sum2+=nonfictionPrice;
			}
		}
		price=price-(sum1+sum2);
		return price;
	}
	
	private double calculatePrice() {
		double finalPrice=0;
		for(int i=0;i<numberOfBooks;i++) {
			finalPrice += book[i].getPrice();
		}
		return finalPrice;
	}
	
	private double calculateAuthorDiscountPrice() {
		double p=0,sum=0,price = calculatePrice();
		if(isAuthorDiscountEligible()) {
		int i=0;
			for(int j=0;j<numberOfBooks;j++) {
				
				if(book[i].getAuthor().equals(book[j].getAuthor())) {
					p=(book[j].getPrice()*0.45);
					sum+=p;
				}
			
			}	
			}
		
			return price = price-sum;
	}
	
	private boolean isAuthorDiscountEligible() {
		int a=0;
		if(numberOfBooks>=3) {
		for(int i=0;i<numberOfBooks;i++) {
			for(int j=0;j<numberOfBooks;j++) {
			if(book[i].getAuthor().equals(book[j].getAuthor())) {
				a=1+a;
			}}
		}}
		if(a>=9)
		return true;
		else
			return false;
	}
	
	private double calculateBookDiscountPrice() {
		double sum=0,price=0;
		for(int i=0;i<numberOfBooks;i++) {
			price=book[i].getPrice()-(book[i].getPrice()*(book[i].getPercentageDiscount()/100.0));
			sum+=price;
		}
		return sum;
	}
	
	public String[] printBook() {
		String[] str = new String[book.length];
		int i =0;
		for(Book e : book) {
			for(i=0;i<book.length;i++) {
				str[i] = (e.getName() + ",  Price : " + e.getPrice() + "\n");
			}
		}
			
		return str;
	}
	
	public String totalPrice() {
		return "Total Price : \n" + calculatePrice() + "\n" + "Price After Discount : \n" + getFinalPrice() + "\n";
	}
	
	public String getParchaseDate() {
		return getDateTime();
	}
	
	public String toString() {
		return "Books : " + Arrays.asList(book);
	}
}

