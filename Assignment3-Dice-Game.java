/* Assignment 3
This is a game that consists of three dice rolls and involves getting a sum of 12 across three rolls of dice in each round. Each dice can only be rolled once per round.

In each round, the player must be able to choose (by pressing on keyboard) between:
1 to roll the dice 1
2 to roll the dice 2
3 to roll the dice 3
q to exit the game

Program flow

1. Declare constants for the game, such as WIN_SUM and DICE_ROLLS.
2. Initialize variables to track the player's wins, losses, and whether the game is over.
3. Display a welcome message to the player.
4. Create a Scanner object to read the player's input.
5. Begin the game loop and initialize variables for this round, such as the values of the three dice and whether each dice has been used.
6. For each roll in the current round, prompt the player for which dice they want to roll and check if the input is valid.
7. If the player wants to quit, end the game.
8. Roll the selected dice and display the result.
9. Calculate the sum of the three dice and display the sum and whether the player won or lost.
10. Update the win/loss count.
11. Display a message for the next round.
12. If the game is over, display the final win/loss counts and end the program.

@author Zoe Lindqvist, zoelin2
*/

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

  // Declare constants
    
  final int WIN_SUM = 12;
  final int DICE_ROLLS = 3;
    
  // Declare variables 

  int wins = 0;
  int losses = 0;
  boolean gameOver = false;
    
  // Display welcome message
    
  System.out.println("\nWelcome to dice game 12. You must roll 1-3 dice and try to get the sum of 12 ...\n");

  // Create a Scanner object to read user input
    
  Scanner userInput = new Scanner(System.in); 

  // Loop until game over

  while (!gameOver) {
      
  // Initialize variables for this round
    
 int dice1Value = 0;
 int dice2Value = 0;
 int dice3Value = 0;
 boolean dice1Rolled = false;
 boolean dice2Rolled = false;
 boolean dice3Rolled = false;

// Loop for each roll

  for (int roll = 1; roll <= DICE_ROLLS; roll++) {
      boolean validInput = false;
      int diceIndex = -1;
    
// Loop until user enters valid input
     
  while (!validInput) {
     
// Prompt user for dice choice
 
  System.out.print("Enter which dice you want to roll [1, 2, 3] (exit with q): ");
  String input = userInput.nextLine(); 

  // Check if user wants to quit
 
  if (input.equalsIgnoreCase("q")) {
      gameOver = true;
      System.out.println("\n#win: " + wins + " #loss: " + losses + "\nGame Over!");
   
      return;   
  }
           
 // Parse input as integer

  int tempIndex = -1;
  boolean invalidInput = false;
  for (int i = 0; i < input.length(); i++) {
      if (!Character.isDigit(input.charAt(i))) {
          System.out.println("Sorry, that is an invalid entry. Try again. Valid entries are 1, 2, 3, and q\n");
          invalidInput = true;
          break;
      }
  }


  if (invalidInput) {
      continue;
  } else {
      tempIndex = Integer.parseInt(input) - 1;
  }

  // Check if input is valid

  if (tempIndex < 0 || tempIndex >= DICE_ROLLS) {
      System.out.println("Sorry, that is an invalid entry. Try again. Valid entries are 1, 2, 3, and q");
  } else if (tempIndex == 0 && dice1Rolled) {
      System.out.println("Sorry, you have already rolled that dice. Try again");
  } else if (tempIndex == 1 && dice2Rolled) {
      System.out.println("Sorry, you have already rolled that dice. Try again");
  } else if (tempIndex == 2 && dice3Rolled) {
      System.out.println("Sorry, you have already rolled that dice. Try again");
  } else {
      validInput = true;
      diceIndex = tempIndex;
    }
  }


  // Roll the selected dice and display the result
 
  int rollValue = (int) (Math.random() * 6) + 1;
  if (diceIndex == 0) {
      dice1Value = rollValue;
      dice1Rolled = true;
  } else if (diceIndex == 1) {
      dice2Value = rollValue;
      dice2Rolled = true;
  } else {
      dice3Value = rollValue;
      dice3Rolled = true;
  }


 System.out.print(rollValue + " "); 
 
}
    // Calculate the sum of the dice
  
      int sum = dice1Value + dice2Value + dice3Value; 

    // Display the sum and update win/loss counts
  
    System.out.printf("%d %d sum: %d #win: %d #loss: %d%n", dice1Value, dice2Value, dice3Value, sum, wins, ++losses);

        if (sum == WIN_SUM) {
            wins++;
            System.out.println("You won!!\n");
            } else if (sum > WIN_SUM) {
            losses++;
            System.out.println("You lost!!\n");
            } else {
            System.out.println("You neither won nor lost the game.\n");
          
        } 

      // Display message for next round
  

      System.out.println("Next round!\n");
     
    } 
          
    userInput.close();  //Close Scanner object
    
  }
}
