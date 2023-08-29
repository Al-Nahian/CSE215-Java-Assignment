import java.util.Arrays;

public class BookCollection {
	private static Book[] books;
	private int numberOfBooks=0;
	private int nextIndex=0;
	private final int MAX_SIZE=10000;

	public BookCollection() {
		books=new Book[numberOfBooks+1];
	}
	
	
	public boolean addBook(Book b) {
		if(numberOfBooks==MAX_SIZE)
			return false;
		else if(numberOfBooks==books.length) {
			Book[] temp = new Book[numberOfBooks+1];
			System.arraycopy(books, 0, temp, 0, books.length);
			books=temp;
		}
			books[numberOfBooks++]=b;
		return true;
	}
	
	public String showBook(int index) {
		if(index>=0) {
		
			return  "ISBN: " + books[index].getIsbn() + " || " + books[index].getName() + " || Price: " + books[index].getPrice() + " || " ;
		}
			return null;
		
	}
	
	private void removeBook(int index) {
		if(index>=0) {
		for(int i=index;i<books.length-1;i++) {
			books[i]=books[i+1];
		}
			books[--numberOfBooks]=null;
		}
	}
	
	public Book getBook(Book b) {
		for(int i =0 ;i<books.length;i++) {
			if(books[i]==b) 
			removeBook(getIndex(b));
		}
		return b;
	}
	
	public Book getNext() {
		return books[nextIndex++];
	}
	
	public boolean hasNext() {
		if(books[nextIndex]!=null && nextIndex<books.length)
			return true;
		else 
			return false;
	}
	
	public void resetBooks() {
		nextIndex=0;
	}
	
	private int getIndex(Book b) {
		for(int i =0;i<books.length;i++) {
			if(books[i]==b) {
				return i;
			}
		}
		return -1;
	}
	
	public int searchBook(String a) {
		for(int i=0;i<books.length;i++) {
			if(books[i].getIsbn()==a) {
				return i;
			}	
		}
		return -1;
	}
	
	public Book searchBookObj(String a) {
		for(int i=0;i<books.length;i++) {
			if(books[i].getIsbn().equals(a)) {
				return books[i];
			}	
		}
		return null;
	}
	
	public void getAuthAge() {
		for(int i=0;i<books.length;i++) {
			if(books[i].getAuthor().getAge()>50 && books[i].getAuthor().getAge()<55) {
				if(books[i+1].getAuthor().getName()!=books[i].getAuthor().getName())
				System.out.println(books[i].getAuthor().getName() + ", " + books[i].getAuthor().getAge());
			}
		}
	}
	
	public int getNumberOfBooks() {
		return numberOfBooks;
	}
	
	public String toString() {
		if (books.toString()==null) {
			return "No Books Added Yet!";
		} else {
			return "Books : " + Arrays.asList(books);
		}
	}
	
	public void sortByIsbnBooks() {
		Arrays.sort(books);
	}
	
	public void sortByYearOfPublish() {
		Book temp;
		
		for(int i=0;i<numberOfBooks;i++) {
			for(int j=0;j<numberOfBooks;j++) {
				if(books[j].getYearOfPublish()>books[i].getYearOfPublish()) {
					temp=books[i];
					books[i]=books[j];
					books[j]=temp;
				}
			}
			}
		
		}
	
	
	public void sortByPrice() {
		Book temp;
		for(int i=0;i<numberOfBooks;i++) {
			for(int j=0;j<numberOfBooks;j++) {
				if(books[j].getPrice()>books[i].getPrice()) {
					temp=books[j];
					books[j]=books[i];
					books[i]=temp;
				}
			}
		}
	}
	
	public void getCrimeSubGBook() {
		for(int i=0;i<books.length;i++) {
			if(books[i].getSubGenre().equals("crime") && books[i].getYearOfPublish()>2010)
				System.out.println(books[i].getName() + ", " + books[i].getAuthor().getName());
		}
	}
	
	public void getHighestDiscountBook() {
		double max=books[0].getPercentageDiscount();
		int k=0;
		for(int i=0;i<books.length;i++) {
			if(books[i].getPercentageDiscount()>max) {
				max=books[i].getPercentageDiscount();
				k=i;
			}
		}
		System.out.println(books[k].getName() + ", " + books[k].getPrice() + ", " + books[k].getPercentageDiscount());
		for(int i=0;i<books.length;i++) {
			if(books[i].getPercentageDiscount()==max && books[i].getName().equals(books[k].getName())!=true) {
				System.out.println(books[i].getName() + ", " + books[i].getPrice() + ", " + books[i].getPercentageDiscount());
			}
		}
	}
	
	public void getCheapestBook() {
		int j=0;
		double min = books[0].getPrice();
		for(int i=0;i<books.length;i++) {
		if(books[i].getPrice()<min) {
			min=books[i].getPrice();
			j=i;
		}
		}
		System.out.println(books[j].getName() + ", " + books[j].getPrice());
	}
	
}
