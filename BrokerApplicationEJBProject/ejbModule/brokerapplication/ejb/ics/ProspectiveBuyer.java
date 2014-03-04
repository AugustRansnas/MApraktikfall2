package brokerapplication.ejb.ics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProspectiveBuyer {

	private String buyerSsnr;
	private String name;
	private String phoneNr;
	private String email;

	@Id
	@Column(name = "buyerSsnr")
	public String getBuyerSsnr() {
		return buyerSsnr;
	}

	public void setBuyerSsnr(String buyerSsnr) {
		this.buyerSsnr = buyerSsnr;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "phoneNr")
	public String getPhoneNr() {
		return phoneNr;
	}

	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
