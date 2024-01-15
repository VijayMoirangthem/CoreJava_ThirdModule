import java.io.*;
import java.util.*;

class Student implements Serializable
{
	int ID , Marks;
	String Name , Subject;
	
	
	Student(int iD, String name, String subject, int marks) 
	{
		ID = iD;
		Name = name;
		Subject = subject;
		Marks = marks;
	}
	
	void Display() 
	{
		System.out.println("Student [ID=" + ID + ", Name=" + Name + ", Subject=" + Subject + ", Marks=" + Marks + "]");
	}
	
}


class SortByMark implements Comparator<Student>
{

	@Override
	public int compare(Student o1, Student o2) 
	{
		if(o1.Marks > o2.Marks) 
		{
			return 1;
		}
		
		else
		{
			return -1;
		}
	}
	
}



class FileManagement
{
	void Add() throws IOException
	{
		FileOutputStream FOS = new FileOutputStream("sid.csv");
		ObjectOutputStream OOS = new ObjectOutputStream(FOS);
		
		Student S1 = new Student(1 , "Siddant" , "Maths" , 95);
		Student S2 = new Student(2 , "Vijay" , "Eng" , 20);
		Student S3 = new Student(3 , "Kelvin" , "Hindi" , 33);
		Student S4 = new Student(4 , "Ayush" , "SST" , 80);
		Student S5 = new Student(5 , "Nishant" , "Science" , 56);
		
		
		OOS.writeObject(S1);
		OOS.writeObject(S2);
		OOS.writeObject(S3);
		OOS.writeObject(S4);
		OOS.writeObject(S5);
		
		System.out.println("Five Objects Added Successfully \n");
	}
	
	
	void Read() throws IOException, ClassNotFoundException 
	{
		FileInputStream FIS = new FileInputStream("sid.csv");
		ObjectInputStream OIS = new ObjectInputStream(FIS);
		
		Student S;
		try
		{
			while((S = (Student) OIS.readObject()) != null) 
			{
				S.Display();
				System.out.println("\n");
			}
		}
		catch(EOFException e) 
		{
			
		}
		
	}
	
	
	void Res() throws ClassNotFoundException, IOException 
	{
		FileInputStream FIS = new FileInputStream("sid.csv");
		ObjectInputStream OIS = new ObjectInputStream(FIS);
		
		Student S;
		try
		{
			while((S = (Student) OIS.readObject()) != null) 
			{
				S.Display();
				if(S.Marks >= 35 ) 
				{
					System.out.println("Result: Pass");
				}
				
				else 
				{
					System.out.println("Result: Fail");
				}

				System.out.println("\n");
			}
		}
		catch(EOFException e) 
		{
			
		}
	}
	
	
	void Num() throws ClassNotFoundException, IOException 
	{
		int pass = 0 , fail = 0;
		FileInputStream FIS = new FileInputStream("sid.csv");
		ObjectInputStream OIS = new ObjectInputStream(FIS);
		
		Student S;
		try
		{
			while((S = (Student) OIS.readObject()) != null) 
			{
				if(S.Marks >= 35 ) 
				{
					pass++;
				}
				
				else 
				{
					fail++;
				}
				
			}
		}
		catch(EOFException e) 
		{
			
		}

		System.out.println("No. of Students Passed: "+pass);
		System.out.println("No. of Students failed: "+fail);
		System.out.println("\n");
	}
	
	
	void Sort() throws IOException, ClassNotFoundException
	{
		ArrayList<Student> ARL = new ArrayList<>();
		
		FileInputStream FIS = new FileInputStream("sid.csv");
		ObjectInputStream OIS = new ObjectInputStream(FIS);
		
		Student S;
		
		try
		{
			while((S = (Student)OIS.readObject()) != null) 
			{
				ARL.add(S);
			}
		}
		catch(EOFException e) 
		{
			
		}
		
		
		SortByMark SBM = new SortByMark();
		Collections.sort(ARL, SBM);
		
		
		
		FileOutputStream FOS = new FileOutputStream("sid.csv");
		ObjectOutputStream OOS = new ObjectOutputStream(FOS);
		
		Iterator<Student> I = ARL.iterator();
		while(I.hasNext()) 
		{
			S = I.next();
			OOS.writeObject(S);
		}
		System.out.println("File Sorted Successfully");
	}
}


public class FileHandling 
{
	public static void main(String[] args) throws IOException, ClassNotFoundException 
	{
		FileManagement FM = new FileManagement();
		Scanner SC = new Scanner(System.in);
		
		System.out.println("1. Write");	
		System.out.println("2. Read");
		System.out.println("3. Find out result and display the student details along with result");
		System.out.println("4. Find out how many no of students passed and failed");
		System.out.println("5. Sort the students object based on marks");
		System.out.println("6. Exit");
		
		while(1>0) 
		{
			int CH = SC.nextInt();
			
			switch(CH) 
			{
			case 1:
				FM.Add();
				break;
				
			case 2:
				FM.Read();
				break;
				
			case 3:
				FM.Res();
				break;
				
			case 4:
				FM.Num();
				break;
				
			case 5:
				FM.Sort();
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
