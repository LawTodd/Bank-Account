import java.math.BigDecimal;
import java.util.Scanner;

public class BankAccountApp {

	public static void main(String[] args) {
		
		BigDecimal balance= new BigDecimal("0.00");
		BigDecimal intRate= new BigDecimal("0.02");
		Scanner scanner = new Scanner(System.in);
		BankAccount account = new CheckingAccount(balance, intRate);
		boolean quit = false;
		BigDecimal amount = new BigDecimal("0.00");
		
		while (!quit) {
			System.out.println("I'm your friendly neighborhood bank teller. ");
			System.out.println ("Would you like to Deposit, Withdraw, get an Advance on your Credit Card,"
					+ " make a Payment on your Credit Card, get your Balance, or Quit?");
			String input = scanner.next();
			switch (input) {
				case ("deposit"): {
					System.out.println("How much would you like to deposit today?");
					amount = scanner.nextBigDecimal();
					System.out.println(amount);
					account.deposit(amount); 
					System.out.println("Account type = " + account.getAccountType());
					break;
				}
				case ("withdraw"): {
					System.out.println("How much would you like to withdraw today?");
					amount = scanner.nextBigDecimal();
					account.withdraw(amount);
					break;
				}
				case ("advance"): {
					System.out.println("How much would you like to borrow today?");
					amount = scanner.nextBigDecimal();
					account.loan(amount);
					break;
				}
				case ("payment"): {
					System.out.println("How much would you like to pay on your loan today?");
					amount = scanner.nextBigDecimal();
					account.payment(amount);
					break;
				}
				case ("balance"): {
					account.balance();
					break;
				}
				case ("quit"): {
					quit=true;
					account.balance();
					break;
				}
				default: {
					System.out.println("I'm sorry, I didn't understand you. ");
					break;
				}
			}
			account.intrest();
		}
		scanner.close();
	}

}
