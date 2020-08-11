import java.util.List;

public class Flight {
	
	private String name; 
	
	private String number;
	
	private Airline airLine; 

	private List<Seat> seats; 
	
	public Flight (String name,String number,Airline airLine)
	{
		this.name = name; 
		this.number = number; 
		this.airLine = airLine;
	}
	public List<Seat> getSeats() {
		return seats;
	}
	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
	public Airline getAirLine() {
		return airLine;
	}

	public void setAirLine(Airline airLine) {
		this.airLine = airLine;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	

}
