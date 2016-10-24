package CustomerView;

import Meal.DietPlanOrder;
import Meal.MealType;

import java.io.IOException;
import java.util.Scanner;
import java.util.jar.Pack200;

/**
 * Created by Lexie on 10/23/16.
 */
public class CustomerView {
    public void customerView() throws IOException {
        System.out.print("Enter your name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.print("Choose your meal type from VEGAN, LOWCARB, or HIGHCARB: ");
        String mealTypeString = scanner.nextLine();
        while (!mealTypeString.equalsIgnoreCase("VEGAN") && !mealTypeString.equalsIgnoreCase("LOWCARB") &&
                !mealTypeString.equalsIgnoreCase("HIGHCARB")) {
            System.out.println("You must enter one of the three meal types: VEGAN, LOWCARB, or HIGHCARB!");
            System.out.print("Choose your meal type from VEGAN, LOWCARB, or HIGHCARB: ");
            mealTypeString = scanner.nextLine();
        }

        MealType mealType;
        String fileName;
        if (mealTypeString.equalsIgnoreCase("VEGAN")) {
            mealType = MealType.VEGAN;
            fileName = "src/TestCase/vegan recipes";
        }
        else if (mealTypeString.equalsIgnoreCase("LOWCARB")) {
            mealType = MealType.LOWCARB;
            fileName = "src/TestCase/low-carb recipes";
        }
        else {
            mealType = MealType.HIGHCARB;
            fileName = "src/TestCase/high-carb recipes";
        }

        DietPlanOrder planOrder = null;

        planOrder = new DietPlanOrder(name, fileName, mealType);


        System.out.print("Please select the type of your credit card from VISA or MASTERCARD: ");
        String cardType = scanner.nextLine();
        while (!cardType.equalsIgnoreCase("MASTERCARD") && !cardType.equalsIgnoreCase("VISA")) {
            System.out.println("You can only choose to pay by MASTERCARD or VISA.");
            System.out.print("Please select the type of your credit card from VISA or MASTERCARD: ");
            cardType = scanner.nextLine();
        }
        if (cardType.equalsIgnoreCase("MASTERCARD")) {
            cardType = "MasterCard";
        }
        else {
            cardType = "Visa";
        }

        System.out.print("Please enter your card number: ");
        String cardNumber = scanner.nextLine();
        double cost = planOrder.getCost();
        boolean paySuccessful = planOrder.acceptPayment(cardType, cardNumber, cost);

        while (!paySuccessful) {
            System.out.print("Please enter your card number: ");
            cardNumber = scanner.nextLine();
            paySuccessful = planOrder.acceptPayment(cardType, cardNumber, cost);
        }
        if (paySuccessful) {
            System.out.print("Payment approved. Do you want to get invoice?");
            String generateInvoice = scanner.nextLine();
            if (generateInvoice.equalsIgnoreCase("YES")) {
                planOrder.generateInvoice();
            }
            else {
                System.out.println("Thank you!");
            }
        }

    }
}
