package brokerapplication.ejb.ics;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Showing implements Serializable {
	
	private int objNr;
	private String buyerSsnr;
	private String showingDate;

	public int getObjNr() {
		return objNr;
	}

	public void setObjNr(int objNr) {
		this.objNr = objNr;
	}

	public String getBuyerSsnr() {
		return buyerSsnr;
	}

	public void setBuyerSsnr(String buyerSsnr) {
		this.buyerSsnr = buyerSsnr;
	}

	public String getShowingDate() {
		return showingDate;
	}

	public void setShowingDate(String showingDate) {
		this.showingDate = showingDate;
	}
}
