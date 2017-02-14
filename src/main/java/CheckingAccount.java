import java.math.BigDecimal;

public class CheckingAccount extends BankAccount {
	public CheckingAccount(BigDecimal balance, BigDecimal intRate) {
		super(balance, intRate);
	}

	private String accountType = "checking";

	public String getAccountType() {
		return accountType;
	}
}
