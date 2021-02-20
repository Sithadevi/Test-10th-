import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;



public class Ticket {
	private int counter;
	private String pnr;
	private LocalDate travelDate;
	private Train train;
	private TreeMap<Passenger,Double>passengers=new TreeMap();
	

	public Ticket(LocalDate travelDate, Train train) {
		super();
		this.travelDate = travelDate;
		this.train = train;
	}

	


	public Ticket(int counter, String pnr, LocalDate travelDate, Train train, TreeMap<Passenger, Double> passengers) {
		super();
		this.counter = counter;
		this.pnr = pnr;
		this.travelDate = travelDate;
		this.train = train;
		this.passengers = passengers;
	}




	public int getCounter() {
		return counter;
	}



	public void setCounter(int counter) {
		this.counter = counter;
	}



	public String getPnr() {
		return pnr;
	}



	public void setPnr(String pnr) {
		this.pnr = pnr;
	}



	public LocalDate getTravelDate() {
		return travelDate;
	}



	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}



	public Train getTrain() {
		return train;
	}



	public void setTrain(Train train) {
		this.train = train;
	}



	public TreeMap<Passenger,Double> getPassengers() {
		return passengers;
	}



	public void setPassengers(TreeMap<Passenger, Double> passengers) {
		this.passengers = passengers;
	}
	


	@Override
	public String toString() {
		return "Ticket [counter=" + counter + ", pnr=" + pnr + ", travelDate=" + travelDate + ", train=" + train
				+ ", passengers=" + passengers + "]";
	}



	public String  generatePNR()
	{
		
		String sorc=String.valueOf(train.getSource().charAt(0));
		String dest=String.valueOf(train.getDestination().charAt(0));
		String Startdate=travelDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		String pnrNo=sorc+dest+"_"+"Date"+"_"+counter++;
		if(travelDate.isAfter(LocalDate.now()))
			return pnrNo;
		else
			return "travel date is before current date";
			
	}
	public double calcPassengerFare(Passenger passenger)
	{
		
		if(passenger.getAge()<=12)
			return (0.5)*(train.getTicketPrice());
		else if(passenger.getAge()>=60)
			return (0.6)*(train.getTicketPrice());
		else if(passenger.getGender()=='F')
			return (0.25)*(train.getTicketPrice());
		else {
			return train.getTicketPrice();
		}
		
	}
	public void addPassenger(String name,int age,char gender)
	{
		passengers=new TreeMap();
		Double passengerFare=(Double) calcPassengerFare(new Passenger(name, age, gender));
		passengers.put(new Passenger(name, age, gender),passengerFare);
		System.out.println(passengerFare);
		
	}

	public double calculateTotalTicketPrice()
	{
		double totalPrice=0;
		Collection<Double>price=passengers.values();
		for(Double values:price)
		{
			totalPrice=totalPrice+values;
		}
		return totalPrice;
		
	}
	public StringBuilder generateTicket()
	{
		StringBuilder sb=new StringBuilder();
		return sb.append("PNR:"+generatePNR()).append("\n").append("TrainNo"+train.getTraiNo()).append("\n").append("TrainName"+train.getTrainName()).append("\n").append("From"+train.getSource()).append("\n").append("To"+train.getDestination()).append("\n").append("Travel Date"+getTravelDate());
		
	}
	public void writeTicket() throws IOException 
	{
		FileWriter fw=new FileWriter(generatePNR()+".txt");
		BufferedWriter bw=new BufferedWriter(fw);
		bw.append(generateTicket());
		bw.flush();
		bw.close();
		
	}
	
	
}
