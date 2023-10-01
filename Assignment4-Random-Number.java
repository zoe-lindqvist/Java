/* Assignment 4

Program flow

1.Create a Scanner object to get user input.
2.Ask the user how many random numbers they want to generate.
3.Use a try-catch block to read the user's input and handle any exceptions.
4.Generate the specified number of random integers between 0 and 999 and store them in an array.
5.Separate the random integers into even and odd arrays.
6.Sort the even array in ascending order and the odd array in descending order.
7.Print the generated random numbers, even array, and odd array, along with their respective counts.
8.Close the Scanner object.

@author Zoe Lindqvist, zoelin2
*/

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
      
        // Create a Scanner object for user input
        Scanner userInput = new Scanner(System.in);

        // Declare variables to hold random, even, and odd numbers
        int[] randomArray;
        int randomCount = 0;

        int[] evenArray;
        int evenCount = 0;

        int[] oddArray;
        int oddCount = 0;

        // Loop until user enters a valid integer for the number of random numbers
        while (true) {
            System.out.print("How many random numbers in the range 0 - 999 are desired? ");
            // Try to read an integer from user input, catching any exceptions
            try {
                randomCount = userInput.nextInt();
                userInput.nextLine(); // Clear the newline character

                randomArray = new int[randomCount];
                evenArray = new int[randomCount];
                oddArray = new int[randomCount];

                break;
            } catch (OutOfMemoryError e) {
                System.out.println("I cannot handle that number, try again");
            } catch (InputMismatchException e) {
                System.out.println("I can read only Integers, please enter Integer");
                userInput.nextLine(); // Clear the invalid input
            }
        }
        // Generate random numbers and separate them into even and odd arrays
        for (int i = 0; i < randomCount; i++) {
            randomArray[i] = (int) (Math.random() * 1000);

            if (randomArray[i] % 2 == 0) {
                evenArray[evenCount++] = randomArray[i];
            } else {
                oddArray[oddCount++] = randomArray[i];
            }
        }
        // Print the random numbers and the even and odd arrays, sorted as required
        System.out.println("\nHere are the random numbers:");
        for (int i = 0; i < randomCount; i++) {
            System.out.print(randomArray[i] + " ");
        }
        System.out.println();

        // Bubble Sort evenArray in ascending order
        for (int i = 0; i < evenCount - 1; i++) {
            for (int j = 0; j < evenCount - 1 - i; j++) {
                if (evenArray[j] > evenArray[j + 1]) {
                    int temp = evenArray[j];
                    evenArray[j] = evenArray[j + 1];
                    evenArray[j + 1] = temp;
                }
            }
        }

        // Bubble Sort oddArray in descending order
        for (int i = 0; i < oddCount - 1; i++) {
            for (int j = 0; j < oddCount - 1 - i; j++) {
                if (oddArray[j] < oddArray[j + 1]) {
                    int temp = oddArray[j];
                    oddArray[j] = oddArray[j + 1];
                    oddArray[j + 1] = temp;
                }
            }
        }
        // Print the sorted arrays and the number of even and odd numbers
        System.out.println("\nHere are the random numbers arranged:");
        for (int i = 0; i < evenCount; i++) {
            System.out.print(evenArray[i] + " ");
        }
        System.out.print("- ");
        for (int i = 0; i < oddCount; i++) {
            System.out.print(oddArray[i] + " ");
        }
        System.out.println();

        System.out.printf("Of the above %d numbers, %d were even and %d odd\n", randomCount, evenCount,   
        oddCount);

        userInput.close();
    }
}















