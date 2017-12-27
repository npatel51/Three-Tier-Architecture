package application;

import javafx.beans.property.SimpleStringProperty;

public class Person {
	private SimpleStringProperty firstName;
	private SimpleStringProperty lastName;
	private SimpleStringProperty dateOfBirth;
	private SimpleStringProperty age;
	private SimpleStringProperty email;
	private SimpleStringProperty phoneNumber;
	private SimpleStringProperty address1;
	private SimpleStringProperty address2;
	private SimpleStringProperty city;
	private SimpleStringProperty zipCode;
	private SimpleStringProperty state;
	private SimpleStringProperty country;

	public Person(String firstName, String lastName, String localDate, String age, String email, String phoneNumber,
			String address1, String address2, String city, String zipCode, String state, String country) {
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		this.dateOfBirth = new SimpleStringProperty(localDate);
		this.age = new SimpleStringProperty(age);
		this.email = new SimpleStringProperty(email);
		this.phoneNumber = new SimpleStringProperty(phoneNumber);
		this.address1 = new SimpleStringProperty(address1);
		this.address2 = new SimpleStringProperty(address2);
		this.city = new SimpleStringProperty(city);
		this.zipCode = new SimpleStringProperty(zipCode);
		this.state = new SimpleStringProperty(state);
		this.country = new SimpleStringProperty(country);
	}

	public String getAddress1() {
		return address1.get();
	}

	public String getAddress2() {
		return address2.get();
	}

	public String getCity() {
		return city.get();
	}

	public String getState() {
		return state.get();
	}

	public String getFirstName() {
		return firstName.get();
	}

	public String getLastName() {
		return lastName.get();
	}

	public String getEmail() {
		return email.get();
	}

	public String getAge() {
		return age.get();
	}

	public String getDateOfBirth() {
		return dateOfBirth.get();
	}

	public String getPhoneNumber() {
		return phoneNumber.get();
	}

	public String getZipCode() {
		return zipCode.get();
	}

	public String getCountry() {
		return country.get();
	}

	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}

	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth.set(dateOfBirth);
	}

	public void setAge(String age) {
		this.age.set(age);
		;
	}

	public void setEmail(String email) {
		this.email.set(email);
		;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber.set(phoneNumber);
		;
	}

	public void setAddress1(String address1) {
		this.address1.set(address1);
		;
	}

	public void setAddress2(String address2) {
		this.address2.set(address2);
		;
	}

	public void setCity(String city) {
		this.city.set(city);
	}

	public void setZipCode(String zipCode) {
		this.zipCode.set(zipCode);
	}

	public void setState(String state) {
		this.state.set(state);
	}

	public void setCountry(String country) {
		this.country.set(country);
		;
	}

	/*
	 * @Override public String toString() { return "Person's info: \n" +
	 * "First name: " + this.getFirstName() + "\nLast name: " + this.getLastName() +
	 * "\nDate of Birth: " + this.getDateOfBirth() + "\nAge: " + this.getAge() +
	 * "\nAddress1: " + this.getAddress1() + "\nAddress 2: " + this.getAddress2() +
	 * "\nCity: " + this.getCity() + "\n State: " + this.getState() + "\nZip: " +
	 * this.getZipCode() + "\nCountry: " + this.getCountry();
	 * 
	 * }
	 */

}
