import java.util.jar.Attributes.Name;
/*
 * Nicholas Chapman-Miller
 * CPT-236-lab-6-7
 */

public class BankAccount {
	
	private String AccountNumber;
	private String OwnerName;
	private String Email;
	private String PhoneNumber;
	private double Balance;
	
	
	
	public BankAccount(String name, String accN, String email, String phoneN) 
	{
		AccountNumber = accN;
		OwnerName = name;
		Email = email;
		PhoneNumber = phoneN;
		Balance = 0.0;
	}
	
	public BankAccount() //default constructor
	{
		AccountNumber = "";
		OwnerName = "";
		Email = "";
		PhoneNumber = "";
		Balance = 0.0;
	}
	
	public String getType() 
	{
		return "Default";
	}
	
	public String getAccN() 
	{
		return AccountNumber;
	}
	
	public String getName() 
	{
		return OwnerName;
	}
	
	public String getEmail() 
	{
		return Email;
	}
	
	public String getPhoneNum() 
	{
		return PhoneNumber;
	}
	
	public double getBal() 
	{
		return Balance;
	}
	
	public void setAccN(String accN) 
	{
		AccountNumber = accN;
	}
	
	public void setName(String name) 
	{
		OwnerName = name;
	}
	
	public void setEmail(String email) 
	{
		Email = email;
	}
	
	public void setPhoneNum(String pNum) 
	{
		PhoneNumber = pNum;
	}
	
	public void setBal(double bal) 
	{
		Balance = bal;
	}
	
	public void deposit(double amt) 
	{
		if(amt >= 0) 
		{
			Balance += amt;
		}else 
		{
			BankErrorJFrame error = new BankErrorJFrame("INVALID DEPOSIT AMOUNT");
		}
	}
	
	public void withdraw(double amt) 
	{
		if(amt >= 0 && amt <= Balance) 
		{
			Balance -= amt;
		}else 
		{
			BankErrorJFrame error = new BankErrorJFrame("INVALID WITHDRAW AMOUNT");
		}
	}
	

	
	
    public String displayAccountInfo() {
        return getName()+ " || Acc #: " +getAccN()+ " || Email: " +getEmail()+" || Phone #: "+getPhoneNum()+" || Balance: $"+getBal();
    }
	
	public String getSummary() 
	{
		return getName()+ " || Acc #: "+getAccN()+ " || Balance: $"+getBal();
	}
	
}
