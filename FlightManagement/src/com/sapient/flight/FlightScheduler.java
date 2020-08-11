package com.sapient.flight;

public class FlightScheduler {
	
	private String id; 
	
	private String airline; 
	
	private String number; 
	
	private FlightScheduler nextFlight; 
	
	private String baseAirport; 
	
	private String destAirport;
	
	private Integer vertices;
	
	public Integer getVertices() {
		return vertices;
	}

	public void setVertices(int vertices) {
		this.vertices = vertices;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public FlightScheduler getNextFlight() {
		return nextFlight;
	}

	public void setNextFlight(FlightScheduler nextFlight) {
		this.nextFlight = nextFlight;
	}

	public String getBaseAirport() {
		return baseAirport;
	}

	public void setBaseAirport(String baseAirport) {
		this.baseAirport = baseAirport;
	}

	public String getDestAirport() {
		return destAirport;
	}

	public void setDestAirport(String destAirport) {
		this.destAirport = destAirport;
	}



	public FlightScheduler(String id, String airline, String number, FlightScheduler nextFlight, String baseAirport,
			String destAirport,int vertices) {
		super();
		this.id = id;
		this.airline = airline;
		this.number = number;
		this.nextFlight = nextFlight;
		this.baseAirport = baseAirport;
		this.destAirport = destAirport;
		this.vertices = vertices;
	} 

}
