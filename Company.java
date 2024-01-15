class Employee
{
	protected String Name , SSN;
	
	public Employee(String name, String sSN) {
		Name = name;
		SSN = sSN;
	}

	public void Salary() 
	{
		
	}

	@Override
	public String toString() {
		return "Employee [Name=" + Name + ", SSN=" + SSN + "]";
	}
	
	
}


class CommissionEmployee extends Employee
{
	protected double sales , commission;
	
	public CommissionEmployee(String name, String sSN, double sales, double commission) {
		super(name, sSN);
		this.sales = sales;
		this.commission = commission;
	}

	public double salary()
	{
		return sales * commission;
	}

	@Override
	public String toString() {
		return "CommissionEmployee [Name=" + Name + ", SSN=" + SSN + ", sales=" + sales + ", commission=" + commission
				+ "]";
	}
	
}


class HourlyEmployee extends Employee
{
	protected double wages , hours;
	
	public HourlyEmployee(String name, String sSN, double wages, double hours) {
		super(name, sSN);
		this.wages = wages;
		this.hours = hours;
	}

	public double salary()
	{
		return wages * hours;
	}

	@Override
	public String toString() {
		return "HourlyEmployee [Name=" + Name + ", SSN=" + SSN + ", wages=" + wages + ", hours=" + hours + "]";
	}
	
}


class SalariedEmployee extends Employee
{
	protected double BasicSalary;
	
	public SalariedEmployee(String name, String sSN, double basicSalary) {
		super(name, sSN);
		BasicSalary = basicSalary;
	}

	public double salary()
	{
		return BasicSalary;
	}

	@Override
	public String toString() {
		return "SalariedEmployee [Name=" + Name + ", SSN=" + SSN + ", BasicSalary=" + BasicSalary + "]";
	}
	
}

public class Company
{
	public static void main(String[] args)
	{
		System.out.println("CommissionEmployee Object");
		CommissionEmployee CE = new CommissionEmployee("Siddant" , "E007" , 20 , 2.5);
		System.out.println(CE.toString());
		System.out.println("Salary: "+CE.salary());
		System.out.println("\n");
		
		System.out.println("HourlyEmployee Object");
		HourlyEmployee HE = new HourlyEmployee("Siddant" , "E007" , 5000 , 7);
		System.out.println(HE.toString());
		System.out.println("Salary: "+HE.salary());
		System.out.println("\n");
		
		System.out.println("SalariedEmployee Object");
		SalariedEmployee SE = new SalariedEmployee("Siddant" , "E007" , 25000);
		System.out.println(SE.toString());
		System.out.println("Salary: "+SE.salary());
		System.out.println("\n");
		
	}
}
