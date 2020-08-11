import java.util.List;

public class FlightSchedule extends Flight {
	
	private Integer id;

	private Airport baseAirport;

	private long arrivalTime;

	private long departureTime;

	private FlightSchedule nextDestination;
	
	private Properties properties;

	List<String> airports;

	public Airport getBaseAirport() {
		return baseAirport;
	}

	public void setBaseAirport(Airport baseAirport) {
		this.baseAirport = baseAirport;
	}

	public long getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(long arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public long getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(long departureTime) {
		this.departureTime = departureTime;
	}

	public FlightSchedule getNextDestination() {
		return nextDestination;
	}

	public void setNextDestination(FlightSchedule nextDestination) {
		this.nextDestination = nextDestination;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public List<String> getAirports() {
		return airports;
	}

	public void setAirports(List<String> airports) {
		this.airports = airports;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public FlightSchedule(Integer id,String name, String number, Airline airLine, Airport airport, long arrivalTime,
			long departureTime) {
		super(name, number, airLine);
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.id = id;
	}

	
}
