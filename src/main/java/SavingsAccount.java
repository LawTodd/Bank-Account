import java.math.BigDecimal;

public class SavingsAccount extends BankAccount {
	public SavingsAccount(BigDecimal balance, BigDecimal intRate) {
		super(balance, intRate);
	}

	private String accountType = "savings";

	public String getAccountType() {
		return accountType;
	}

	@Override
	public void update() {
		
	}
}
