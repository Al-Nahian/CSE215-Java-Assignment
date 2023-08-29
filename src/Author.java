
public class Author {
	private String name;
	private String emailid;
	private String gender;
	private int age;
	
	public Author() {
		this.name="No Name Given!";
		this.emailid="No Email given!";
		this.gender="No Gender given!";
		this.age=0;
	}
	
	public Author(String name,String email,int age,String gen) {
		this.name=name;
		this.emailid=email;
		this.gender=gen;
		this.age=age;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmailId() {
		return emailid;
	}
	
	public String getGender() {
		return gender;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setEmailId(String email) {
		this.emailid=email;
	}
	
	public void setGender(String gen) {
		this.gender=gen;
	}
	
	public void setAge(int age) {
		this.age=age;
	}
	
	public String toString() {
		return "Name: " + name + ".\nEmail ID: " + emailid + ".\nGender: " + gender + ".\nAge: " + age + ".";
	}
}
