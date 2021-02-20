import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class TicketApplication {

	public static void main(String[] args) throws IOException {
		System.out.println("======Ticket Application=====");
		TrainDAO trainDao=new TrainDAO();
		DateTimeFormatter df=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the train number:");
		
		
		Train train =trainDao.findTrain(sc.nextInt());
		System.out.println("price is"+train.getTicketPrice());
		
		System.out.println("Enter travel date:");
		String travelDate=sc.next();
		LocalDate date=LocalDate.parse(travelDate,df);
		
		System.out.println("travelDate"+date);
		System.out.println("after format"+date.format(df));
		
		System.out.println("Enter Number Of Passengers:");
		int numberOfPassengers=sc.nextInt();
		
		//System.out.println("Enter Passenger Name:");
		//String DetailsOfEachPassenger=sc.nextLine();
		
	
		//Train train1=new Train(trainNo, DetailsOfEachPassenger, travelDate, DetailsOfEachPassenger, numberOfPassengers);
		Ticket ticket =new Ticket(date, train);
		sc.nextLine();
		
		for(int i=1;i<=numberOfPassengers;i++)
		{
			System.out.println("Enter Passenger Name:");
			String name=sc.next();
			sc.nextLine();
			
			System.out.println("Enter the age:");
			int age=sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter Genger(M/F)");
			String gender=sc.next();
			char g=gender.charAt(0);
			
			ticket.addPassenger(name,age,g);
		}
		System.out.println("Total Price:"+ticket.calculateTotalTicketPrice());
		System.out.println("Ticket Booked with PNR:"+ ticket.generatePNR());
		ticket.writeTicket();
		

	}

}
