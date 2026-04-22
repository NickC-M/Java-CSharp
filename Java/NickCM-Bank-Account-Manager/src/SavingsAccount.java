
public class SavingsAccount extends BankAccount{
	
private double InterestRate;
	
	
	public SavingsAccount() 
	{
		super();
		InterestRate = 0.0;
	}
	
	public SavingsAccount(String name, String accN, String email, String phoneN, double iRate) 
	{
		super(name, accN, email, phoneN);
		InterestRate = iRate;
	}
	@Override
	public String getType() 
	{
		return "Savings";
	}
	
	public double getInterestRate() 
	{
		return InterestRate;
	}
	
	public void setInterestRate(double iRate) 
	{
		InterestRate = iRate;
	}

	
	@Override
    public String displayAccountInfo() {
        return "Savings || " +super.displayAccountInfo()+ " || Interest Rate: " +getInterestRate();
    }
	
	@Override
	public String getSummary() 
	{
		return "Savings || "+super.getSummary();
	}
}
