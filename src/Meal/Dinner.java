package Meal;

/**
 * @author Xiaoyuan Lai
 *
 * implement interface Meal
 * generate a meal for dinner
 * Assumption: Dinner is always for to go.
 * Delivery fee is fixed regardless of the mile differences of each customer.
 *
 */
public class Dinner implements Meal {
    private Recipe recipe;
    private MealCategory mealCategory;
    // delivery fee is static to the class so it is fixed.
    private static double deliveryFee = 5.0;

    /**
     * generate a random recipe in the given MealCategory type
     * @param mealCategory
     */
    public Dinner(MealCategory mealCategory) {
        this.mealCategory = mealCategory;
        this.recipe = this.mealCategory.getARecipe();

    }

    /**
     * @return returns the recipe it generate when initialize
     */
    @Override
    public Recipe getRecipe() {
        return this.recipe;
    }

    @Override
    public Integer getCalories() {
        return this.recipe.getCalories();
    }

    /**
     * @return the cost if returns contains the recipe cost and the delivery fee
     */
    @Override
    public double getCost() {
        return this.recipe.getCost() + deliveryFee;


    }

    @Override
    public String getDetails() {
        return this.recipe.getName() + ": " + this.recipe.getDescription() + ", " + this.getCalories() + " calories, " + "$" + this.getCost();
    }

    /**
     * allow to change the static variable deliveryFee
     */
    public static void setDeliveryFee(double fee) {
        deliveryFee = fee;
    }

}
