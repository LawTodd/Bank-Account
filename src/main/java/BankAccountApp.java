import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BankAccountApp {

	BigDecimal balance= new BigDecimal("0.00");
	BigDecimal intRate= new BigDecimal("0.02");
	BankAccount checkingAccount = new CheckingAccount(balance, intRate);
	BankAccount savingsAccount = new SavingsAccount(balance, intRate);
	BankAccount creditCard = new CreditCard(balance, intRate);
	
	public static void main(String[] args) {
		
		BankAccountApp app = new BankAccountApp();
		
		Scanner scanner = new Scanner(System.in);
		
		boolean quit = false;
		BigDecimal amount = new BigDecimal("0.00");
		List<BankAccount> accounts = 
				Arrays.asList(app.savingsAccount, app.checkingAccount, app.creditCard);
		
		while (!quit) {
			System.out.println ("Enter your transaction like this:"); 
			System.out.println("(Deposit or Withdraw)  then an Amount  then(checking,"
					+ "savings, or creditcard)");
			System.out.println("Or you can simply enter Balance, or Quit?");
			String inputTrans = scanner.next();
			switch (inputTrans) {
				case ("deposit"): {
					System.out.println("How much would you like to deposit today?");
					amount = scanner.nextBigDecimal();
					System.out.println("Which account do you want to deposit this " + amount + " in?");
					String inputAccount = scanner.next();
					switch (inputAccount) {
					case ("checking"): app.checkingAccount.deposit(amount); break;
					case ("savings"): app.savingsAccount.deposit(amount); break;
					case ("creditcard"): app.creditCard.withdraw(amount); break;
					}
					break;
				}
				case ("withdraw"): {
					System.out.println("How much would you like to withdraw today?");
					amount = scanner.nextBigDecimal();
					System.out.println("Which account do you want to deposit this " + amount + " in?");
					String inputAccount = scanner.next();
					switch (inputAccount) {
					case ("checking"): app.checkingAccount.withdraw(amount); break;
					case ("savings"): app.savingsAccount.withdraw(amount); break;
					case ("creditcard"): app.creditCard.deposit(amount); break;
					}
					break;
				}
				case ("balance"): {
					app.printBalance(accounts);
					break;
				}
				case ("quit"): {
					quit=true;
					app.printBalance(accounts);
					break;
				}
				default: {
					System.out.println("I'm sorry, I didn't understand you. ");
					break;
				}
			}
			app.interest(accounts);
			app.checkingAccount.update();
			app.savingsAccount.update();
			app.creditCard.update();
		}
		scanner.close();
	}
private void printBalance(List<BankAccount> accounts) {
	for (BankAccount a: accounts) {
		System.out.println("Balance of " + a + " is: " + a.getBalance());
	}
}
private void interest(List<BankAccount> accounts) {
	for (BankAccount a: accounts) {
		a.intrest();
	}
}
}

