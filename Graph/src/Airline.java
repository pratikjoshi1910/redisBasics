import java.util.List;

public class Airline {

	private String name;

	private String code;

	private List<Flight> flights;

	private List<Airport> airports;
	
	public Airline()
	{
		
	}

	public Airline(String name, String code) {
		this.name = name;
		this.code = code;
	}

	public Airline(String name, String code, List<Airport> airports, List<Flight> flights) {
		this.name = name;
		this.code = code;
		this.airports = airports;
		this.flights = flights;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public List<Airport> getAirports() {
		return airports;
	}

	public void setAirports(List<Airport> airports) {
		this.airports = airports;
	}

}
