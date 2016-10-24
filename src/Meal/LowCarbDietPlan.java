package Meal;

import java.io.IOException;

/**
 * @author Xiaoyuan Lai
 *
 * implement interface DietPlan
 * allow user to generate a low carb diet plan for one day
 * One diet plan include both lunch meal and dinner meal
 *
 */
public class LowCarbDietPlan implements DietPlan {
    private Meal lunch;
    private Meal dinner;
    private String filename;
    private String dayOfWeek;
    private MealCategory lowCarbMeal;

    /**
     * generate a lunch meal and a dinner meal randomly for low carb diet
     *
     * if the lunch meal recipe and dinner meal recipe are the same,
     * will re-generate another dinner meal.
     * if consecutively generate same recipe of lunch and dinner for the same day,
     * will print out a warning and stop regenerating. lunch and dinner will be set to null in this case.
     *
     * If the recipe file provided does not have any recipe in it,
     * will print out a warning, and set lunch and dinner to null.
     *
     * @param filename  recipe file
     * @param dayOfWeek from 1 to 7 represent the day of a week from Sunday to Saturday
     * @throws IOException
     *
     */
    public LowCarbDietPlan(String filename, Integer dayOfWeek) throws IOException {
        this.filename = filename;
        switch (dayOfWeek){
            case 1:
                this.dayOfWeek = "Sunday";
                break;
            case 2:
                this.dayOfWeek = "Monday";
                break;
            case 3:
                this.dayOfWeek = "Tuesday";
                break;
            case 4:
                this.dayOfWeek = "Wednesday";
                break;
            case 5:
                this.dayOfWeek = "Thursday";
                break;
            case 6:
                this.dayOfWeek = "Friday";
                break;
            case 7:
                this.dayOfWeek = "Saturday";
                break;
            default:
                this.dayOfWeek = "Invalid day of week";
                break;
        }
        this.lowCarbMeal = new LowCarbMeal();
        this.lowCarbMeal.loadRecipes(this.filename);
        if (this.lowCarbMeal.showRecipes().size() != 0) {
            this.lunch = new Lunch(this.lowCarbMeal);
            this.dinner = new Dinner(this.lowCarbMeal);
            int counter = 0;
            while (counter < 5 && this.lunch.getRecipe().equals(this.dinner.getRecipe())) {
                System.out.println("lunch and dinner have the same recipe. Regenerating...");
                this.dinner = new Dinner(this.lowCarbMeal);
                counter++;
                if (counter == 5) {
                    System.out.println("Can't generate two different recipes for lunch and dinner.");
                    this.lunch = null;
                    this.dinner = null;
                }
            }
        }
        else {
            System.out.println("Can not show Lunch and Dinner plan with no recipes!");
        }
    }

    /**
     * If both lunch and dinner have valid recipe data,
     * will return a string that contains the lunch details, dinner details and the day of week
     * Otherwise no plan will be shown
     */
    @Override
    public String showPlan() {
        if (lunch != null && dinner != null) {
            String plan = "Lunch ---- " + this.lunch.getDetails() + "\n" + "Dinner ---- " + this.dinner.getDetails() + "\n" + this.dayOfWeek;
            return plan;
        }
        return "Can't show plan!";
    }

    /**
     * If both lunch and dinner have valid recipe data,
     * will provide a sum of total cost of lunch and dinner
     * Otherwise will return 0
     */
    @Override
    public double getCost() {
        if (lunch != null && dinner != null) {
            return lunch.getCost() + dinner.getCost();
        }
        return 0;
    }
}
