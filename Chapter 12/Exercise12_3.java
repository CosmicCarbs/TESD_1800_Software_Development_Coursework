import java.util.ArrayList;
import java.util.Scanner;
    public class Exercise12_3 {
        public static void main(String[] args){
            Scanner input = new Scanner(System.in);
            ArrayList<Integer> array = new ArrayList<>();

            for(int x = 0; x < 100; x++){
                array.add((int)(Math.random() * 100));
            }
            while(true){
            try{
                System.out.print("Enter an Index number (0-99): ");
                int index = input.nextInt();
                System.out.println(array.get(index));
            }
            catch(IndexOutOfBoundsException ex){
                System.out.println("Out of Bounds");
                input.nextLine();
            }
            }
        }
    }
