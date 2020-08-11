package com.sapient.flight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightManagement {
	
	public static int count = 0; 
	public static List<Airport> airports = new ArrayList<>();

	public static List<FlightScheduler> flightSchedulers = new ArrayList<FlightScheduler>();

	public static Map<String, List<FlightScheduler>> airportFlightMap = new HashMap<>();

	public static List<Integer> visited = new ArrayList<Integer>();

	public static void main(String[] args) {

		loadData();
		System.out.println("data load completed");

		System.out.println(getRoutes("VAD", null, "BNG"));

	}

	private static Object getRoutes(String from, String prev, String dest) {
		if (from == null) {
			return null;
		} else {
			List<FlightScheduler> destinations = airportFlightMap.get(from);

			for (FlightScheduler scheduler : destinations) {
				if (!visited.contains(scheduler.getVertices())) {
					visited.add(scheduler.getVertices());

					System.out.println("Journey is " + scheduler.getBaseAirport() + "-> " + scheduler.getDestAirport());
					if (scheduler.getDestAirport().equals("BNG"))
					{
						count = count +1;
					}
					getRoutes(scheduler.getDestAirport(), scheduler.getBaseAirport(), dest);
				}
			}

		}
		return count;

	}

	private static void loadData() {

		// Add airports
		Airport airport1 = new Airport("DEL");
		Airport airport2 = new Airport("MUM");
		Airport airport3 = new Airport("VAD");
		Airport airport4 = new Airport("KOL");
		Airport airport5 = new Airport("HYD");
		Airport airport6 = new Airport("CHN");
		Airport airport7 = new Airport("BNG");
		airports.add(airport1);
		airports.add(airport2);
		airports.add(airport3);
		airports.add(airport4);
		airports.add(airport5);
		airports.add(airport6);
		airports.add(airport7);

		// Create flight schedule

		// vadodare flights
		FlightScheduler vadodraMumbai = new FlightScheduler("1", "Indigo", "1", null, "VAD", "MUM", 1);
		FlightScheduler vadodraDelhi = new FlightScheduler("2", "Indigo", "2", null, "VAD", "DEL", 2);

		List<FlightScheduler> VadodaraSchedulers = new ArrayList<>();
		VadodaraSchedulers.add(vadodraMumbai);
		VadodaraSchedulers.add(vadodraDelhi);

		flightSchedulers.addAll(VadodaraSchedulers);
		airportFlightMap.put("VAD", VadodaraSchedulers);

		// Delhi flights
		FlightScheduler delhiMumbai = new FlightScheduler("3", "Indigo", "3", null, "DEL", "MUM", 3);
		FlightScheduler delhiKolkatta = new FlightScheduler("4", "Indigo", "4", null, "DEL", "KOL", 4);
		FlightScheduler delhiChennai = new FlightScheduler("5", "Indigo", "5", null, "DEL", "CHN", 5);
		FlightScheduler delhiVadodara = new FlightScheduler("6", "Indigo", "6", null, "DEL", "VAD", 6);
		FlightScheduler delhiHyderabad = new FlightScheduler("7", "Indigo", "7", null, "DEL", "HYD", 7);
		FlightScheduler delhiBanglore = new FlightScheduler("8", "Indigo", "8", null, "DEL", "BNG", 8);

		List<FlightScheduler> DelhiSchedulers = new ArrayList<>();
		DelhiSchedulers.add(delhiMumbai);
		DelhiSchedulers.add(delhiKolkatta);
		DelhiSchedulers.add(delhiChennai);
		DelhiSchedulers.add(delhiVadodara);
		DelhiSchedulers.add(delhiHyderabad);
	    DelhiSchedulers.add(delhiBanglore);
		flightSchedulers.addAll(DelhiSchedulers);
		airportFlightMap.put("DEL", DelhiSchedulers);

		// Mumbai flights
		FlightScheduler MumbaiDelhi = new FlightScheduler("9", "Indigo", "9", null, "MUM", "DEL", 9);
		FlightScheduler MumbaiKolkatta = new FlightScheduler("9", "Indigo", "9", null, "MUM", "KOL", 10);
		FlightScheduler MumbaiChennai = new FlightScheduler("10", "Indigo", "10", null, "MUM", "CHN", 11);
		FlightScheduler MumbaiVadodara = new FlightScheduler("11", "Indigo", "11", null, "MUM", "VAD", 12);
		FlightScheduler MumbaiHyderabad = new FlightScheduler("12", "Indigo", "12", null, "MUM", "HYD", 13);
		FlightScheduler MumbaiBanglore = new FlightScheduler("13", "Indigo", "13", null, "MUM", "BNG", 14);

		List<FlightScheduler> MumbaiSchedulers = new ArrayList<>();
		MumbaiSchedulers.add(MumbaiDelhi);
		MumbaiSchedulers.add(MumbaiKolkatta);
		MumbaiSchedulers.add(MumbaiChennai);
		MumbaiSchedulers.add(MumbaiVadodara);
		MumbaiSchedulers.add(MumbaiHyderabad);
		MumbaiSchedulers.add(MumbaiBanglore);
		flightSchedulers.addAll(MumbaiSchedulers);
		airportFlightMap.put("MUM", MumbaiSchedulers);

		// chennai flights
		FlightScheduler ChennaiDelhi = new FlightScheduler("14", "Indigo", "14", null, "CHN", "DEL", 15);
		FlightScheduler ChennaiKolkatta = new FlightScheduler("15", "Indigo", "15", null, "CHN", "KOL", 16);
		FlightScheduler ChennaiMumbai = new FlightScheduler("16", "Indigo", "16", null, "CHN", "MUM", 17);
		FlightScheduler ChennaiVadodara = new FlightScheduler("17", "Indigo", "17", null, "CHN", "VAD", 18);
		FlightScheduler ChennaiHyderabad = new FlightScheduler("18", "Indigo", "18", null, "CHN", "HYD", 19);
		FlightScheduler ChennaiBanglore = new FlightScheduler("19", "Indigo", "19", null, "CHN", "BNG", 20);

		List<FlightScheduler> ChennaiSchedulers = new ArrayList<>();
		ChennaiSchedulers.add(ChennaiDelhi);
		ChennaiSchedulers.add(ChennaiKolkatta);
		ChennaiSchedulers.add(ChennaiMumbai);
		ChennaiSchedulers.add(ChennaiVadodara);
		ChennaiSchedulers.add(ChennaiHyderabad);
		//ChennaiSchedulers.add(ChennaiBanglore);
		flightSchedulers.addAll(ChennaiSchedulers);
		airportFlightMap.put("CHN", ChennaiSchedulers);

		// Banglore flights

		FlightScheduler BangloreDelhi = new FlightScheduler("20", "Indigo", "20", null, "BNG", "DEL", 21);
		FlightScheduler BangloreKolkatta = new FlightScheduler("21", "Indigo", "21", null, "BNG", "KOL", 22);
		FlightScheduler BangloreMumbai = new FlightScheduler("22", "Indigo", "22", null, "BNG", "MUM", 23);
		FlightScheduler BangloreVadodara = new FlightScheduler("23", "Indigo", "23", null, "BNG", "VAD", 24);
		FlightScheduler BangloreHyderabad = new FlightScheduler("24", "Indigo", "24", null, "BNG", "HYD", 25);

		List<FlightScheduler> BangloreSchedulers = new ArrayList<>();
		BangloreSchedulers.add(BangloreDelhi);
		BangloreSchedulers.add(BangloreKolkatta);
		BangloreSchedulers.add(BangloreMumbai);
		BangloreSchedulers.add(BangloreVadodara);
		BangloreSchedulers.add(BangloreHyderabad);
		flightSchedulers.addAll(BangloreSchedulers);
		airportFlightMap.put("BNG", BangloreSchedulers);

		// Hyderabad flights
		FlightScheduler HyderabadDelhi = new FlightScheduler("25", "Indigo", "25", null, "HYD", "DEL", 26);
		FlightScheduler HyderabadKolkatta = new FlightScheduler("26", "Indigo", "26", null, "HYD", "KOL", 27);
		FlightScheduler HyderabadMumbai = new FlightScheduler("27", "Indigo", "27", null, "HYD", "MUM", 28);
		FlightScheduler HyderabadVadodara = new FlightScheduler("28", "Indigo", "28", null, "HYD", "VAD", 29);
		FlightScheduler HyderabadBanglore = new FlightScheduler("29", "Indigo", "29", null, "HYD", "BNG", 30);

		List<FlightScheduler> HyderabadSchedulers = new ArrayList<>();
		HyderabadSchedulers.add(HyderabadDelhi);
		HyderabadSchedulers.add(HyderabadKolkatta);
		HyderabadSchedulers.add(HyderabadMumbai);
		HyderabadSchedulers.add(HyderabadVadodara);
		HyderabadSchedulers.add(HyderabadBanglore);
		flightSchedulers.addAll(HyderabadSchedulers);
		airportFlightMap.put("HYD", HyderabadSchedulers);

		// add kolkatta flights
		FlightScheduler KolkattaDelhi = new FlightScheduler("31", "Indigo", "31", null, "KOL", "DEL", 31);
		FlightScheduler KolkattaMumbai = new FlightScheduler("1", "Indigo", "1", null, "KOL", "MUM", 32);
		FlightScheduler KolkattaVadodara = new FlightScheduler("1", "Indigo", "1", null, "KOL", "VAD", 33);
		FlightScheduler KolkattaChennai = new FlightScheduler("1", "Indigo", "1", null, "KOL", "CHN", 34);
		FlightScheduler KolkattaHyderabad = new FlightScheduler("1", "Indigo", "1", null, "KOL", "HYD", 35);

		List<FlightScheduler> kolkattaSchedulers = new ArrayList<>();
		kolkattaSchedulers.add(KolkattaDelhi);
		kolkattaSchedulers.add(KolkattaMumbai);
		kolkattaSchedulers.add(KolkattaVadodara);
		kolkattaSchedulers.add(KolkattaChennai);
		kolkattaSchedulers.add(KolkattaHyderabad);
		flightSchedulers.addAll(kolkattaSchedulers);
		airportFlightMap.put("KOL", kolkattaSchedulers);

	}

}
