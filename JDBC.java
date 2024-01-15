import java.sql.*;
import java.util.*;

class JDBC_Managament
{
	Scanner SC = new Scanner(System.in);
	
	Connection getConnection() throws SQLException, ClassNotFoundException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");//loading driver
		Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/Student","root","sdm30");// connection string
		return con;
	}
	
	
	void selectAll(Connection con) throws SQLException 
	{
		String STR = "select * from personaldetails";
		PreparedStatement pmt = con.prepareStatement(STR);
		
		ResultSet RS = pmt.executeQuery();
		
		while(RS.next()) 
		{
			int SY = RS.getInt("Percent");
			System.out.println(SY);
			//System.out.println(RS.getInt("ID") + " " + RS.getString("Name") + " " + RS.getInt("age") + " " + RS.getFloat("Percent"));
		}
	}
	
	
	void selectCondi(Connection Con) throws SQLException 
	{
		System.out.println("Enter ID");
		int x = SC.nextInt();
		String STR = "select * from personaldetails where ID = ?";
		PreparedStatement pmt = Con.prepareStatement(STR);
		
		pmt.setInt(1, x);
		
		ResultSet RS = pmt.executeQuery();
		
		while(RS.next()) 
		{
			System.out.println(RS.getInt("ID") + " " + RS.getString("Name") + " " + RS.getInt("age") + " " + RS.getFloat("Percent"));
		}
		
	}
	
	
	void UpdatePercent(Connection Con) throws SQLException
	{
		System.out.println("Enter ID");
		int ID = SC.nextInt();
		
		System.out.println("Enter updated pecentage");
		float per = SC.nextFloat();
		
		String STR = "update personaldetails set Percent = ? where ID = ?";
		
		PreparedStatement pmt = Con.prepareStatement(STR);
		
		pmt.setFloat(1, per);
		pmt.setInt(2, ID);
		
		int X = pmt.executeUpdate();
		
		System.out.println(X + " rows Updated");
	}
	
	
	void Delete(Connection Con) throws SQLException 
	{
		System.out.println("Enter ID to delete");
		int ID = SC.nextInt();
		
		String STR = "delete from personaldetails where ID = ?";
		PreparedStatement pmt = Con.prepareStatement(STR);
		
		pmt.setInt(1, ID);
		
		int X = pmt.executeUpdate();
		
		System.out.println(X + " rows deleted");
	}
	
	void Insert(Connection Con) throws SQLException 
	{
		System.out.println("Enter ID , Name , Age , Percentage");
		int ID = SC.nextInt();
		String Name = SC.next();
		int Age = SC.nextInt();
		int Percent = SC.nextInt();
		
		String STR = "insert into personaldetails values (?,?,?,?)";
		
		PreparedStatement pmt = Con.prepareStatement(STR);
		pmt.setInt(1 , ID);
		pmt.setString(2 , Name);
		pmt.setInt(3 , Age);
		pmt.setInt(4 , Percent);
		
		int X = pmt.executeUpdate();
		
		System.out.println(X + " rows added");
	}
}


public class JDBC
{
	public static void main(String[] args) throws SQLException, ClassNotFoundException 
	{
		Scanner SC = new Scanner(System.in);
		JDBC_Managament JM = new JDBC_Managament();
		Connection CON = JM.getConnection();
		
		System.out.println("1. Insert");
		System.out.println("2. Update Percentage");
		System.out.println("3. Delete");
		System.out.println("4. Select");
		System.out.println("5. SelectAll");
		System.out.println("6. Exit");
		
		while(1>0) 
		{
			System.out.println("Enter your choice");
			int ch = SC.nextInt();
			
			switch(ch)
			{
			
			case 1:
				JM.Insert(CON);
				break;
				
			case 2: 
				JM.UpdatePercent(CON);
				break;
				
			case 3:
				JM.Delete(CON);
				break;
				
			case 4:
				JM.selectCondi(CON);
				break;
				
			case 5:
				JM.selectAll(CON);
				break;
				
			case 6:
				System.exit(0);
				break;
				
			default: 
				System.out.println("Invalid Choice");
			}
			
		}
	}
}
