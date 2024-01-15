import java.io.*;
import java.net.*;
import java.util.Scanner;

class Student implements Serializable
{
	int PID, Marks;
	String Name;

	public Student(int pID, String name, int marks) 
	{
		PID = pID;
		Name = name;
		Marks = marks;
	}
	 	 
}



public class Client
{
	
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException 
	{
		
		Socket s = new Socket("localhost",6969);
   
		System.out.println("Connected to Server");
		Thread.sleep(500);
		Scanner SC = new Scanner(System.in);
		OutputStream os =s.getOutputStream();      
		ObjectOutputStream OOS = new ObjectOutputStream(os);
  
		
		//write to the socket 
		System.out.println("Enter ID , name , marks");
		int ID = SC.nextInt();
		String Name = SC.next(); 
		int Marks = SC.nextInt();
		Student S = new Student(ID, Name , Marks);  
		OOS.writeObject(S);    
		System.out.println("object sent to server");  
      
     
		//read from socket
		InputStream is = s.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String smg=br.readLine();        
		System.out.println("Result is: "); 
		Thread.sleep(500);
		System.out.print(smg);
     
		s.close();  
		os.close();
		OOS.close();      
         
	} 
 }