import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class BankAccount {

	private BigDecimal balance; // = new BigDecimal("0.00");
	private BigDecimal loanBalance = new BigDecimal("0.00");
	private BigDecimal intRate; // = new BigDecimal("0.01");

	public BankAccount(BigDecimal balance, BigDecimal intRate) {
		this.balance = balance;
		this.intRate = intRate;
	}

	public abstract String getAccountType();

	public void deposit(BigDecimal amount) {
		balance = balance.add(amount);
	}

	public void withdraw(BigDecimal amount) {
		balance = balance.subtract(amount);
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void payment(BigDecimal amount) {
		balance = balance.subtract(amount);
		if (amount.compareTo(loanBalance) == 1) {
			System.out.println(" Your outstanding credit card balance was only " + loanBalance
					+ " but your payment was " + amount + " the extra money will be redeposited into your account.");
			balance = balance.subtract(loanBalance);
		} 
	}

	public void intrest() {
		if (balance.equals("0.00")) {
		} else {
			balance = balance.add(balance.multiply(intRate));
			balance = balance.setScale(2, RoundingMode.HALF_UP);
		}
	}
	
	public abstract void update();
}
