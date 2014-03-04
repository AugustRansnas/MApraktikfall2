package examples.ejb.ics; 
 
 import java.io.Serializable; 
 
 import javax.persistence.Column; 
 import javax.persistence.Entity; 
 import javax.persistence.Id; 
 import javax.persistence.Table; 
 
 @Entity 
 @Table(name="Movie") 
 public class Movie implements Serializable {
	 
	 private long idMovie; 
	 private String title; 
	 private double price;
	 
	 @Id 
	 @Column(name="idMovie") 
	public long getIdMovie() {
		return idMovie;
	}
	public void setIdMovie(long idMovie) {
		this.idMovie = idMovie;
	}
	
	@Column(name="title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name="price")
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
 }