import java.util.*;

class Player
{
	String PName , PCountry , Category = null;
	int TRun , NWickets , NMatches , NCent;
	
	
	Player(String pName, String pCountry, int nMatches, int tRun, int nWickets, int nCent) 
	{
		PName = pName;
		PCountry = pCountry;
		NMatches = nMatches;
		TRun = tRun;
		NWickets = nWickets;
		NCent = nCent;
	}

	
	
	void Disp()
	{
		System.out.println("PName=" + PName );
		System.out.println("PCountry=" + PCountry );
		System.out.println("NMatches=" + NMatches );
		System.out.println("TRun=" + TRun );
		System.out.println("NWickets=" + NWickets );
		System.out.println("NCent=" + NCent );
		System.out.println("Category=" + Category );
		System.out.println("\n");
		
	}
	
	
}


class SortByRuns implements Comparator<Player>
{

	@Override
	public int compare(Player o1, Player o2)
	{
		if(o1.TRun > o2.TRun) 
		{
			return 1;
		}
		
		else 
		{
			return -1;
		}
	}

	

}



class SortByName implements Comparator<Player>
{

	@Override
	public int compare(Player o1, Player o2) 
	{
		return o1.PName.compareTo(o2.PName);
	}
	
}



class ArrayListManagement
{
	void Add(ArrayList<Player> ARL) 
	{
		Player P1 = new Player("Siddant" , "Nagpur" , 16 , 2000 , 2 , 15);
		Player P2 = new Player("Vijay" , "Imphal" , 10 , 1500 , 20 , 9);
		Player P3 = new Player("Kelvin" , "Panvel" , 12 , 100 , 15 , 0);
		Player P4 = new Player("Ayush" , "Prayagraj" , 14 , 200 , 5 , 0);
		Player P5 = new Player("Nishant" , "Bangalore" , 16 , 1200 , 3 , 11);
		
		ARL.add(P1);
		ARL.add(P2);
		ARL.add(P3);
		ARL.add(P4);
		ARL.add(P5);
		
		System.out.println("Five Objects Added Successfully \n");
	}
	
	
	void Display(ArrayList<Player> ARL) 
	{
		Iterator<Player> IR = ARL.iterator();
		
		while(IR.hasNext()) 
		{
			Player P = (Player) IR.next();
			P.Disp();
		}
	}
	
	
	void DisplayMax(ArrayList<Player> ARL) 
	{
		SortByRuns SBR = new SortByRuns();
		Collections.sort(ARL , SBR);
		
		Player P = ARL.get(ARL.size()-1);
		
		P.Disp();
	}
	
	
	void SortByName(ArrayList<Player> ARL) 
	{
		SortByName SBN = new SortByName();
		Collections.sort(ARL, SBN);
		Display(ARL);
	}
	
	void Rem(ArrayList<Player> ARL)
	{
		Iterator<Player> IR = ARL.iterator();
		
		while(IR.hasNext()) 
		{
			Player P = (Player) IR.next();
			
			if(P.TRun <= 200)
			{
				IR.remove();
			}
		}
		Display(ARL);
	}
	
	void UpdateCat(ArrayList<Player> ARL) 
	{
		Iterator<Player> IR = ARL.iterator();
		
		while(IR.hasNext()) 
		{
			Player P = (Player) IR.next();
			
			if(P.NCent >= 10)
			{
				P.Category = "A";
			}
			
			else
			{
				P.Category = "B";
			}
		}
		Display(ARL);
	}
}


public class ARRLIST 
{
	public static void main(String[] args) 
	{
		ArrayList<Player> ARL = new ArrayList<>();
		
		ArrayListManagement ARM = new ArrayListManagement();
		Scanner SC = new Scanner(System.in);
		
		System.out.println("1. Add");
		System.out.println("2. Display");
		System.out.println("3. Display the player details who has scored maximum no of runs ");
		System.out.println("4. Sort the players by name ");			
		System.out.println("5. Remove the player who has scored less than 100 runs ");
		System.out.println("6. Update Category ‘A’ if player has got 10 century else update Grade 'B'");
		System.out.println("7. Exit");
		
		while(1>0) 
		{
			System.out.println("Enter Your Choice");
			int Ch = SC.nextInt();
			
			switch(Ch)
			{
			case 1:
				ARM.Add(ARL);
				break;
				
			case 2:
				ARM.Display(ARL);
				break;
				
			case 3:
				ARM.DisplayMax(ARL);
				break;
				
			case 4:
				ARM.SortByName(ARL);
				break;
				
			case 5:
				ARM.Rem(ARL);
				break;
				
			case 6:
				ARM.UpdateCat(ARL);
				break;
				
			case 7:
				System.exit(0);
				break;
				
			default:
				System.out.println("Invalid Choice");	
			}
		}
		
	}
}
