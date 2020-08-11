import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlightMain {

	static List<Airline> airLines = new ArrayList<Airline>();
	static List<Airport> airports = new ArrayList<>();
	static List<Flight> flights = new ArrayList<>();
	static List<FlightSchedule> flightschedules = new ArrayList<>();
	static List<SeatFlightMapping> seatFlightMapping = new ArrayList();

	public static void main(String[] args) {

		loadData();
		System.out.println("data loaded");
		List<FlightSchedule> schedules = flightschedules.stream()
				.filter(x -> x.getAirports().contains("BNG") && x.getBaseAirport().getCode().equals("VAD"))
				.collect(Collectors.toList());
		List<FlightSearchObject> z = schedules.stream().map(x -> searchFlight(new FlightSearchObject(x)))
				.collect(Collectors.toList());
		System.out.println(z);
		BookingDetails details = new BookingDetails();
		details.setIds(z.get(0).getTargetIds());
		bookTickets(details);
	}

	public static Boolean bookTickets(BookingDetails bookingDetails) {
		Map <String,List<String>> AgreegatorMap = new HashMap();
		Set<SeatFlightMapping> seats = seatFlightMapping.stream().filter(x -> x.getStatus().equals("A")).collect(Collectors.toSet());
		for (SeatFlightMapping seat :seats)
		{
			List<String> details = AgreegatorMap.get(seat.getFlightId()) ;
			if ( details!= null)
			{
				details.add(seat.getSeatId()); 
				AgreegatorMap.put(seat.getFlightId(), details);
			}
			else
			{
				details = new ArrayList<String>();
				details.add(seat.getSeatId());
				AgreegatorMap.put(seat.getFlightId(), details);
			}
		}
		
		Collection<List<String>> searforIntersection = AgreegatorMap.values();
		
		List <String> availableSeats = getAvailableSeats(searforIntersection);
		bookSeats(bookingDetails.getIds(),availableSeats);

		
		return false;

	}

	private static void bookSeats(List<Integer> ids, List<String> availableSeats) {

		Set<SeatFlightMapping> z = seatFlightMapping.stream().filter(x -> availableSeats.contains(x.getSeatId()) && ids.contains(x.getFlightId()))
				.collect(Collectors.toSet());
		for (SeatFlightMapping mapping :z)
		{
			mapping.setStatus("B");
		}
	}

	private static List<String> getAvailableSeats(Collection<List<String>> searforIntersection) {
		
		boolean first = true;
	      List<String> newCollection = new ArrayList<>();
		for (Collection<String> collection : searforIntersection) {
	          if (first) {
	              newCollection.addAll(collection);
	              first = false;
	          } else {
	              newCollection.retainAll(collection);
	          }
	      }
	      return newCollection;
	}

	public static FlightSearchObject searchFlight(FlightSearchObject flightSearchObject) {
		Result result = new Result();
		double totalPrice = 0;
		double totalHour = 0;
		if (null != flightSearchObject.getStartingNode()
				&& !flightSearchObject.getStartingNode().getBaseAirport().getCode().equals("BNG")) {
			totalPrice = flightSearchObject.getTotalPrice()
					+ flightSearchObject.getStartingNode().getProperties().getPrice();
			totalHour = flightSearchObject.getTotalHour()
					+ flightSearchObject.getStartingNode().getProperties().getHour();
			result.setFlightNumber(flightSearchObject.getStartingNode().getNumber());
			result.setHour(flightSearchObject.getStartingNode().getProperties().getHour());
			result.setPrice(flightSearchObject.getStartingNode().getProperties().getPrice());
			result.setId(flightSearchObject.getStartingNode().getId());
			flightSearchObject.getResults().add(result);
			flightSearchObject.setTotalHour(totalHour);
			flightSearchObject.setTotalPrice(totalPrice);
			flightSearchObject.getTargetIds().add(result.getId());
			if (null != flightSearchObject.getStartingNode().getNextDestination()) {
				flightSearchObject.setStartingNode(flightSearchObject.getStartingNode().getNextDestination());
				searchFlight(flightSearchObject);
			}
		}
		return flightSearchObject;
	}

	private static void loadData() {

		// add airlines
		Airline indigo = new Airline("Indigo", "A1");
		airLines.add(indigo);
		Airline airIndia = new Airline("AirIndia", "A2");
		airLines.add(airIndia);
		Airline goAir = new Airline("goAir", "A3");
		airLines.add(goAir);
		Airline spiceJet = new Airline("spiceJet", "A4");
		airLines.add(spiceJet);

		// add airports
		Airport mumbai = new Airport("MUMBAI", "MUM");
		airports.add(mumbai);
		Airport banglore = new Airport("banglore", "BNG");
		airports.add(banglore);
		Airport pune = new Airport("pune", "PUN");
		airports.add(pune);
		Airport chennai = new Airport("chennai", "CHN");
		airports.add(chennai);
		Airport delhi = new Airport("delhi", "DEL");
		airports.add(delhi);
		Airport ahmedabad = new Airport("ahmedabad", "AHM");
		airports.add(ahmedabad);
		Airport vadodra = new Airport("vadodra", "VAD");
		airports.add(vadodra);
		Airport kolkatta = new Airport("kolkatta", "Kol");
		airports.add(kolkatta);
		Airport hyderabad = new Airport("hyderabad", "HYD");
		airports.add(hyderabad);
		Airport dharamshala = new Airport("Dharamsala", "DHA");
		airports.add(dharamshala);
		Airport surat = new Airport("SURAT", "SUR");
		airports.add(surat);

		Flight filght1 = new Flight("flight1", "1", indigo);
		Flight filght2 = new Flight("flight2", "2", airIndia);
		Flight filght3 = new Flight("flight3", "3", goAir);
		Flight filght4 = new Flight("flight4", "4", spiceJet);
		Flight filght5 = new Flight("flight5", "5", indigo);
		Flight filght6 = new Flight("flight6", "6", airIndia);
		Flight filght7 = new Flight("flight7", "7", spiceJet);

		flights.add(filght1);
		flights.add(filght2);
		flights.add(filght3);
		flights.add(filght4);
		flights.add(filght5);
		flights.add(filght6);
		flights.add(filght7);

		List<String> airport = new ArrayList<>();
		airport.add("MUM");
		airport.add("VAD");
		airport.add("CHN");
		airport.add("BNG");
		FlightSchedule vadodaraMumbai = new FlightSchedule(1, "vadodara-mumbai", "1", spiceJet, vadodra, 123, 123);
		FlightSchedule mumbaiChennai = new FlightSchedule(2, "mumbai-chennai", "1", spiceJet, vadodra, 123, 123);
		FlightSchedule ChennaiBanglore = new FlightSchedule(3, "chennai-banglore", "1", spiceJet, vadodra, 123, 123);
		vadodaraMumbai.setNextDestination(mumbaiChennai);
		vadodaraMumbai.setBaseAirport(new Airport("Vadodara", "VAD"));
		vadodaraMumbai.setAirports(airport);
		vadodaraMumbai.setProperties(new Properties(1, 1000));
		mumbaiChennai.setProperties(new Properties(1, 2000));
		mumbaiChennai.setBaseAirport(new Airport("Mumbai", "MUM"));
		mumbaiChennai.setAirports(airport);
		mumbaiChennai.setNextDestination(ChennaiBanglore);
		ChennaiBanglore.setProperties(new Properties(2, 500));
		ChennaiBanglore.setAirports(airport);
		ChennaiBanglore.setBaseAirport(new Airport("Chennai", "CHN"));
		flightschedules.add(vadodaraMumbai);
		flightschedules.add(mumbaiChennai);
		flightschedules.add(ChennaiBanglore);
		List<String> airport1 = new ArrayList<>();
		airport1.add("MUM");
		airport1.add("VAD");
		airport1.add("BNG");
		airport1.add("CHN");

		FlightSchedule vadodaraMumbai1 = new FlightSchedule(4, "vadodara-mumbai", "2", spiceJet, vadodra, 123, 123);
		FlightSchedule mumbaiBanglore = new FlightSchedule(5, "mumbai-banglore", "2", spiceJet, vadodra, 123, 123);
		vadodaraMumbai1.setNextDestination(mumbaiBanglore);
		vadodaraMumbai1.setBaseAirport(new Airport("Vadodara", "VAD"));
		vadodaraMumbai1.setAirports(airport1);
		vadodaraMumbai1.setProperties(new Properties(1, 5000));
		mumbaiBanglore.setProperties(new Properties(1, 6000));
		mumbaiBanglore.setBaseAirport(new Airport("Mumbai", "MUM"));
		mumbaiBanglore.setAirports(airport);
		flightschedules.add(vadodaraMumbai1);
		flightschedules.add(mumbaiBanglore);

		SeatFlightMapping vadFlightMapping = new SeatFlightMapping("1", "1", "A");
		SeatFlightMapping mumFlightMapping = new SeatFlightMapping("2", "1", "A");
		SeatFlightMapping bngFlightMapping = new SeatFlightMapping("3", "1", "A");

		SeatFlightMapping vadFlightMapping1 = new SeatFlightMapping("1", "2", "A");
		SeatFlightMapping mumFlightMapping1 = new SeatFlightMapping("2", "2", "A");
		SeatFlightMapping bngFlightMapping1 = new SeatFlightMapping("3", "2", "A");

		SeatFlightMapping vadFlightMapping2 = new SeatFlightMapping("1", "3", "A");
		SeatFlightMapping mumFlightMapping2 = new SeatFlightMapping("2", "3", "A");
		SeatFlightMapping bngFlightMapping2 = new SeatFlightMapping("3", "3", "A");

		seatFlightMapping.add(vadFlightMapping);
		seatFlightMapping.add(mumFlightMapping);
		seatFlightMapping.add(bngFlightMapping);

		seatFlightMapping.add(vadFlightMapping1);
		seatFlightMapping.add(mumFlightMapping1);
		seatFlightMapping.add(bngFlightMapping1);

		seatFlightMapping.add(vadFlightMapping2);
		seatFlightMapping.add(mumFlightMapping2);
		seatFlightMapping.add(bngFlightMapping2);

	}

}
