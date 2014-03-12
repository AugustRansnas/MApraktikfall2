package brokerapplication.ejb.ics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
@NamedQuery(name= "RealEstateObject.findAll",query="SELECT reo FROM RealEstateObject reo"),
@NamedQuery(name= "RealEstateObject.findByAddress",query="SELECT reo FROM RealEstateObject reo WHERE reo.objAddress LIKE :objAddress"),
@NamedQuery(name= "RealEstateObject.findByCity",query="SELECT reo FROM RealEstateObject reo WHERE reo.objCity LIKE :objCity"),
@NamedQuery(name= "RealEstateObject.findByPrice",query="SELECT reo FROM RealEstateObject reo WHERE reo.objPrice LIKE :objPrice"),
@NamedQuery(name= "RealEstateObject.findByObjArea",query="SELECT reo FROM RealEstateObject reo WHERE reo.objArea LIKE :objArea"),
@NamedQuery(name= "RealEstateObject.findByObjRooms",query="SELECT reo FROM RealEstateObject reo WHERE reo.objRooms LIKE :objRooms"),
@NamedQuery(name= "RealEstateObject.findByObjUnitType",query="SELECT reo FROM RealEstateObject reo WHERE reo.objUnitType LIKE :objUnitType")
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
	private ObjectOwner objectOwner; // Can only have one objectOwner
	private RealEstateBroker realEstateBroker; // Can only have one responsible Broker

	// private byte[] image;

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
	
	/*	ska ej vara med 
	@Column(name = "brokerSsnr")
	public String getBrokerSsnr() {
		return brokerSsnr;
	}

	public void setBrokerSsnr(String brokerSsnr) {
		this.brokerSsnr = brokerSsnr;
	} */

	/* ska ej vara med
	@Column(name = "ownerSsnr")
	public String getOwnerSsnr() {
		return ownerSsnr;
	}

	public void setOwnerSsnr(String ownerSsnr) {
		this.ownerSsnr = ownerSsnr;
	}*/

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
	
}
