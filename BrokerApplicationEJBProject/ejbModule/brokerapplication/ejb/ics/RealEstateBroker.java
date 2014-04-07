package brokerapplication.ejb.ics;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.envers.Audited;

@Entity
@Audited
@NamedQueries({
		@NamedQuery(name = "RealEstateBroker.findAll", query = "SELECT reb FROM RealEstateBroker reb"),
		@NamedQuery(name = "RealEstateBroker.findByName", query = "SELECT reb FROM RealEstateBroker reb WHERE reb.name LIKE:name"),
		@NamedQuery(name = "RealEstateBroker.findByAddress", query = "SELECT reb FROM RealEstateBroker reb WHERE reb.brokerAddress LIKE:address"),
		@NamedQuery(name = "RealEstateBroker.findByCity", query = "SELECT reb FROM RealEstateBroker reb WHERE reb.city LIKE:city"),
		@NamedQuery(name = "RealEstateBroker.findByPhoneNr", query = "SELECT reb FROM RealEstateBroker reb WHERE reb.phoneNr LIKE:phoneNr"),
		@NamedQuery(name = "RealEstateBroker.findByEmail", query = "SELECT reb FROM RealEstateBroker reb WHERE reb.email LIKE:email")})
@Table(name = "RealEstateBroker")
public class RealEstateBroker {

	private String brokerSsnr;
	private String name;
	private String brokerAddress;
	private String city;
	private String phoneNr;
	private String email;
	private String pw;

	private Set<RealEstateObject> realEstateObjects; // RealEstateBroker can be
														// responsible for many
														// Objects

	@Id
	@Column(name = "brokerSsnr")
	public String getBrokerSsnr() {
		return brokerSsnr;
	}

	public void setBrokerSsnr(String brokerSsnr) {
		this.brokerSsnr = brokerSsnr;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "brokerAddress")
	public String getBrokerAddress() {
		return brokerAddress;
	}

	public void setBrokerAddress(String brokerAddress) {
		this.brokerAddress = brokerAddress;
	}

	@Column(name = "city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	@Column(name = "pw")
	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@OneToMany(mappedBy = "realEstateBroker", fetch = FetchType.EAGER)
	public Set<RealEstateObject> getRealEstateObjects() {
		return realEstateObjects;
	}

	public void setRealEstateObjects(Set<RealEstateObject> realEstateObjects) {
		this.realEstateObjects = realEstateObjects;
	}

}
