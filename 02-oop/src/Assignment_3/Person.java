package Assignment_3;

public class Person {

	private String name;
	private String nrcno;
	private String address;
	private String phone;

//	Constructors
	public Person(String name, String ncrno, String address, String phone) {
		super();
		this.name = name;
		this.nrcno = ncrno;
		this.address = address;
		this.phone = phone;
	}

//	Getters and Setters	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNrcno() {
		return nrcno;
	}

	public void setNrcno(String ncrno) {
		this.nrcno = ncrno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

//	Methods
	public void showInfo() {
		System.out.println("Name: " + name);
		System.out.println("Ncrno: " + nrcno);
		System.out.println("Address: " + address);
		System.out.println("Phone: " + phone);
	}

	public void showIdentificationInfo() {

		String[] divisions = { "Kachin", "Kayah", "Kayin", "Chin", "Sagaing", "Tanintharyi", "Bago", "Magway",
				"Mandalay", "Mon", "Rakhine", "Yangon", "Shan", "Ayeyarwady" };
		int divisionNo = Integer.parseInt(getNrcno().substring(0, 1));
		String city = getNrcno().substring(getNrcno().indexOf("/") + 1, 8);
		String number = getNrcno().substring(getNrcno().length() - 6);

		System.out.println("Division/State: " + divisions[divisionNo - 1]);
		System.out.println("City: " + city);
		System.out.println("Number: " + number);
	}
}
