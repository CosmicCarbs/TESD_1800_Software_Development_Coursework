import java.io.*;

public class Exercise17_3 {
    public static void main(String[] args) throws IOException{
        Exercise17_3.createFile();
        Exercise17_3.printFile();
    }
    static void createFile() throws IOException{
        try(
            DataOutputStream output = new DataOutputStream(new FileOutputStream("Exercise17_03.dat", true));
        ){
            int number = 0;
            for(int x = 1; x <= 100; x++)
            number = (int)(Math.random() * 10);
            output.writeInt(number);
            output.writeUTF(" ");
        }    
    }

    static void printFile() throws IOException{
        try(
            DataInputStream input = new DataInputStream(new FileInputStream("Exercise17_1.dat"));
        ){
            int value;
            int total = 0;
            while ((value = input.readInt()) != -1)
                total += value;
            System.out.print("Total: " + total);
        }
    }
}

