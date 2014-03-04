package brokerapplication.ejb.ics;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RealEstateObject {

	private int objNr;
	private String objAddress;
	private String objCity;
	private int objPrice;
	private int objArea;
	private String objRooms;
	private String objUnitType;
	private String objInfo;
	private String brokerSsnr;
	private String ownerSsnr;

	// private byte[] image;

	@Id
	@Column(name = "objNr")
	public int getObjNr() {
		return objNr;
	}

	public void setObjNr(int objNr) {
		this.objNr = objNr;
	}

	@Column(name="objAddress")
	public String getObjAddress() {
		return objAddress;
	}

	public void setObjAddress(String objAddress) {
		this.objAddress = objAddress;
	}

	@Column(name="objCity")
	public String getObjCity() {
		return objCity;
	}

	public void setObjCity(String objCity) {
		this.objCity = objCity;
	}

	@Column(name="objPrice")
	public int getObjPrice() {
		return objPrice;
	}

	public void setObjPrice(int objPrice) {
		this.objPrice = objPrice;
	}

	@Column(name="objArea")
	public int getObjArea() {
		return objArea;
	}

	public void setObjArea(int objArea) {
		this.objArea = objArea;
	}

	@Column(name="objRooms")
	public String getObjRooms() {
		return objRooms;
	}

	public void setObjRooms(String objRooms) {
		this.objRooms = objRooms;
	}

	@Column(name="objUnitType")
	public String getObjUnitType() {
		return objUnitType;
	}

	public void setObjUnitType(String objUnitType) {
		this.objUnitType = objUnitType;
	}

	@Column(name="objInfo")
	public String getObjInfo() {
		return objInfo;
	}

	public void setObjInfo(String objInfo) {
		this.objInfo = objInfo;
	}

	@Column(name="brokerSsnr")
	public String getBrokerSsnr() {
		return brokerSsnr;
	}

	public void setBrokerSsnr(String brokerSsnr) {
		this.brokerSsnr = brokerSsnr;
	}

	@Column(name="ownerSsnr")
	public String getOwnerSsnr() {
		return ownerSsnr;
	}

	public void setOwnerSsnr(String ownerSsnr) {
		this.ownerSsnr = ownerSsnr;
	}
}
