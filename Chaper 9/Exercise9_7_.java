public class Exercise9_7_ {
    public static void main(String[] args){
        
        Account account = new Account(1122, 20000.0);
        account.getDateCreated();
        account.setAnnualInterestRate(4.5);

        account.withdraw(2500.0);
        account.deposit(3000.0);

        System.out.println("Balance is: $" + account.getBalance());
        System.out.println("Monthly interest rate is: " + account.getMonthlyInterestRate() + "%");
        System.out.println("Account was created on: " + account.getDateCreated());
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
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double newBalance){
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