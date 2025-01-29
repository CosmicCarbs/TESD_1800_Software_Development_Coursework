import java.util.Scanner;
public class Exercise10_7 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Account[] account = new Account[10];
        account[0] = new Account(1122, 100.0);
        account[1] = new Account(2002, 100.0);
        account[2] = new Account(3655, 100.0);
        account[3] = new Account(4823, 100.0);
        account[4] = new Account(5105, 100.0);
        account[5] = new Account(6378, 100.0);
        account[6] = new Account(7112, 100.0);
        account[7] = new Account(8059, 100.0);
        account[8] = new Account(9142, 100.0);
        account[9] = new Account(1800, 100.0);
        while(true){
            System.out.print("Enter your account ID: ");
            int accountId = input.nextInt();
            for(int x = 0; x < 10; x++){
                if(accountId == account[x].getId()){
                    while(true){
                        double amount = 0;
                        System.out.println("Welcome " + account[x].getId() + " Choose an Option Below");
                        System.out.println("1: Check Balance");
                        System.out.println("2: Withdraw");
                        System.out.println("3: Deposit");
                        System.out.println("4: Exit");
                        System.out.print("Enter Choice: ");
                        int option = input.nextInt();
                        
                        if(option == 1)
                            System.out.println("Current Balance is: " + account[x].getBalance());
                        else if(option == 2){
                            System.out.print("Enter Ammount to Withdraw:");
                            amount = input.nextDouble();
                            if(account[x].getBalance() < amount)
                                System.out.println("Insufficient Funds");
                            else   
                                account[x].setBalance(account[x].getBalance() - amount);
                        }
                        else if(option == 3){
                            System.out.print("Enter Ammount to Deposit: ");
                            amount = input.nextDouble();
                            account[x].setBalance(account[x].getBalance() + amount);
                        }
                        else if(option == 4)
                            break;
                        else
                            System.out.println("Invalid Input");
                    }
                }
            }
            System.out.println("Account not found, try again");
        }
    }
}
class Account{
    int id;
    double balance;
    double annualInterestRate;
    java.util.Date dateCreated;
    double amount;

    Account(){
        id = 0;
        balance = 0;
        annualInterestRate = 0;
        dateCreated = new java.util.Date();
    }
    Account(int newId, double newBalance){
        id = newId;
        balance = newBalance;
        dateCreated = new java.util.Date();
    }
    public int getId(){
        return id;
    }
    public void setId(int newId){
        id = newId;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double newBalance){
        balance = newBalance;
    }
    public double getAnnualInterestRate(){
        return annualInterestRate;
    }
    public void setAnnualInterestRate(double newAnnualInterestRate){
        annualInterestRate = newAnnualInterestRate;
    }
    public java.util.Date getDateCreated(){
        return dateCreated;
    }
    public double getMonthlyInterestRate(){
        return annualInterestRate / 12;
    }
    public double getMonthlyInterest(){
        return (annualInterestRate / 100) * balance / 12;
    }
    double withdraw(double amount){
        return balance -= amount;
    }
    double deposit(double amount){
        return balance += amount;
    }
}