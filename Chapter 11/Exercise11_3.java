public class Exercise11_3 {
    public static void main(String[] args){

        Account account = new Account(1122);
        CheckingAccount checkingAccount = new CheckingAccount(100.0);
        SavingsAccount savingsAccount = new SavingsAccount(100.0, 0.5);
        
        System.out.println(account.toString());
        System.out.println(checkingAccount.toString());
        System.out.println(savingsAccount.toString());
    }
}
           
class Account{
    int id;
    java.util.Date dateCreated;

    Account(){
        id = 0;
        dateCreated = new java.util.Date();
    }
    Account(int newId){
        id = newId;
        dateCreated = new java.util.Date();
    }
    public int getId(){
        return id;
    }
    public void setId(int newId){
        id = newId;
    }
    public java.util.Date getDateCreated(){
        return dateCreated;
    }
    public String toString(){
        return "Account ID: " + getId() + "\nAccount created on: " + getDateCreated();
    }
}
class CheckingAccount extends Account{

    double checking;

    CheckingAccount(){
        checking = 0;
    }
    CheckingAccount(double newChecking){
        checking = newChecking;
    }
    public double getChecking(){
        return checking;
    }
    public void setChecking(double newChecking){
        checking = newChecking;
    }
    double withdraw(double amount){
        return checking -= amount;
    }
    double deposit(double amount){
        return checking += amount;
    }
    public String toString(){
        return "Checking Balance is: $" + getChecking();
    }
}
class SavingsAccount extends Account{

    double savings;
    double annualInterestRate;

    SavingsAccount(){
        savings = 0;
        annualInterestRate = 0;
    }
    SavingsAccount(double newSavings, double interestRate){
        savings = newSavings;
        annualInterestRate = interestRate;
    }
    public double getSavings(){
        return savings;
    }
    public void setBalance(double newSavings){
        savings = newSavings;
    }
    double withdraw(double amount){
        return savings -= amount;
    }
    double deposit(double amount){
        return savings += amount;
    }
    public double getAnnualInterestRate(){
        return annualInterestRate;
    }
    public void setAnnualInterestRate(double newAnnualInterestRate){
        annualInterestRate = newAnnualInterestRate;
    }
    public String toString(){
        return "Savings Balance is: $" + getSavings() + "\nSavings Interest Rate is: " + getAnnualInterestRate() + "%";
    }
}
