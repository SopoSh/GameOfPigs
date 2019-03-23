package gameofpigs;
import java.util.Scanner;
import java.util.Random;
public class GameOfPigs{
 public static void main (String [] args){
    Scanner scan = new Scanner (System.in);
    Random rand1 = new Random(140L);
    Random rand2 = new Random (340L);
    Random decision = new Random (140L);
    boolean playerTurn = true;
    
    if ((decision.nextInt(2)) == 0) {
            playerTurn = false;
        }
    
      System.out.print("Welcome of the Game of Pigs\n");
      System.out.println();
  
      int playerScore = 0;
      int playerTotal=0;
      int computerScore=0;
      int computerTotal=0;
      int diceNumber1;
      int diceNumber2;
      int scanNumber;
      int addedNumber=0;
      int computerAdded=0;
   while(computerTotal < 100 && playerTotal <100){
      
      while(playerTurn = true){
         
      diceNumber1 = rand1.nextInt(6)+1;
      diceNumber2 = rand2.nextInt(6)+1;
      int sum = diceNumber1+diceNumber2;
      
      System.out.println("Your turn (current points: "+ playerTotal + ")");
        if (diceNumber1==1 && diceNumber2==1){
         System.out.println("You rolled " + diceNumber1 + " and " + diceNumber2 + 
         " your turn is over and your total is reset to 0");
         playerTotal=0;
         playerTurn = false;
         computerAdded=0;
         break;
        }
       else if((diceNumber1 == 1 && diceNumber2 != 1) || (diceNumber2 == 1 && diceNumber1 != 1)){
           System.out.println("You rolled " + diceNumber1 + " and " + diceNumber2 +  
           ", no points earned and computer's turn");
           playerTurn=false;
                    computerAdded=0;

           break;
           }
         else{
           addedNumber += sum;
            System.out.println("You rolled " + diceNumber1 + " and " + diceNumber2 + ", points earned this turn:" + addedNumber);
            System.out.println("Press 0 to roll again or 1 to start computer's turn");
            scanNumber = scan.nextInt();
            
            if(scanNumber==1){
                playerTotal+=addedNumber;
                if(playerTotal>=100)
                break;
                else{
                playerTurn=false;
                addedNumber=0;
               computerAdded=0;
               break;
                }
               }
            }
      }
      while(!playerTurn){
            
      diceNumber1 = rand1.nextInt(6)+1;
      diceNumber2 = rand2.nextInt(6)+1;
      int sum = diceNumber1+diceNumber2;
      
         System.out.println("Computer's turn (current points: "+ computerTotal + ")");
        if (diceNumber1==1 && diceNumber2==1){
         System.out.println("Computer rolled two ones, points reset and your turn");
         addedNumber=0;
         computerTotal=0;
         playerTurn=true;
         break;
        }
       else if((diceNumber1 == 1 && diceNumber2 != 1) || (diceNumber2 == 1 && diceNumber1 != 1)){
           System.out.println("Computer rolled " + diceNumber1 + " and " + diceNumber2 +  
           ", no points earned and your turn");
           playerTurn=true;
           addedNumber=0;
           break;
           }
         else{
            computerAdded += sum;
            System.out.println("Computer rolled " + diceNumber1 + " and " + diceNumber2 + ", points earned this turn:" + computerAdded);
             int choice = decision.nextInt(2);
                  System.out.println("The computer selected choice " + choice);
            if(choice == 1){
                     computerTotal += computerAdded;
                     playerTurn= true;
                     computerAdded=0;
                     addedNumber=0;
                     break;
                  }
            }
      }
   }
   
   if (playerTotal >= 100) {
            System.out.println("Congratulations! You won!");
        }
        else {
            System.out.println("Too Bad, the computer won.");
        }
 }
}
