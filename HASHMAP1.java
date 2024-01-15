import java.util.*;

class Book
{
	String BName , AName , BPublication;
	double BPrice;
	int ISBN;
	
	
	Book(int iSBN, String bName, String aName, String bPublication, double bPrice) 
	{
		ISBN = iSBN;
		BName = bName;
		AName = aName;
		BPublication = bPublication;
		BPrice = bPrice;
	}


	void Disp() {
		System.out.println("Book [BName=" + BName + ", AName=" + AName + ", BPublication=" + BPublication + ", BPrice=" + BPrice
				+ ", ISBN=" + ISBN + "]");
	} 
	
	 

}


class HashmapManagement
{
	void Add(HashMap<Integer, Book> HM)
	{
		Book B1 = new Book(1001 , "Book1" , "Auth1" , "Pub1" , 200);
		Book B2 = new Book(1002 , "Book2" , "Auth2" , "Pub2" , 400);
		Book B3 = new Book(1003 , "Book3" , "Auth3" , "Pub3" , 250);
		Book B4 = new Book(1004 , "Book4" , "Auth4" , "Pub4" , 500);
		Book B5 = new Book(1005 , "Book5" , "Auth5" , "Pub5" , 150);
		
		
		HM.put(B1.ISBN, B1);		
		HM.put(B2.ISBN, B2);
		HM.put(B3.ISBN, B3);
		HM.put(B4.ISBN, B4);
		HM.put(B5.ISBN, B5);
		
		System.out.println("Five Objects Added Successfully \n");

	}
	
	
	void Display(HashMap<Integer, Book> HM)
	{
		for(Map.Entry<Integer, Book> BX : HM.entrySet()) 
		{
			int x = BX.getKey();
			Book B = BX.getValue();
			
			System.out.print("Key: ");
			System.out.println(x);
			
			System.out.print("Value: ");
			B.Disp();
			
			System.out.println("\n");
		}
	}
	
	
	void Get(int isbn , HashMap<Integer, Book> HM)
	{
		Book B = HM.get(isbn);
		B.Disp();
	}
	
	
	void PRedu(String Pub , HashMap<Integer, Book> HM)
	{
		for(Map.Entry<Integer, Book> E : HM.entrySet()) 
		{
			Book B = E.getValue();
			
			if(B.BPublication.equals(Pub)) 
			{
				B.BPrice = 0.9 * B.BPrice;
			}
		}
		System.out.println("Price reduced successfully");
	}
	
	
}


public class HASHMAP1 
{	
	public static void main(String[] args) 
	{
		HashmapManagement HMM = new HashmapManagement();
		Scanner SC = new Scanner(System.in);
		HashMap<Integer , Book> HM = new HashMap<>();
		
		
		System.out.println("1. Add");	
		System.out.println("2. Display all the map object using for each ");
		System.out.println("3. Read any key from the user and display the particular book object based on key ");
		System.out.println("4. Reduce the price by 10% for a particular publication books and display all object with reduced price. ");
		System.out.println("5. Exit");
		
		while(1>0) 
		{
			System.out.println("\nEnter your Choice");
			
			int Ch = SC.nextInt();
			
			switch(Ch)
			{
			case 1:
				HMM.Add(HM);
				break;
				
			case 2:
				HMM.Display(HM);
				break;
				
			case 3:
				System.out.println("Enter ISBN");
				int ISBN = SC.nextInt();
				HMM.Get(ISBN, HM);
				break;
				
			case 4:
				System.out.println("Enter Publication");
				String Pub = SC.next();
				HMM.PRedu(Pub, HM);
				break;
				
			case 5:
				System.exit(0);
				
			default:
				System.out.println("Invalid Choice");	
			}
			
			SC.close();
		}
	}
	
}
