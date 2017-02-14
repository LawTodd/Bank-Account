import java.math.BigDecimal;
import java.math.MathContext;
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

	public void balance() {
		System.out.println("Balance of " + this + " is: " + balance);
		System.out.println("Your account balance is    : " + balance);
		System.out.println("Your Credit Card balance is: " + loanBalance + " at an interest rate of " + intRate);
	}

	public void loan(BigDecimal amount) {
		balance = balance.add(amount);
		loanBalance = loanBalance.add(amount);
	}

	public void payment(BigDecimal amount) {
		balance = balance.subtract(amount);
		if (amount.compareTo(loanBalance) == 1) {
			System.out.println(" Your outstanding credit card balance was only " + loanBalance
					+ " but your payment was " + amount + " the extra money will be redeposited into your account.");
			loanBalance = loanBalance.subtract(amount);
			balance = balance.subtract(loanBalance);
			loanBalance = new BigDecimal("0.00");
		} else
			loanBalance = loanBalance.subtract(amount);
	}

	public void intrest() {
		if (loanBalance.equals("0.00")) {
		} else {
			loanBalance = loanBalance.add(loanBalance.multiply(intRate));
			loanBalance = loanBalance.setScale(2, RoundingMode.HALF_UP);
		}
	}

}
