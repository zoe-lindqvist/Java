/** Assignment 2

This program calculates how much money your solar cells generate per day based on the hours of sunshine.

The two main math equations are: 
    1) production (in kWh) = SOLAR_RADIATION * EFFICIENCY * PANEL_AREA * hours * NUM_OF_PANELS / 1000; 
    //Note the equation in instruction is in Wh, so we divide by 1000 to get kWh as price is per kWh
    2) value = production * ELECTRIC_PRICe
    where,
    NUM_OF_PANELS = 26;
    PANEL_HEIGHT = 1; //Units is meters, so no conversion is needed as SOLAR_RADIATION is per m^2
    SOLAR_RADIATION = 166; //this is in Wh units, hence divide by 1000 in eq 1 above to convert to kWh
    PANEL_WIDTH = 1.7; //Units is meters, so no conversion is needed as SOLAR_RADIATION is per m^2
    PANEL_AREA = PANEL_WIDTH * PANEL_HEIGHT;
    EFFICIENCY = 0.2; //(instruction says 20 percent efficiency, so, 20/100 = 0.2)
    ELECTRIC_PRICE = 0.9; //this is per kWh, so we calculate production in kWh in eq 1 

Program flow

1. Prompt the user to enter the date in the format mm-dd.
2. Check that the entered date is in June or July, and prompt the user to re-enter if not.
3. Prompt the user to enter the time of sunrise in the format hh:mm.
4. Check that the entered time is valid and prompt the user to re-enter if not.
5. Prompt the user to enter the time of sunset in the format hh:mm.
6. Check that the entered time is valid and later than the time of sunrise, and prompt the user to re-enter if not.
7. Calculate the number of hours of sunshine by subtracting the time of sunrise from the time of sunset.
8. Calculate the production output by multiplying the solar radiation, efficiency, surface area, and hours of sunshine.
9. Calculate the profit(value) by multiplying the production output by the electricity price.
10. Print the number of hours of sunshine, production output, and profit to two decimal places using printf.

@author Zoe Lindqvist, zoelin2
*/


import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

// Declare constants 
    
  final double EFFICIENCY = 0.2;
  final double ELECTRICITY_PRICE = 0.9;
  final double PANEL_WIDTH = 1.7;
    
  final int NUM_OF_PANELS = 26;
  final int PANEL_HEIGHT = 1;  
  final int SOLAR_RADIATION = 166;  
  final int DAYS_IN_JUNE_MAX = 30;
  final int DAYS_IN_JULY_MAX = 31;

 // Declare variables 
    
  int month = 0; 
  int day = 0; 
  int sunriseHour = 0; 
  int sunriseMinute = 0; 
  int sunsetHour = 0;
  int sunsetMinute = 0;
  double sunHours = 0;
  double production = 0;
  double value = 0; 

  //Create a Scanner object to read user input

  Scanner input = new Scanner(System.in);

  System.out.print("Enter today's date [mm-dd]> ");
  String date = input.nextLine();
  Scanner date_convert = new Scanner(date).useDelimiter("-");
    
   month = date_convert.nextInt();   
   day = date_convert.nextInt();

    
  // Validate the entered date is in June or July
  if (month < 6 || month > 7) {
    System.out.println("Invalid entry! Month can be June or July.");
    System.exit(1);
  }

  // Validate the entered date is within bounds
  if (day < 1 ||  (month == 6 && day > DAYS_IN_JUNE_MAX) || (month == 7 && day > DAYS_IN_JULY_MAX)) {
    System.out.println("Invalid date, Valid dates for June are 1 - 30 days.");
    System.exit(1);
  }

  System.out.print("Enter the time of sunrise [hh:mm]> ");
  String sunrise_hour= input.nextLine();
  Scanner hour_convert = new Scanner(sunrise_hour).useDelimiter(":");
  
  sunriseHour = hour_convert.nextInt();
  sunriseMinute = hour_convert.nextInt();

  // Validate the entered sunrise hour is between 0 and 23
  if (sunriseHour < 0 || sunriseHour > 23) {
    System.out.println("Invalid hour, valid hours are 0 - 23.");
    System.exit(1);
  }

  // Validate the entered sunrise minute is between 0 and 59
  if (sunriseMinute < 0 || sunriseMinute > 59) {
    System.out.println("Invalid minutes, valid minutes are 0 - 59.");
    System.exit(1);
  }

  System.out.print("Enter the time of sunset [hh:mm]> ");
  String sunset_hour = input.nextLine();
  Scanner sunset_hour_convert = new Scanner(sunset_hour).useDelimiter(":");
    
  sunsetHour = sunset_hour_convert.nextInt();
  sunsetMinute = sunset_hour_convert.nextInt();

  // Validate the entered sunset hour is between 0 and 23
  if (sunsetHour < 0 || sunsetHour > 23) {
    System.out.println("Invalid hour, valid hours are 0 - 23.");
    System.exit(1);
  }

  // Validate the entered sunset minute is between 0 and 59
  if (sunsetMinute < 0 || sunsetMinute > 59) {
    System.out.println("Invalid minutes, valid minutes are 0 - 59.");
    System.exit(1);
  }

  // Validate that sunset is later than sunrise
  if (sunsetHour < sunriseHour || (sunsetHour == sunriseHour && sunsetMinute <= sunriseMinute)) {
     System.out.println("Sunrise cannot be after sunset on a given day.");
     System.exit(1);
  }

  // Calculate the number of sun hours
  sunHours = (sunsetHour - sunriseHour) + (sunsetMinute - sunriseMinute) / 60.0;

  // Calculate the production output
  production= SOLAR_RADIATION * EFFICIENCY * (PANEL_HEIGHT * PANEL_WIDTH) * sunHours * NUM_OF_PANELS / 1000;
    
  // Calculate the value of the production output
  value = production * ELECTRICITY_PRICE;

  // Present the results to two decimal places
  System.out.printf("Sun hours: %.2f hours\n", sunHours);
  System.out.printf("The production on %d/%d is: %.2f kWh to a value of: SEK %.2f\n", month, day, production, value);

    
  input.close();
  hour_convert.close();
  sunset_hour_convert.close();
  date_convert.close();
    
 }
}


