package brokerapplication.ejb.ics;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Showing implements Serializable {
	
	@EmbeddedId
	private ShowingId showingId;
	private String showingDate;

	public String getShowingDate() {
		return showingDate;
	}

	public void setShowingDate(String showingDate) {
		this.showingDate = showingDate;
	}

	public ShowingId getShowingId() {
		return showingId;
	}

	public void setShowingId(ShowingId showingId) {
		this.showingId = showingId;
	}
}
