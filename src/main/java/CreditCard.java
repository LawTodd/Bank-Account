import java.math.BigDecimal;

public class CreditCard extends BankAccount {
	public CreditCard(BigDecimal balance, BigDecimal intRate) {
		super(balance, intRate);
	}

	private String accountType = "credit card";

	public String getAccountType() {
		return accountType;
	}

	@Override
	public void update() {
		
	}
}
