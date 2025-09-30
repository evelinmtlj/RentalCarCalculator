import org.codehaus.groovy.runtime.memoize.StampedCommonCache;

import java.util.Scanner;

public class RentalCarCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // store variables first
        double priceOfBasicCarRentalPerDay = 29.99;
        double priceOfOptionTollTag = 3.95;
        double priceOfOptionGps= 2.95;
        double priceOfOptionsRoadAssistance = 3.95;
        float percentSurchargeForUnderage = .30f;
        int userAgeLimit = 25;
        //

        //what values do i need to get from the user?
        System.out.print("When do you want to rent the car?:  ");
        String pickupDate = scanner.nextLine();


        System.out.print("How many days do you need it?:   ");
        int numberOfDays = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Do you want a tool tag (Y?N): " );
        boolean optionTollTag = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("Do you want a GPS (Y?N): ");
        boolean optionGps = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("Do you want road assistance (Y/N)?: ");
        boolean roadSideAssistance = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("How old are you? ");
        int age = scanner.nextInt();
        scanner.nextLine();



                //what needs to be calculated

        double basicCarRentalAmount = numberOfDays * priceOfBasicCarRentalPerDay;

        double optionPerDayCumulative = (optionTollTag)  ? priceOfOptionTollTag : 0;
        optionPerDayCumulative += (optionGps) ? priceOfOptionGps : 0 ;
        optionPerDayCumulative += (roadSideAssistance) ? priceOfOptionsRoadAssistance : 0;

        double optionsAmount = optionPerDayCumulative * numberOfDays;

        double underageSurcharge = 0;

        if (age < userAgeLimit) {
            underageSurcharge = basicCarRentalAmount * percentSurchargeForUnderage;

        }

        double totalCost = basicCarRentalAmount + optionsAmount + underageSurcharge;

        //display the results.

System.out.println("Here is the quote for your rental: ");
System.out.printf("Basic Car Rental:    $%.2f\n",basicCarRentalAmount);
System.out.printf("options:             $%.2f\n", optionsAmount);
System.out.printf("Underage surcharge   $%.2f\n", underageSurcharge);
System.out.printf("Total:               $%.2f\n", totalCost);




    }
}
