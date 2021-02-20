import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TrainDAO 
{
	String driverClass="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/traininfo?autoReconnect=true&useSSL=false";
	String userName="root";
	String password="root";
		public Train findTrain(int Train_NO)
		{
			Train train=null;
			try {
			
				Class.forName(driverClass);
				System.out.println("class found");
			
				Connection con=DriverManager.getConnection(url,userName,password);
				System.out.println("connected");

				PreparedStatement ps=con.prepareStatement("select * from train where Train_NO=?");
				ps.setInt(1,Train_NO);
			
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					train=new Train(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
				}
				con.close();
		
			}
			catch(Exception e){
				System.out.println(e);
			}
			return train;
	}
}