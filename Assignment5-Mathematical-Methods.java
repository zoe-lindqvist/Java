/* Assignment 5

Programflow

START

1.Print a message to describe that the program will test area and volume methods first.
2.Call the input() method to read radius and height values from the user.
3.1. If the user enters 'q', jump to step 6.
3.2. If the input is invalid, ignore it and repeat step 3.
3.3. If the input is valid, convert negative values to positive using the absolute function.
4. Call the area() and volume() methods with the input values and store the results.
5. Print the results and repeat step 3.
6. Print a message to describe that the program will test the fraction methods next.
7. Call the input() method to read numerator and denominator values from the user.
7.1. If the user enters 'q', jump to step 10.
7.2. If the input is invalid, ignore it and repeat step 7.
7.3. If the input is valid, convert negative values to positive using the absolute function.
8. Call the fraction() method with the input values and store the result.
9. Print the input and call the printFraction() method to print the result, then repeat step 7.

END

@author Zoe Lindqvist, zoelin2
*/


import java.util.Scanner;

public class Main {
  // Declare a static Scanner variable 'userInput' to be used throughout the Main
  // class.
    static Scanner userInput;

    public static void main(String[] args) {
        System.out.println("Assignment 5!");
        // Create a Scanner object for user input
        userInput = new Scanner(System.in);

        int r;
        int h;
      
        // Test of area and volume methods
        System.out.println("\nTest of area and volume methods:");
        // Loop to input radius and height values for testing area and volume methods
        while (true) {
            r = input();
            if (r == -1) {
                break;
            }
            h = input();
            if (h == -1) {
                break;
            }
          
            // Print the calculated values for circle area, cone area, and cone volume
            System.out.printf("r = %d h = %d%n", r, h);
            System.out.printf("Circle area: %.2f%n", area(r));
            System.out.printf("Cone area: %.2f%n", area(r, h));
            System.out.printf("Cone Volume: %.2f%n%n", volume(r, h));
        }

        // Test of the fractional methods
        System.out.println("\nTest of the fractional methods:");
        int numerator;
        int denominator;
        // Loop to input numerator and denominator values for testing fractional methods
        while (true) {
            numerator = input();
            if (numerator == -1) {
                break;
            }
            denominator = input();
            if (denominator == -1) {
                break;
            }
            if (numerator != -1 && denominator != -1) {
              // Print the simplified fraction result
                System.out.printf("%d/%d = ", numerator, denominator);
                printFraction(fraction(numerator, denominator));
                System.out.println();
            }
        }
    }

    // Reads user input and returns a positive integer or -1 for 'q'
    // @return the input number or -1 if the user enters 'q'
  
    public static int input() {
        int number = 0;
     
        while (true) {
            if (userInput.hasNextInt()) {
                number = userInput.nextInt();

                // Skip zeros
                if (number == 0) {
                    continue;
                }

                // Convert negative numbers to positive ones
                if (number < 0 && number != -1) {
                    number = Math.abs(number);
                }

                break;
              
            } else if (userInput.hasNext()) {
                String inString = userInput.next();
                if (inString.equalsIgnoreCase("q")) {
                    number = -1;
                    break;
                }
            }
        }
        return number;
    }

    // Calculates the area of a circle with the given radius
    // @param radius the radius of the circle
    // @return the area of the circle
    public static double area(int radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    // Calculates the lateral surface area of a cone with the given radius and
    // height
    // @param radius the radius of the cone
    // @param height the height of the cone
    // @return the lateral surface area of the cone
    public static double area(int radius, int height) {
        double s = pythagoras(radius, height);
        return Math.PI * radius * s;
    }
  
    // Calculates the hypotenuse of a right-angled triangle using the Pythagorean
    // theorem
    // @param sideA the length of one side
    // @param sideB the length of the other side
    // @return the length of the hypotenuse
    public static double pythagoras(int sideA, int sideB) {
        return Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2));
    }
  
    // Calculates the volume of a cone with the given radius and height
    // @param radius the radius of the cone
    // @param height the height of the cone
    // @return the volume of the cone
    public static double volume(int radius, int height) {
        return (1.0 / 3.0) * Math.PI * Math.pow(radius, 2) * height;
    }

    // Simplifies a fraction and returns the whole part, numerator, and denominator
    // @param numerator the numerator of the fraction
    // @param denominator the denominator of the fraction
    // @return an array containing the whole part, simplified numerator, and
    // simplified denominator
    public static int[] fraction(int numerator, int denominator) {
        if (denominator == 0) return null;
        if (numerator == 0) return new int[]{0, 0, 0};

        int[] result = new int[3];
        result[0] = numerator / denominator;
        result[1] = numerator % denominator;
        result[2] = denominator;

        int gcd = gcd(result[1], result[2]);
        result[1] /= gcd;
        result[2] /= gcd;

        return result;
    }


    // Calculates the greatest common divisor of two integers
    // @param a the first integer
    // @param b the second integer
    // @return the greatest common divisor of a and b
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // Prints the simplified fraction or an error message if the denominator is 0
    // @param parts an array containing the whole part, simplified numerator, and
    // simplified denominator
    public static void printFraction(int[] parts) {
        if (parts == null) {
            System.out.print("Error");
            return;
        }
        if (parts[0] != 0) {
            System.out.print(parts[0]);
        }
        if (parts[1] != 0) {
            System.out.printf(" %d/%d", parts[1], parts[2]);
        } else if (parts[0] == 0) {
            System.out.print("0");
        }
    }
}
