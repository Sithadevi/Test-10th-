
public class Train {
	private int traiNo;
	private String trainName;
	private String source;
	private String destination;
	private double ticketPrice;
	public Train(int traiNo, String trainName, String source, String destination, double ticketPrice) {
		super();
		this.traiNo = traiNo;
		this.trainName = trainName;
		this.source = source;
		this.destination = destination;
		this.ticketPrice = ticketPrice;
	}

	public int getTraiNo() {
		return traiNo;
	}
	public void setTraiNo(int traiNo) {
		this.traiNo = traiNo;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	
	
}
