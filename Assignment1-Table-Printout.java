/**
 * Assignment1 - Table print 
 *
 * This program calculates and presents the charging time of an electric car 
 * Battery's capacity = 35.8 kWh 
 * Charging power (W) = current (A) x voltage (V) for (single-phase 230V) 
 * And W = A x V x square_root(3) for (three-phase 400V) 
 * Charging time = Battery capacity (KWh) / Charging power(kWh)
 * 
 * Program flow
 * 
 * 1. List and initiate variables and constants:
 * - batteryCapacity
 * - current
 * - voltage
 * - chargingPower
 * - chargingTime
 *
 * 2. Calculate charging power (W): 
 * if V = 230, then charging power (kW) = current * (A) x voltage (V) / 1000 
 * if V = 400, then charging power (kW) = current (A) x voltage (V) x square root of 3 / 1000
 * 
 * 3. Calculate charging time (h):
 * ChargingTime = battery capacity / charging power
 *
 * 4. Round the floating-point numbers with the Math.round() method
 *
 * 5. Print the result in a table format using the printf() method
 *
 * @author Zoe Lindqvist, zoelin2
 */

 class Main {
    public static void main(String[] args) {

    // Initiate variables and constants
      
    final double BATTERY_CAPACITY = 35.8;
      
    final double CURRENT1 = 10.0;
    final double CURRENT2 = 16.0;
    final double CURRENT3 = 10.0; 
    final double CURRENT4 = 16.0;
    final double CURRENT5 = 32.0;

    final double VOLTAGE1 = 230.0;
    final double VOLTAGE2 = 230.0;
    final double VOLTAGE3 = 400.0;
    final double VOLTAGE4 = 400.0; 
    final double VOLTAGE5 = 400.0;

    double chargingPower1 = 0.0;
    double chargingPower2 = 0.0;
    double chargingPower3 = 0.0;
    double chargingPower4 = 0.0;
    double chargingPower5 = 0.0;
    
    double chargingTime1 = 0.0;
    double chargingTime2 = 0.0;
    double chargingTime3 = 0.0;
    double chargingTime4 = 0.0;
    double chargingTime5 = 0.0;

    // Calculate charging power
      
    chargingPower1 = (CURRENT1 * VOLTAGE1) / 1000;
    chargingPower2 = (CURRENT2 * VOLTAGE2) / 1000;
    chargingPower3 = (CURRENT3 * VOLTAGE3 * Math.sqrt(3)) / 1000;
    chargingPower4 = (CURRENT4 * VOLTAGE4 * Math.sqrt(3)) / 1000;
    chargingPower5 = (CURRENT5 * VOLTAGE5 * Math.sqrt(3)) / 1000;
       
    // Calculate charging time  

    chargingTime1 = BATTERY_CAPACITY / chargingPower1;
    chargingTime2 = BATTERY_CAPACITY / chargingPower2;
    chargingTime3 = BATTERY_CAPACITY / chargingPower3;
    chargingTime4 = BATTERY_CAPACITY / chargingPower4;
    chargingTime5 = BATTERY_CAPACITY / chargingPower5;


    //Rounding scale
      
    int noOfDecimals = 2; 
    double scale = 0; 
    scale = Math.pow (10, noOfDecimals); 

    // Round the floating-point numbers
   
    chargingPower1 = Math.round(chargingPower1 * scale) / scale;
    chargingPower2 = Math.round(chargingPower2 * scale) / scale;  
    chargingPower3 = Math.round(chargingPower3 * scale) / scale;
    chargingPower4 = Math.round(chargingPower4 * scale) / scale;
    chargingPower5 = Math.round(chargingPower5 * scale) / scale;
    
    chargingTime1 = Math.round(chargingTime1 * scale) / scale;
    chargingTime2 = Math.round(chargingTime2 * scale) / scale;
    chargingTime3 = Math.round(chargingTime3 * scale) / scale;
    chargingTime4 = Math.round(chargingTime4 * scale) / scale;
    chargingTime5 = Math.round(chargingTime5 * scale) / scale;

    // print the result in a table format

    System.out.printf("%-1s %-1s %-1s %n", "Battery:", "35.8", "(kWh)");
    System.out.printf("%-1s %-1s %-1s %-1s %n", "Current(A)", "Voltage(V)", "Charging Power(kW)", "Charging Time(h)");
      
    System.out.printf("%-10.2f %-10.2f %-20.2f %-15.2f %n", CURRENT1,  VOLTAGE1, chargingPower1, chargingTime1);
    System.out.printf("%-10.2f %-10.2f %-20.2f %-15.2f %n", CURRENT2,  VOLTAGE2, chargingPower2, chargingTime2);
    System.out.printf("%-10.2f %-10.2f %-20.2f %-15.2f %n", CURRENT3,  VOLTAGE3, chargingPower3, chargingTime3);
    System.out.printf("%-10.2f %-10.2f %-20.2f %-15.2f %n", CURRENT4,  VOLTAGE4, chargingPower4, chargingTime4);
    System.out.printf("%-10.2f %-10.2f %-20.2f %-15.2f %n", CURRENT5,  VOLTAGE5, chargingPower5, chargingTime5);  
      
    }
  }