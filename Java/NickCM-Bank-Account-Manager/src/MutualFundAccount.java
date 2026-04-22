
public class MutualFundAccount extends BankAccount{
	private double InvestmentBalance;
	private String RiskLevel;
		
		
		public MutualFundAccount() 
		{
			super();
			InvestmentBalance = 0.0;
			RiskLevel = "";
		}
		
		public MutualFundAccount(String name, String accN, String email, String phoneN, double iBal, String rLvl) 
		{
			super(name, accN, email, phoneN);
			InvestmentBalance = iBal;
			RiskLevel = rLvl;
		}
		@Override
		public String getType() 
		{
			return "Mutual Fund";
		}
		
		public double getInvestmentBalance() 
		{
			return InvestmentBalance;
		}
		
		public String getRiskLevel() 
		{
			return RiskLevel;
		}
		
		public void setInvestmentBalance(double iBal) 
		{
			InvestmentBalance = iBal;
		}
		
		public void setRiskLevel(String rLvl) 
		{
			RiskLevel = rLvl;
		}
		
		@Override
	    public String displayAccountInfo() {
	        return "Mutual Fund || " +super.displayAccountInfo()+ " || Investment Balance: " +getInvestmentBalance()+" || Risk Level: "+getRiskLevel();
	    }
		
		@Override
		public String getSummary() 
		{
			return "Mutual Fund || "+super.getSummary();
		}

}
