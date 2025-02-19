import java.io.*;

public class Exercise17_7 {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Loan loan1 = new Loan();
        Loan loan2 = new Loan(1.8, 10, 10000);
        
        try (
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise17_07.dat"));
        ) {
            output.writeObject(loan1);
            output.writeObject(loan2);
        } 
        catch (IOException ex) {
            System.out.println("File could not be opened");
        }
        outputData();
    }
    static void outputData() throws IOException, EOFException, ClassNotFoundException {
        try(
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("Exercise17_07.dat"));
            ){
            int total = 0;
            Loan account;
            while(true){
                try{
                    account = (Loan)(input.readObject());
                    total += account.getLoanAmount();
                } catch(EOFException ex){
                    break;
                }
            }
            System.out.print("Total Loan ammount for all Accounts is: " + total);
        }
    }
}
