import java.util.Scanner;

class BankAccount {
    private double balance;
    public BankAccount(double initialBalance){
        this.balance = initialBalance;
    }

    public void deposit(double amount){
        if(amount > 0) {
            balance += amount;
            System.out.println("Amount Deposited Successfully!");
        } else {
            System.out.println("Invalid Amount!");
        }
    }

    public void withdraw(double amount){
        if (amount > 0){
            if(amount <= balance){
                balance -= amount;
                System.out.println("Withdrawal Successful.");
            } else {
                System.out.println("Insufficient Balance.");
            }
        } else {
            System.out.println("Invalid Amount.");
        }
    }
    public double getBalance(){
        return balance;
    }
}

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BankAccount account = new BankAccount(5000);
        System.out.println("Welcome to ATM");
        boolean exit = false;

        while(!exit){
            System.out.println("----- ATM MENU -----");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.println("Current Balance: $" + account.getBalance());
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using our ATM.");
                    break;
                default:
                    System.out.println("Invalid Option! Please Try Again.");
            }
        }
        sc.close();
    }
}