import CustomerView.CustomerView;

import java.io.IOException;

/**
 * @author Xiaoyuan Lai
 */
public class Main {

    public static void main(String[] args) throws IOException {

        // this is the customer view of the application
        System.out.println("********Customer View********");
        CustomerView customerView = new CustomerView();
        customerView.customerView();
        System.out.println("*********************************");


        // the following is for automation test
/*
        TestCase testCase = new TestCase();

        System.out.println("********Test MealCategoty********");
        testCase.testMealCategory();
        System.out.println("*********************************");

        System.out.println("************Test Meal************");
        testCase.testMeal();
        System.out.println("*********************************");

        System.out.println("**********Test Diet Plan**********");
        testCase.testDietPlan();
        System.out.println("*********************************");

        System.out.println("*******Test Diet Plan Order*******");
        testCase.testDietPlanOrder();
        System.out.println("*********************************");
*/
    }
}

