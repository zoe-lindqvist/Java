/* Assignment 6 

Program flow

1.Initialize variables and arrays for articles, sales, and sales dates.
2.Display a menu with options for the user to choose from.
3.Depending on the user's choice, perform the following actions:
a. Insert articles:
i. Ask for the number of articles to insert.
ii. Check if there's enough space in the array, and expand it if necessary.
iii. Add the new articles with their quantities and prices.
b. Remove an article:
i. Ask for the article number to remove.
ii. Remove the article if it exists.
c. Display a list of articles: Print the current list of articles with their article numbers, quantities, and prices.
d. Register a sale:
i. Ask for the article number and quantity to sell.
ii. Update the article's quantity and register the sale.
e. Display order history: Print a list of sales with their dates, article numbers, quantities, and amounts.
f. Sort and display order history table: Sort the sales table by article number and display the sorted table.
g. Quit: Exit the program.
This loop continues until the user chooses to quit the program.
@author Zoe Lindqvist, zoelin2
*/



import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;


public class Main {

    // Declare a Scanner object for reading user input
    static Scanner userInput = new Scanner(System.in);
    // Main method
    public static void main(String[] args) {
        // Declare and initialize variables and arrays
        int[][] articles = new int[10][3];
        int[][] sales = new int[1000][3];
        Date[] salesDate = new Date[1000];
        int articleNumber = 1000;
        int noOfArticles = 0;
      
        // Main loop for menu user interface
        while (true) {
            int choice = menu();
            switch (choice) {
                case 1:
                    // Insert articles
                    System.out.print("\nEnter the number of articles to insert: ");
                    int numberOfArticlesToAdd = input();
                    articles = checkFull(articles, noOfArticles + numberOfArticlesToAdd);
                    noOfArticles += numberOfArticlesToAdd;
                    articles = insertArticles(articles, articleNumber, numberOfArticlesToAdd);
                    articleNumber += numberOfArticlesToAdd;
                    break;
                case 2:
                    // Remove an article
                    removeArticle(articles);
                    break;
                case 3:
                    // Display a list of articles
                    printArticles(articles);
                    break;
                case 4:
                    // Register a sale
                    sellArticle(sales, salesDate, articles);
                    break;
                case 5:
                    // Display order history
                    printSales(sales, salesDate);
                    break;
                case 6:
                    // Sort and display order history table
                    sortedTable(sales, salesDate);
                    break;
                case 7:
                    // Quit the program
                    System.out.println("\nExiting program...");
                    return;
            }
        }
    }

    /**
     * Displays the menu and returns the user's choice.
     * @return the integer representing the user's choice.
     */
    public static int menu() {
        System.out.println("\n1. Insert articles");
        System.out.println("2. Remove an article");
        System.out.println("3. Display a list of articles");
        System.out.println("4. Register a sale");
        System.out.println("5. Display order history");
        System.out.println("6. Sort and display order history table");
        System.out.println("7. Quit");
        System.out.print("Ditt val: ");
        return input();
    }
  
    /**
     * Reads and returns an integer from the user input.
     * @return the integer entered by the user.
     */
    public static int input() {
        // Keep looping until the user provides a valid integer input.
        while (!userInput.hasNextInt()) {
            // If the user input is not an integer, display an error message.
            System.out.print("\nInvalid input, please enter an integer: ");
            userInput.next();
        }
        // If the user input is a valid integer, return it.
        return userInput.nextInt();
    }
  
  /**
     * Checks if there are enough slots in the articles array for the new articles.
     * If there are not enough slots, expands the array.
     * @param articles    the array of articles.
     * @param noOfArticles the number of new articles to add.
     * @return the original or expanded articles array.
     */
  public static int[][] checkFull(int[][] articles, int noOfArticles) {
    // Declare an integer variable to count the number of free slots in the array.
    int freeSlots = 0;
    // Iterate through the rows of the 'articles' array.
    for (int i = 0; i < articles.length; i++) {
        if (articles[i][0] == 0) {
            freeSlots++;
        }
    }
     // Check if the number of free slots is less than the required number of articles.
    if (freeSlots < noOfArticles) {
        // If not enough free slots, print a message indicating the shortage.
        System.out.println("There are not enough free slots");
        System.out.println("I need to expand the array by " + (noOfArticles - freeSlots));
        // Expand the 'articles' array using the 'expandArray()' method.
        return expandArray(articles, noOfArticles - freeSlots);
    }
    // If there are enough free slots, return the 'articles' array unchanged.
    return articles;
}
  
/**
     * Expands the articles array by the specified size.
     * @param articles the original articles array.
     * @param size     the number of additional slots needed.
     * @return the expanded articles array.
     */
public static int[][] expandArray(int[][] articles, int size) {
    // Create a new 2D integer array named 'tempArticles' with the increased number of rows
    // (original array length + 'size') and the same number of columns (3).
    int[][] tempArticles = new int[articles.length + size][3];
  
    // Copy the elements from the original 'articles' array into the new 'tempArticles' array.
    System.arraycopy(articles, 0, tempArticles, 0, articles.length);
    // Return the expanded 'tempArticles' array.
    return tempArticles;
}

