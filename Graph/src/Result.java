import java.util.HashSet;
import java.util.List;

public class Result {

	private int price; 
	
	private int hour; 
	
	private boolean found;
	
	private String tag; 
	
	private Integer id; 
	
	@Override
	public String toString() {
		return "Result [price=" + price + ", hour=" + hour + ", found=" + found + ", tag=" + tag + ", id=" + id
				+ ", flightNumber=" + flightNumber + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public boolean isFound() {
		return found;
	}

	public void setFound(boolean found) {
		this.found = found;
	}

	private String flightNumber;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
}
