
public class CryptoAccount extends BankAccount{
	
private double CryptoBalance;
private String CryptoType;
	
	
	public CryptoAccount() 
	{
		super();
		CryptoBalance = 0.0;
		CryptoType = "";
	}
	
	public CryptoAccount(String name, String accN, String email, String phoneN, double crypBal, String crypT) 
	{
		super(name, accN, email, phoneN);
		CryptoBalance = crypBal;
		CryptoType = crypT;
	}
	@Override
	public String getType() 
	{
		return "Crypto";
	}
	
	public double getCryptoBalance() 
	{
		return CryptoBalance;
	}
	
	public String getCryptoType() 
	{
		return CryptoType;
	}
	
	public void setCryptoBalance(double crypBal) 
	{
		CryptoBalance = crypBal;
	}
	
	public void setCryptoType(String crypT) 
	{
		CryptoType = crypT;
	}

	
	@Override
    public String displayAccountInfo() {
        return "Crypto || " +super.displayAccountInfo()+ " || Crypto Balance: " +getCryptoBalance()+" || Crypto Type: "+getCryptoType();
    }
	
	@Override
	public String getSummary() 
	{
		return "Crypto || "+super.getSummary();
	}
}
