import java.util.List;

public class BookingDetails {

	private List<Integer> ids; 
	
	private String category; 
	
    private Integer count;
    
    private List<String> availableSeats ; 

	public List<String> getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(List<String> availableSeats) {
		this.availableSeats = availableSeats;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}	
}
