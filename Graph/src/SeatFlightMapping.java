
public class SeatFlightMapping {
	
	
	private String flightId; 
	
	private String seatId; 
	
	private String status;
	

	public SeatFlightMapping(String flightId, String seatId, String status) {
		super();
		this.flightId = flightId;
		this.seatId = seatId;
		this.status = status;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getSeatId() {
		return seatId;
	}

	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	} 
	

}