   /**
     * Inserts new articles into the articles array.
     * @param articles the array of articles.
     * @param articleNumber the starting article number.
     * @param numberOfArticlesToAdd the number of articles to insert.
     * @return the updated articles array with new articles added.
     */
    public static int[][] insertArticles(int[][] articles, int articleNumber, int noOfArticles) {
        // Iterate through the specified number of articles to insert.
        for (int i = 0; i < noOfArticles; i++) {
            System.out.print("\nEnter the quantity for article " + articleNumber + ": ");
            // Call the 'input()' method to read the user's input as an integer for quantity.
            int quantity = input();
            System.out.print("\nEnter the price for article " + articleNumber + ": ");
            // Call the 'input()' method to read the user's input as an integer for price.
            int price = input();

            // Insert the current article's data (articleNumber, quantity, price) into the 'articles' array.
            // The row index is calculated as (articleNumber - 1000).
            articles[articleNumber - 1000] = new int[]{articleNumber, quantity, price};
            articleNumber++;
        }
        return articles;
    }

    /**
     * Removes an article from the articles array.
     * @param articles the array of articles.
     */
    public static void removeArticle(int[][] articles) {
        System.out.print("\nEnter the article number to remove: ");
        int articleNumberToRemove = input();
        // Calculate the index of the article in the 'articles' array (articleNumber - 1000).
        int index = articleNumberToRemove - 1000;
        // Check if the index is within the bounds of the array and the article exists at that index.
        if (index >= 0 && index < articles.length && articles[index][0] != 0) {
            articles[index] = new int[]{0, 0, 0};
            System.out.println("Article " + articleNumberToRemove + " removed.");
        } else {
            // If the article is not found, print a message to inform the user.
            System.out.println("Article not found.");
        }
    }
  
      /**
     * Prints the list of articles.
     * @param articles the array of articles.
     */
       public static void printArticles(int[][] articles) {
        System.out.println("\nArticle Number\tQuantity\tPrice");
        for (int[] article : articles) {
            if (article[0] != 0) {
                System.out.println("\t\t" + article[0] + "\t\t" + article[1] + "\t\t" + article[2]);
            }
        }
    }
  
    /**
     * Registers the sale of an article.
     *
     * @param sales    the array of sales records.
     * @param salesDate the array of sales dates.
     * @param articles the array of articles.
     */
    public static void sellArticle(int[][] sales, Date[] salesDate, int[][] articles) {
        System.out.print("\nEnter the article number to sell: ");
        // Call the 'input()' method to read the user's input as an integer for the article number to sell.
        int articleNumberToSell = input();
        System.out.print("\nEnter the quantity to sell: ");
         // Call the 'input()' method to read the user's input as an integer for the quantity to sell.
        int quantityToSell = input();

        // Calculate the index of the article in the 'articles' array (articleNumber - 1000).
        int index = articleNumberToSell - 1000;

        // Check if the index is within the bounds of the array, the article exists at that index,
        // and there is enough stock to sell the requested quantity.
        if (index >= 0 && index < articles.length && articles[index][0] != 0 && articles[index][1] >= quantityToSell) {

            // Update the stock in the 'articles' array by subtracting the quantity to sell.
            articles[index][1] -= quantityToSell;

             // Calculate the sale amount by multiplying the quantity to sell by the article price.
            int saleAmount = quantityToSell * articles[index][2];

            // Iterate through the 'sales' array to find the first free slot.
            for (int i = 0; i < sales.length; i++) {
                if (sales[i][0] == 0) {
                    sales[i] = new int[]{articleNumberToSell, quantityToSell, saleAmount};
                    salesDate[i] = new Date();
                    break;
                }
            }
        } else {
            // If there is not enough stock or the article is not found, print a message to inform the user.
            System.out.println("Not enough stock or article not found.");
        }
    }
  
     /**
     * Prints the sales records.
     * @param sales     the array of sales records.
     * @param salesDate the array of sales dates.
     */
    public static void printSales(int[][] sales, Date[] salesDate) {
    // Create a SimpleDateFormat object with the format "yyyy-MM-dd" to format the dates.
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    System.out.println("\nDate\tArticleNumber\tQuantity\tAmount");
    for (int i = 0; i < sales.length; i++) {
        if (sales[i][0] != 0) {
            System.out.printf("%s\t%-15d%-15d%-10d%n", dateFormat.format(salesDate[i]), sales[i][0], sales[i][1], sales[i][2]);
        }
    }
}

/**
     * Sorts and prints the sales records.
     * @param sales     the array of sales records.
     * @param salesDate the array of sales dates.
     */
public static void sortedTable(int[][] sales, Date[] salesDate) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    int[][] sortedSales = new int[sales.length][3];
    Date[] sortedSalesDate = new Date[salesDate.length];

    // Copy the content of the original 'sales' array into the new 'sortedSales' array.
    System.arraycopy(sales, 0, sortedSales, 0, sales.length);
    // Copy the content of the original 'salesDate' array into the new 'sortedSalesDate' array.
    System.arraycopy(salesDate, 0, sortedSalesDate, 0, salesDate.length);
  

    // Sort sales history by article number using a simple Bubble sort
    for (int i = 0; i < sortedSales.length - 1; i++) {
        for (int j = i + 1; j < sortedSales.length; j++) {
            if (sortedSales[i][0] > sortedSales[j][0]) {
                int[] tempSale = sortedSales[i];
                Date tempDate = sortedSalesDate[i];
                sortedSales[i] = sortedSales[j];
                sortedSalesDate[i] = sortedSalesDate[j];
                sortedSales[j] = tempSale;
                sortedSalesDate[j] = tempDate;
            }
        }
    }
  
    // Print the sorted sales history
    System.out.println("\nDate\tArticleNumber\tQuantity\tAmount");
    for (int i = 0; i < sortedSales.length; i++) {
        if (sortedSales[i][0] != 0) {
            System.out.printf("%s\t%-15d%-15d%-10d%n", dateFormat.format(sortedSalesDate[i]), sortedSales[i][0], sortedSales[i][1], sortedSales[i][2]);


            }
        }
    }
}

