import java.util.Scanner;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

   
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient balance. Available balance: $" + balance);
        } else {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        }
    }

   
    public double getBalance() {
        return balance;
    }
}


public class BankAccountManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
      
        BankAccount account = new BankAccount("123456789", 500.0);

        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        
        try {
            account.withdraw(amount);
            System.out.println("New Balance: $" + account.getBalance());
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Transaction complete.");
        }
        
        scanner.close();
    }
}
