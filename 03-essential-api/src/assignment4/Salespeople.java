package assignment4;

public class Salespeople {

	private String name;
	private String city;
	private float comm;
	
	public Salespeople(String name, String city, float comm) {
		super();
		this.name = name;
		this.city = city;
		this.comm = comm;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public float getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}

	@Override
	public String toString() {
		return "Salespeople [name=" + name + ", city=" + city + ", comm=" + comm + "]";
	}

	

	
}
