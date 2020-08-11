import java.util.ArrayList;
import java.util.List;

public class FlightSearchObject {

	@Override
	public String toString() {
		return "FlightSearchObject [startingNode=" + startingNode + ", totalPrice=" + totalPrice + ", totalHour="
				+ totalHour + ", results=" + results + ", targetIds=" + targetIds + "]";
	}

	FlightSchedule startingNode; 
	
	Double totalPrice;
	
	Double totalHour; 
	
	List<Result> results = new ArrayList<>();
	
	List<Integer> targetIds = new ArrayList<Integer>();
	

	public FlightSearchObject(FlightSchedule startingNode) {
		super();
		this.startingNode = startingNode;
		this.totalPrice = 0.0;
		this.totalHour = 0.0;
		this.results = new ArrayList<>();
		this.targetIds = new ArrayList<>();
	}


	public FlightSearchObject(FlightSchedule startingNode, Double totalPrice, Double totalHour, List<Result> results,
			List<Integer> targetIds) {
		super();
		this.startingNode = startingNode;
		this.totalPrice = totalPrice;
		this.totalHour = totalHour;
		this.results = results;
		this.targetIds = targetIds;
	}


	public List<Integer> getTargetIds() {
		return targetIds;
	}

	public void setTargetIds(List<Integer> targetIds) {
		this.targetIds = targetIds;
	}



	public FlightSchedule getStartingNode() {
		return startingNode;
	}

	public void setStartingNode(FlightSchedule startingNode) {
		this.startingNode = startingNode;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Double getTotalHour() {
		return totalHour;
	}

	public void setTotalHour(Double totalHour) {
		this.totalHour = totalHour;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	} 
	
	
}
