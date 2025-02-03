import java.util.ArrayList;
import java.util.Scanner;
public class Exercise12_15 {
    public static void main(String[] args) throws Exception{

    java.io.File file = new java.io.File("Exercise12_15.txt");
    if(file.exists()){
        System.out.println("File Already Exists");
        System.exit(0);
    }
    java.io.PrintWriter output = new java.io.PrintWriter(file);
        for(int x = 0; x < 100; x++){
        output.print((int)(Math.random() * 100) + " ");
        }
        output.close();

    ArrayList<Integer> array = new ArrayList<>();
    Scanner input = new Scanner(file);
        while (input.hasNext()){
            array.add(input.nextInt());
        }
        java.util.Collections.sort(array);
        System.out.print(array);
        input.close();
    }
}
