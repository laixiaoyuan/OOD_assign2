package Meal;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Xiaoyuan Lai
 * Take customer order, complete payment progress, and print out invoice
 */
public class DietPlanOrder {
    private String customerName;
    private DietPlan plan;
    private boolean paymentStatus;

    /**
     * place a diet plan order based on the meal type that the customer choose
     *
     * @param customerName
     * @param filename  recipe file name
     * @param mealType  enum: VEGAN, LOWCARB, HIGHCARB
     * @throws IOException
     */
    public DietPlanOrder(String customerName, String filename, MealType mealType) throws IOException {
        this.customerName = customerName;
        Calendar c = Calendar.getInstance();
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        switch(mealType) {
            case VEGAN:
                this.plan = new VeganDietPlan(filename, dayOfWeek);
                break;
            case LOWCARB:
                this.plan = new LowCarbDietPlan(filename, dayOfWeek);
                break;
            case HIGHCARB:
                this.plan = new HighCarbDietPlan(filename, dayOfWeek);
                break;
        }
    }

    public double getCost() {
        return this.plan.getCost();
    }

    /**
     *
     * @param cardName  only accept Visa and MasterCard currently
     * @param cardNumber    will print out a warning if the card number can not be verified
     * @param amount    total cost of the order
     * @return  return true if payment accepted, false if not
     */
    public boolean acceptPayment(String cardName, String cardNumber, double amount) {
        switch (cardName) {
            case "MasterCard":
                if (cardNumber.length() == 16 && cardNumber.charAt(0) == '5' &&
                        Character.getNumericValue(cardNumber.charAt(1)) >= 1 &&
                        Character.getNumericValue(cardNumber.charAt(1)) <= 5) {
                    paymentStatus = true;
                }
                else {
                    System.out.println("Card number invalid!");
                    paymentStatus = false;
                }
                break;
            case "Visa":
                if ((cardNumber.length() == 13 || cardNumber.length() == 16) && cardNumber.charAt(0) == '4') {
                    paymentStatus = true;
                }
                else {
                    System.out.println("Card number invalid!");
                    paymentStatus = false;
                }
                break;
            default:
                System.out.println("Card type not accepted!");
                break;
        }
        return paymentStatus;
    }

    /**
     * if payment is accepted, will print out an invoice
     * that contains customer name, payment date, and the details of the diet plan order
     *
     * detail of diet plan order includes the recipe details of lunch and dinner
     */
    public void generateInvoice() {
        if (!this.paymentStatus) {
            System.out.println("Can't generate invoice because your payment information is invalid!");
            return;
        }
        System.out.println("Total amount will be: " + this.getCost());
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        System.out.println("========INVOICE========");
        System.out.println(this.customerName + "        " + dateFormat.format(date));
        System.out.println(plan.showPlan());
        System.out.println("=======================");
    }
}
