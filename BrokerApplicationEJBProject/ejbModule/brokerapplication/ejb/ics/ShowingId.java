package brokerapplication.ejb.ics;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ShowingId implements Serializable {

	@Column(name = "objNr")
	private int objNr;
	@Column(name = "buyerSsnr")
	private String buyerSsnr;

	public ShowingId() {
	}

	@Override
	public boolean equals(Object other) {
		if (other instanceof ShowingId) {
			ShowingId oId = (ShowingId) other;
			String objNrString = Integer.toString(oId.objNr);
			return (objNrString.equals(this.objNr) && oId.buyerSsnr
					.equals(this.buyerSsnr));
		}
		return false;
	}

	public int hashCode() {
		return super.hashCode();
	}

}
