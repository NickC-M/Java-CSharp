
public class CheckingAccount extends BankAccount{

	private double OverdraftLimit;
	
	
	public CheckingAccount() 
	{
		super();
		OverdraftLimit = 0.0;
	}
	
	public CheckingAccount(String name, String accN, String email, String phoneN, double odLimit) 
	{
		super(name, accN, email, phoneN);
		OverdraftLimit = odLimit;
	}
	@Override
	public String getType() 
	{
		return "Checking";
	}
	
	public double getOverdraftLimit() 
	{
		return OverdraftLimit;
	}
	
	public void setOverdraftLimit(double odLimit) 
	{
		OverdraftLimit = odLimit;
	}
	
	@Override
    public String displayAccountInfo() {
        return "Checking || " +super.displayAccountInfo()+ " || Overdraft Limit: " +getOverdraftLimit();
    }
	
	@Override
	public String getSummary() 
	{
		return "Checking || "+super.getSummary();
	}
	
}
