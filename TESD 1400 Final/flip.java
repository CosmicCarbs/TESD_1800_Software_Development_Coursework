import java.util.Scanner;
    public class flip {
        public static void main(String[] args){
          int total = 10000;
          int difficulty = 1;
          int multiplier = 1;
          int bet = 0;
        while(true){
          Scanner input = new Scanner(System.in);
          while(true){
            System.out.println("\nWelcome to Voltorb Flip!(Kinda)");
            System.out.println("(press the number for the corresponding option)");
            System.out.println("1: Start");
            System.out.println("2: Difficulty");
            System.out.println("3: Rules");
            System.out.println("4: Quit");
            int user = input.nextInt();

            if(user == 1)
              break;


            else if(user == 2){
              System.out.println("enter '1' for 2 bombs payout = 1 to 1");
              System.out.println("enter '2' for 3 bombs payout = 3 to 1");
              System.out.println("enter '3' for 4 bombs payout = 5 to 1");
              difficulty = input.nextInt();
              switch (difficulty){
                case 1: difficulty = 1; multiplier = 1; break;
                case 2: difficulty = 2; multiplier = 3; break;
                case 3: difficulty = 3; multiplier = 5; break;
                default: System.out.println("Invalid Input"); break;
              }
            }
            else if(user == 3){
              System.out.println("\n1. Enter an amount you want to bet");
              System.out.println("2. Choose either a Row or a Coulmn");
              System.out.println("3. flip over all 4 cards in your selected Row/Coulmn");
              System.out.println("4. if there is at least 1 bomb, you lose");
              System.out.println("5. if there is No bombs you win");
            }
            else if(user == 4){
              System.exit(0);
            }
            else{
              System.out.println("Invalid Input");
            }
          }
          while(true){
            while(true){
            System.out.printf("\nHow much would you like to bet? current total = %d \n", total);
              bet = input.nextInt();
              if(bet > total){
                System.out.print("you don't have that much");
                continue;
              }
              else if(bet > 0){
               break;
              }
              else
                System.out.println("invalid input");
            }
            System.out.println("\n      'C1' 'C2' 'C3' 'C4'");
		        System.out.println("      -------------------- ");
		        System.out.println("'R1' | [?]  [?]  [?]  [?] ");
		        System.out.println("'R2' | [?]  [?]  [?]  [?] ");
		        System.out.println("'R4' | [?]  [?]  [?]  [?] ");
		        System.out.println("'R4' | [?]  [?]  [?]  [?] ");
            System.out.print("\n Guess a row or column:");
            input.nextLine();
            String guess = input.nextLine();
            boolean output = true;
            int row = -1;
            int column = -1;
            char board[][] = {{'X','X','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
            if(difficulty == 2){
              board[0][2] = 'X';
            }
            else if(difficulty == 3){
              board[0][2] = 'X';
              board[0][3] = 'X';
            }
            shuffle(board);
            for(int x = 0; x < 1; x++)
            switch (guess.toUpperCase()) {
              case "R1":row = 0; output = checkRow(row, board); break;
              case "R2":row = 1; output = checkRow(row, board); break;
              case "R3":row = 2; output = checkRow(row, board); break;
              case "R4":row = 3; output = checkRow(row, board); break;
              case "C1":column = 0; output = checkColumn(column, board); break;
              case "C2":column = 1; output = checkColumn(column, board); break;
              case "C3":column = 2; output = checkColumn(column, board); break;
              case "C4":column = 3; output = checkColumn(column, board); break;
              default: System.out.println("Invalid input, try again"); x--; guess = input.nextLine(); continue;
            }
            System.out.println();
            print(board);
            if(output == false){
              System.out.println("\nYou Lost");
              System.out.println("Total = " + (total - bet));
              total -= bet; 
            }
            else{
              System.out.println("\nYou Win");
              System.out.println("Total = " + (total + (bet * multiplier)));
              total += (bet * multiplier);
            }
            
            if(total == 0){
              System.out.println("You are broke");
              System.exit(0);
            }
            else{
              System.out.print("\nPlay again with same difficulty? ('Y' for Yes 'N' for No): ");
              String again = input.nextLine();
              if(again.equalsIgnoreCase("Y"))
                continue;
              break;
            }
          }
        }
        }
        public static boolean checkRow(int row, char[][] board){
          boolean output = true;
          for (int i = 0; i < 4; i++) {
            if(board[row][i] == 'X'){
              output = false;
              break;
            }
          }
          return output;
        }
        public static boolean checkColumn(int column, char[][] board){
          boolean output = true;
          for (int i = 0; i < 4; i++) {
            if(board[i][column] == 'X'){
              output = false;
              break;
            }
          }
          return output;
        }
        public static char[][] shuffle(char[][] board){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
              int i1 = (int)(Math.random() * 4);
              int j1 = (int)(Math.random() * 4);
              char temp = board[i][j];
              board[i][j] = board[i1][j1]; 
              board[i1][j1] = temp;
            }
          }
          return board;
        }
        public static void print(char[][] board){
            for (int row = 0; row < 4; row++) {
                for (int column = 0; column < 4; column++) {
                  System.out.print(board[row][column] + " ");
                }
                System.out.println();
              }
        }
    }
