import java.io.*;
import java.net.*;

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


public class Server
{
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException
	{
		System.out.println("Server is ready to pair");
		String smsg;
		ServerSocket ss = new ServerSocket(6969);
        Socket s= ss.accept();
        System.out.println("client/server got the connection"); 
        InputStream is = s.getInputStream();
                  
        ObjectInputStream OIS = new ObjectInputStream(is);
        Student S = (Student)OIS.readObject();
        Thread.sleep(500);
        System.out.println("Object received is");
        Thread.sleep(500);
        System.out.println(S.PID + " " + S.Name + " " + S.Marks);

        if(S.Marks > 35) 
        {
        	smsg = "Pass";
        }
        
        else
        {
        	smsg = "Fail";
        }
        
        //write to the socket    
        OutputStream os =s.getOutputStream();
        
        PrintStream ps = new PrintStream(os);
        ps.println(smsg);
        System.out.println("Result sent successfully");
        
        ss.close();
        s.close();
        ps.close();
         
         
  
 }
 
 
 
 
}