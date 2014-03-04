package brokerapplication.ejb.ics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ObjectOwner")
public class ObjectOwner {
	
	private String ownerSsnr;
	private String name;
	private String phoneNr;
	private String email;

	@Id
	@Column(name="ownerSsnr")
	public String getOwnerSsnr() {
		return ownerSsnr;
	}

	public void setOwnerSsnr(String ownerSsnr) {
		this.ownerSsnr = ownerSsnr;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="phoneNr")
	public String getPhoneNr() {
		return phoneNr;
	}

	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}

	@Column(name="email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
