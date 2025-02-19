import java.io.*;

public class Exercise17_1 {
    public static void main(String[] args) throws IOException{
        try(
            FileOutputStream output = new FileOutputStream("Exercise17_1.txt", true);
        ){
            int number = 0;
            for(int x = 1; x <= 100; x++)
            number = (int)(Math.random() * 10);
            output.write(number);
        }
        try(
            FileInputStream input = new FileInputStream("Exercise17_1.txt");
        ){
            int value;
            while ((value = input.read()) != -1)
            System.out.print(value + " ");
        }
    }
}
