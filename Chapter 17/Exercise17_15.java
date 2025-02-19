import java.io.*;
import java.util.Scanner;

public class Exercise17_15 {
    public static void main(String[] args) throws IOException{
        Scanner nameInput = new Scanner(System.in);
        System.out.print("Enter Input File to Decrypt: ");
        String inputFile = nameInput.nextLine();
        System.out.print("Enter Output File Name of Decrypted: ");
        String outputFile = nameInput.nextLine();
        nameInput.close();
        
        try(
            FileInputStream input = new FileInputStream(inputFile + ".dat");
            FileOutputStream output = new FileOutputStream(outputFile + ".dat");
        ){
            int value;
            while((value = input.read()) != -1){
                value -= 5;
                System.out.print(value + " ");
                output.write(value);
            }
        }
        catch (IOException ex) {
            System.out.println("File could not be opened");
        }
    }
}
