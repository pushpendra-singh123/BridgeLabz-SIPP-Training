package inheritance_practice;
//Hierarchical 

class BankAccount {
    String accountNumber;
    double balance;

    // Constructor for BankAccount
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    

    // Method to display common account details
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }
}


//Subclass 1: SavingsAccount
class SavingsAccount extends BankAccount {
 double interestRate;

 // Constructor for SavingsAccount
 public SavingsAccount(String accountNumber, double balance, double interestRate) {
     super(accountNumber, balance);
     this.interestRate = interestRate;
 }
//Unique method
 public void displayAccountType() {
     System.out.println("Account Type: Savings Account");
     System.out.println("Interest Rate: " + interestRate + "%");
 }
}

//Subclass 2: CheckingAccount
class CheckingAccount extends BankAccount {
 double withdrawalLimit;

 // Constructor for CheckingAccount
 public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
     super(accountNumber, balance);
     this.withdrawalLimit = withdrawalLimit;
 }

 // Unique method
 public void displayAccountType() {
     System.out.println("Account Type: Checking Account");
     System.out.println("Withdrawal Limit per day: ₹" + withdrawalLimit);
 }
}

class FixedDepositAccount extends BankAccount {
    int maturityPeriod;  // in months

    // Constructor for FixedDepositAccount
    public FixedDepositAccount(String accountNumber, double balance, int maturityPeriod) {
        super(accountNumber, balance);
        this.maturityPeriod = maturityPeriod;
    }

    // Unique method
    public void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
        System.out.println("Maturity Period: " + maturityPeriod + " months");
    }
}


public class BankSystem {
	 public static void main(String[] args) {
	        // Create Savings Account
	        SavingsAccount savings = new SavingsAccount("SA123", 10000, 4.5);
	        savings.displayAccountDetails();
	        savings.displayAccountType();
	        System.out.println();

	        // Create Checking Account
	        CheckingAccount checking = new CheckingAccount("CA456", 5000, 25000);
	        checking.displayAccountDetails();
	        checking.displayAccountType();
	        System.out.println();

	        // Create Fixed Deposit Account
	        FixedDepositAccount fd = new FixedDepositAccount("FD789", 50000, 12);
	        fd.displayAccountDetails();
	        fd.displayAccountType();
	    }
}


