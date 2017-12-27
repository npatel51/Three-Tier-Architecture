package businesslayer;

public class Person implements Comparable<Person> {
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String age;
	private String email;
	private String phoneNumber;
	private String address1;
	private String address2;
	private String city;
	private String zipCode;
	private String state;
	private String country;

	public Person(String firstName, String lastName, String localDate, String age, String email, String phoneNumber,
			String address1, String address2, String city, String zipCode, String state, String country) {
		this.firstName = firstName;
		this.lastName = (lastName);
		this.dateOfBirth = (localDate);
		this.age = (age);
		this.email = (email);
		this.phoneNumber = (phoneNumber);
		this.address1 = (address1);
		this.address2 = (address2);
		this.city = (city);
		this.zipCode = (zipCode);
		this.state = (state);
		this.country = (country);
	}

	public String getAddress1() {
		return address1;
	}

	public String getAddress2() {
		return address2;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getAge() {
		return age;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Person's info: \n" + "First name: " + this.getFirstName() + "\nLast name: " + this.getLastName()
				+ "\nDate of Birth: " + this.getDateOfBirth() + "\nAge: " + this.getAge() + "\nAddress1: "
				+ this.getAddress1() + "\nAddress 2: " + this.getAddress2() + "\nCity: " + this.getCity() + "\n State: "
				+ this.getState() + "\nZip: " + this.getZipCode() + "\nCountry: " + this.getCountry();

	}

	@Override
	public int compareTo(Person obj) {
		return (firstName + lastName).compareTo(obj.getFirstName() + obj.getLastName());
	}

}
