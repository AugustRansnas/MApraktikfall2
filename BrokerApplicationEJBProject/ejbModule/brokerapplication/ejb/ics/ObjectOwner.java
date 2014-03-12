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

@Entity
@NamedQueries({ 
	 @NamedQuery(name="ObjectOwner.findAll", 
	 query="SELECT e FROM ObjectOwner e"), 
	 @NamedQuery(name="ObjectOwner.findByName", 
	 query="SELECT e FROM ObjectOwner e WHERE e.name LIKE :name"), 
	 @NamedQuery(name="ObjectOwner.findByPhoneNr", 
	 query="SELECT e FROM ObjectOwner e WHERE e.phoneNr LIKE :phoneNr"), 
	 @NamedQuery(name="ObjectOwner.findByEmail", 
	 query="SELECT e FROM ObjectOwner e WHERE e.email LIKE :email"), 

	}) 

@Table(name = "ObjectOwner")
public class ObjectOwner {

	private String ownerSsnr;
	private String name;
	private String phoneNr;
	private String email;
	private Set<RealEstateObject> realEstateObjects; // Object owner can have
														// many Real Estate
														// Objects

	@Id
	@Column(name = "ownerSsnr")
	public String getOwnerSsnr() {
		return ownerSsnr;
	}

	public void setOwnerSsnr(String ownerSsnr) {
		this.ownerSsnr = ownerSsnr;
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

	@OneToMany(mappedBy = "objectOwner", fetch = FetchType.EAGER)
	public Set<RealEstateObject> getRealEstateObjects() {
		return realEstateObjects;
	}

	public void setRealEstateObjects(Set<RealEstateObject> realEstateObjects) {
		this.realEstateObjects = realEstateObjects;
	}
}
