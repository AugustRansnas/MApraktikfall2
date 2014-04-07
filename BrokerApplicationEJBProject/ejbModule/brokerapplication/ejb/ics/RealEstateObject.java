	package brokerapplication.ejb.ics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.envers.Audited;

@Entity
@Audited
@NamedQueries({
@NamedQuery(name= "RealEstateObject.findAll",query="SELECT reo FROM RealEstateObject reo"),
@NamedQuery(name= "RealEstateObject.findByObjAddress",query="SELECT reo FROM RealEstateObject reo WHERE reo.objAddress LIKE :objAddress"),
@NamedQuery(name= "RealEstateObject.findByObjCity",query="SELECT reo FROM RealEstateObject reo WHERE reo.objCity LIKE :objCity"),
@NamedQuery(name= "RealEstateObject.findByObjPrice",query="SELECT reo FROM RealEstateObject reo WHERE reo.objPrice LIKE :objPrice"),
@NamedQuery(name= "RealEstateObject.findByObjArea",query="SELECT reo FROM RealEstateObject reo WHERE reo.objArea LIKE :objArea"),
@NamedQuery(name= "RealEstateObject.findByObjRooms",query="SELECT reo FROM RealEstateObject reo WHERE reo.objRooms LIKE :objRooms"),
@NamedQuery(name= "RealEstateObject.findByObjUnitType",query="SELECT reo FROM RealEstateObject reo WHERE reo.objUnitType LIKE :objUnitType"),
@NamedQuery(name= "RealEstateObject.findByObjOwner",query="SELECT reo FROM RealEstateObject reo WHERE reo.objectOwner LIKE :objectOwner"),
@NamedQuery(name= "RealEstateObject.findByObjBroker",query="SELECT reo FROM RealEstateObject reo WHERE reo.realEstateBroker LIKE :realEstateBroker")
})
@Table(name = "RealEstateObject")
public class RealEstateObject {

	private int objNr;
	private String objAddress;
	private String objCity;
	private int objPrice;
	private int objArea;
	private String objRooms;
	private String objUnitType;
	private String objInfo;
	private String objImage;
	private ObjectOwner objectOwner; // Can only have one objectOwner
	private RealEstateBroker realEstateBroker; // Can only have one responsible Broker

	@Id
	@Column(name = "objNr")
	public int getObjNr() {
		return objNr;
	}

	public void setObjNr(int objNr) {
		this.objNr = objNr;
	}

	@Column(name = "objAddress")
	public String getObjAddress() {
		return objAddress;
	}

	public void setObjAddress(String objAddress) {
		this.objAddress = objAddress;
	}

	@Column(name = "objCity")
	public String getObjCity() {
		return objCity;
	}

	public void setObjCity(String objCity) {
		this.objCity = objCity;
	}

	@Column(name = "objPrice")
	public int getObjPrice() {
		return objPrice;
	}

	public void setObjPrice(int objPrice) {
		this.objPrice = objPrice;
	}

	@Column(name = "objArea")
	public int getObjArea() {
		return objArea;
	}

	public void setObjArea(int objArea) {
		this.objArea = objArea;
	}

	@Column(name = "objRooms")
	public String getObjRooms() {
		return objRooms;
	}

	public void setObjRooms(String objRooms) {
		this.objRooms = objRooms;
	}

	@Column(name = "objUnitType")
	public String getObjUnitType() {
		return objUnitType;
	}

	public void setObjUnitType(String objUnitType) {
		this.objUnitType = objUnitType;
	}

	@Column(name = "objInfo")
	public String getObjInfo() {
		return objInfo;
	}

	public void setObjInfo(String objInfo) {
		this.objInfo = objInfo;
	}
	
	

	@ManyToOne
	@JoinColumn(name = "ownerSsnr", referencedColumnName = "ownerSsnr")
	public ObjectOwner getObjectOwner() {
		return objectOwner;
	}

	public void setObjectOwner(ObjectOwner objectOwner) {
		this.objectOwner = objectOwner;
	}
	
	@ManyToOne
	@JoinColumn(name = "brokerSsnr", referencedColumnName = "brokerSsnr")
	public RealEstateBroker getRealEstateBroker(){
		return realEstateBroker;
	}
	
	public void setRealEstateBroker(RealEstateBroker reb){
		this.realEstateBroker = reb;
	}

	@Column(name = "objImage")
	public String getObjImage() {
		return objImage;
	}

	public void setObjImage(String objImage) {
		this.objImage = objImage;
	}

	
	
}
