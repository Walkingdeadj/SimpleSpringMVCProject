package celluar.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;


@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
public class CustomerContact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String phone;
	private int shopDate;
	@Autowired
	private MailAddress address;
	
	
	public CustomerContact(String name) {
		super();
		this.name = name;
	}
	
	public CustomerContact(String name, String phone, int shopDate) {
		super();
		this.name = name;
		this.phone = phone;
		this.shopDate = shopDate;
	}
	
	public CustomerContact(int id, String name, String phone, int shopDate) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.shopDate = shopDate;
	}
	
	/**
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public int getShopDate() {
		return shopDate;
	}
	
	public void setShopDate(int shopDate) {
		this.shopDate = shopDate;
	}
	
	public MailAddress getAddress() {
		return address;
	}

	public void setAddress(MailAddress address) {
		this.address = address;
	}
	**/
	
	//create getters and setters too
	@Override
	public String toString() {
		return "Contact [Customer Id: " + id + ", Name: " + name + ",Phone Choice: " + phone + ", Shop Date: " + shopDate + ", Mailing Address: " + address + "]";
	}
}
