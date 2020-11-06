package celluar.beans;

import javax.persistence.Embeddable;

@Embeddable
public class MailAddress {
	private String street;
	private String city;
	private String state;
	private int zipCode;
	
	public MailAddress() {
		super();
	}
	
	public MailAddress(String street, String city, String state, int zipCode) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public int getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
	@Override
	public String toString() {
	return "Address [Street: " + street + ", City: " + city + ", State: " + state + " ,Zip Code: " + zipCode + "]";
	}
}
